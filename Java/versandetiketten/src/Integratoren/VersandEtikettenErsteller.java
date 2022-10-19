package Integratoren;

import java.util.*;

import Daten.*;
import IO.MiddelWareStub;
import Operationen.*; 

//---------------------------------------------------------------------------------
// Integrator, der die Versandetiketten erstellen lässt
//---------------------------------------------------------------------------------
public class VersandEtikettenErsteller {
	
	public int naechsteEtikettNr = 1;
	
	public int GetEtikettZaehler() {
		return this.naechsteEtikettNr - 1;
	}
	
	public MiddelWareStub MWI = new MiddelWareStub();
	
	public EtikettVariante1 VersandEtikettVariante1(String kundeID, String adresseID, String laenderKennung, String weitereID) throws Exception {
		EtikettVariante1 erstelltesEtikett = new EtikettVariante1();
		erstelltesEtikett.EtikettNr = this.naechsteEtikettNr++;
		
		erstelltesEtikett.anschriftZeilen = this.AnschriftErstellung(kundeID, adresseID, laenderKennung);
		
		return erstelltesEtikett;
	}
	
	public List<String> AnschriftErstellung(String kundeID, String adresseID, String laenderKennung) throws Exception {
		Kunde kunde = MWI.LeseKunde(kundeID);
		Adresse adresse = MWI.LeseAdresse(adresseID);
		
		IAnschriftFormatierer anschriftFormatierer = Integratoren.OperatorFactory.BuildAnschriftFormatierer(laenderKennung);
		
		return anschriftFormatierer.AnschriftErstellung(kunde, adresse);
	}
}
