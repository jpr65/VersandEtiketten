package IO;

import Daten.Adresse;
import Daten.Kunde;

// Stub, der Kunden-Infos und Adressen liefert
public class MiddelWareInterface {
	
	public Adresse LeseAdresse(String adresseID ) {
		Adresse dummyAdresse = new Adresse();
		
		dummyAdresse.PKID = adresseID;
		dummyAdresse.PostLeitInfo = "44787";
		dummyAdresse.Ort = "Bochum";
		dummyAdresse.Strasse = "Viktoriastraße";
		dummyAdresse.Hausnummer = "13b";
		
		return dummyAdresse;
	}
	
	public Kunde LeseKunde(String kundeID ) {
		Kunde dummyKunde = new Kunde();
		
		dummyKunde.PKID = kundeID;
		
		dummyKunde.PrivatKunde = true;
		dummyKunde.Name = "Mustermann";
		dummyKunde.Vorname = "Monika";
		
		return dummyKunde;
	}
}
