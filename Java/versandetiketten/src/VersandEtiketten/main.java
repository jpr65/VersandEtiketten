package VersandEtiketten;

import Daten.EtikettVariante1;
import IO.IEtikettDrucker;
import IO.MiddleWareStub;
import Integratoren.IoFactory;
import Integratoren.OperatorFactory;
import Integratoren.VersandEtikettenErsteller;

class JavaMain {
	public static int anzahlEtikettenGedruckt = 0;
	public static int anzahlZeilenBelegt = 0;
	
	public static void main(String[] args) {
		
		leseKundenUndAdressen();
		
		System.out.println("======================================");
		
		VersandEtikettenErsteller versandEtikettenErsteller = new VersandEtikettenErsteller();
		
		printEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", "GER");
		printEtikett(versandEtikettenErsteller, "KUD0002", "ADR001", "GER");
		printEtikett(versandEtikettenErsteller, "FIR0001", "ADR002", "GER");
		printEtikett(versandEtikettenErsteller, "FIR0002", "ADR003", "GER");
		printEtikett(versandEtikettenErsteller, "KUD0003", "ADR004", "GER");
		printEtikett(versandEtikettenErsteller, "KUD0004", "ADR005", "GER");
		printEtikett(versandEtikettenErsteller, "KUD0010", "ADR010", "GBR");
		printEtikett(versandEtikettenErsteller, "KUD0011", "ADR011", "GBR");
		printEtikett(versandEtikettenErsteller, "KUD0020", "ADR020", "ESP");
		printEtikett(versandEtikettenErsteller, "KUD0021", "ADR021", "ESP");
		
		// unbekanntes Land für Formatierung
		printEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", null);
		printEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", "");
		printEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", "AUT");

		// Unbekannte KundeId / AdresseId
		printEtikett(versandEtikettenErsteller, "KUD1001", "ADR001", "GER");
		printEtikett(versandEtikettenErsteller, "KUD0001", "ADR101", "GER");
		
		System.out.println("Anzahl Etiketten (gesamt / gedruckt): " 
				+ versandEtikettenErsteller.getEtikettZaehler()
				+ " / " + anzahlEtikettenGedruckt);
		
		System.out.println("Anzahl Zeilen belegt insgesamt: "
				+ anzahlZeilenBelegt);
		System.out.println("======================================");
		
		//i/ Bis hierhin keine Logik!
		
		// Der Code bis zum Ende der Methode könnte auskommentiert werden,
		// aber dann würde er bei Umbenennungen nicht berücksichtigt.
		
		Boolean erzeugeXmlDatenDateien = false;
		
		if (erzeugeXmlDatenDateien) {
			schreibeKundenUndAdressen();
		}
	}
	
	private static void leseKundenUndAdressen() {
		MiddleWareStub middleWareStub = (MiddleWareStub) IoFactory.getMiddleWare();
		
		//i/ try-catch darf auch im Integrator verwendet werden,
		//i/ da einige Fehler nur hier abgefangen werden können.
		try {
			middleWareStub.LeseKundenAusXml("AlleKunden.xml");
			middleWareStub.LeseAdressenAusXml("AlleAdressen.xml");
		}
		catch (Exception ex) {
			System.out.println("Fehler beim Lesen der Kunden/Adressen");
			System.out.println(ex.getMessage());
			System.out.println("------------------------------------------");
		}
		
	}

	private static void printEtikett(
			VersandEtikettenErsteller versandEtikettenErsteller,
			String KundeId, String AdresseId, String Land) {
		try {
			EtikettVariante1 etikett = versandEtikettenErsteller.versandEtikettVariante1(KundeId, AdresseId, Land, null);
			
			IEtikettDrucker etikettDrucker = OperatorFactory.buildEtikettDrucker();
			etikettDrucker.druckeEtikett(etikett.anschriftZeilen);
			
			anzahlEtikettenGedruckt++;
			anzahlZeilenBelegt += etikett.belegteZeilenAnz();
		}
		catch (Exception ex) {
			System.out.println("Fehler beim Drucken des Etiketts");
			System.out.println(ex.getMessage());
			System.out.println("------------------------------------------");
		}
		
	}
	
	private static void schreibeKundenUndAdressen(){
		MiddleWareStub middleWareStub = new MiddleWareStub();
				
		try {
			middleWareStub.schreibeKunde("KUD0001", "Kunde.xml");
			middleWareStub.schreibeAlleKunden("AlleKunden.xml");
			middleWareStub.schreibeAlleAdressen("AlleAdressen.xml");
		}
		catch (Exception ex) {
			System.out.println("Fehler beim Schreiben der Kunden/Adressen");
			System.out.println(ex.getMessage());
			System.out.println("------------------------------------------");
		}
	}

	

}