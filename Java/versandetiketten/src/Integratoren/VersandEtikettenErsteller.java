package Integratoren;

import java.util.*;

import Daten.*;
import IO.MiddleWareInterface;
import Operationen.*; 

//---------------------------------------------------------------------------------
// Integrator, der die Versandetiketten erstellen lässt
//i/ Dieser Integrator enthält weder Logik noch eine Schleife!
//---------------------------------------------------------------------------------
public class VersandEtikettenErsteller {
	
	private int letzteEtikettNr = 0;
	
	public int getEtikettZaehler() {
		return this.letzteEtikettNr;
	}
	
	public MiddleWareInterface middleWare = IoFactory.getMiddleWare();
	
	public EtikettVariante1 versandEtikettVariante1(String kundeID, String adresseID, String laenderKennung, String weitereID) throws Exception {
		EtikettVariante1 erstelltesEtikett = this.erzeugeNeuesEtikett();
		
		erstelltesEtikett.anschriftZeilen = this.anschriftErstellung(kundeID, adresseID, laenderKennung);
		
		return erstelltesEtikett;
	}

	private EtikettVariante1 erzeugeNeuesEtikett() {
		EtikettVariante1 erstelltesEtikett = new EtikettVariante1();
		
		erstelltesEtikett.EtikettNr = ++this.letzteEtikettNr;
		
		return erstelltesEtikett;
	}
	
	public List<String> anschriftErstellung(String kundeID, String adresseID, String laenderKennung) throws Exception {
		Kunde kunde = middleWare.leseKunde(kundeID);
		Adresse adresse = middleWare.leseAdresse(adresseID);
		
		IAnschriftFormatierer anschriftFormatierer = Integratoren.OperatorFactory.buildAnschriftFormatierer(laenderKennung);
		
		return anschriftFormatierer.AnschriftErstellung(kunde, adresse);
	}
}
