package Integratoren;

import java.util.*;

import Daten.*;
import IO.MiddelWareInterface;
import Operationen.*; 

public class VersandEtikettenErstellen {
	
	public MiddelWareInterface MWI = new MiddelWareInterface();
	
	public EtikettVariante1 VersandEtikettVariante1(String kundeID, String adresseID, String laenderKennung, String weitereID) {
		EtikettVariante1 erstelltesEtikett = new EtikettVariante1();
		erstelltesEtikett.anschriftZeilen = this.AnschriftErstellung(kundeID, adresseID, laenderKennung);
		
		return erstelltesEtikett;
	}
	
	public List<String> AnschriftErstellung(String kundeID, String adresseID, String laenderKennung) {
		Kunde kunde = MWI.LeseKunde(kundeID);
		Adresse adresse = MWI.LeseAdresse(adresseID);
		
		IAnschriftFormatierer anschriftFormatierer = Integratoren.OperatorFactory.BuildAnschriftFormatierer(laenderKennung);
		
		return anschriftFormatierer.AnschriftErstellung(kunde, adresse);
	}
}
