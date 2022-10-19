package IO;

import Daten.Adresse;
import Daten.Kunde;

//---------------------------------------------------------------------------------
// IO-Stub, der Kunden-Infos und Adressen liefert
// Diese Daten werden üblicherweise von der Middleware 
// oder einer Persistenz-API bereitgestellt.
//---------------------------------------------------------------------------------
public class MiddelWareStub {
	
	public Adresse LeseAdresse(String adresseID ) throws Exception {
		Adresse dummyAdresse = new Adresse();
		
		dummyAdresse.PKID = adresseID;
		
		if (adresseID == "ADR001") {
			dummyAdresse.PostLeitInfo = "44787";
			dummyAdresse.Ort = "Bochum";
			dummyAdresse.Strasse = "Viktoriastraße";
			dummyAdresse.Hausnummer = "13b";
		}
		else if (adresseID == "ADR002") {
			dummyAdresse.PostLeitInfo = "91055";
			dummyAdresse.Ort = "Erlangen";
			dummyAdresse.Strasse = "Postfach";
			dummyAdresse.Land = "GERMANY";
		}
		else if (adresseID == "ADR003") {
			dummyAdresse.PostLeitInfo = "46397";
			dummyAdresse.Ort = "Bocholt";
			dummyAdresse.Strasse = "Münsterstr.";
			dummyAdresse.Hausnummer = "123";
		}
		else if (adresseID == "ADR004") {
			dummyAdresse.PostLeitInfo = "12359";
			dummyAdresse.Ort = "Berlin";
			dummyAdresse.Strasse = "Alt-Britz";
			dummyAdresse.Hausnummer = "18";
			dummyAdresse.Ortsteil = "Ortsteil Neukoelln";
			dummyAdresse.Land = "GERMANY";
		}
		else if (adresseID == "ADR005") {
			dummyAdresse.PostLeitInfo = "53113";
			dummyAdresse.Ort = "Bonn";
			dummyAdresse.Land = "GERMANY";
			dummyAdresse.PackstationNr = "Packstation 101";
			dummyAdresse.PackstationKundenNr = "1234567";
			dummyAdresse.Land = "GERMANY";
		}
		else if (adresseID == "ADR010") {
			dummyAdresse.PostLeitInfo = "OX14 4PG";
			dummyAdresse.Ort = "ABINGDON";
			dummyAdresse.Hausnummer = "1";
			dummyAdresse.Strasse = "Upper Littleton";
			dummyAdresse.Ortsteil = "Appleford";
			dummyAdresse.Land = "UNITED KINGDOM";
		}
		else if (adresseID == "ADR011") {
			dummyAdresse.PostLeitInfo = "EC1Y 8SY";
			dummyAdresse.Ort = "LONDON";
			dummyAdresse.Hausnummer = "49";
			dummyAdresse.Strasse = "Featherstone Street";
			dummyAdresse.Land = "UNITED KINGDOM";
		}
		else if (adresseID == "ADR020") {
			dummyAdresse.PostLeitInfo = "29400";
			dummyAdresse.Ort = "Marbella";
			dummyAdresse.Hausnummer = "18";
			dummyAdresse.Flur = "4º";
			dummyAdresse.Tuer = "C";
			dummyAdresse.Strasse = "Calle Huertas";
			dummyAdresse.Provinz = "Málaga";
			dummyAdresse.Land = "SPAIN";
		}
		else if (adresseID == "ADR021") {
			dummyAdresse.PostLeitInfo = "09692";
			dummyAdresse.Ort = "CANICOSA DE LA SIERRA";
			dummyAdresse.Hausnummer = "27";
			dummyAdresse.Strasse = "Plaza de las Descalzas";
			dummyAdresse.Ortsteil = "Barrio de San Roque";
			dummyAdresse.Provinz = "BURGOS";
			dummyAdresse.Land = "SPAIN";
		}
		else {
			throw new Exception ("unbekannte Adresse mit ID " + adresseID);
		}
		
		return dummyAdresse;
	}
	
	public Kunde LeseKunde(String kundeID ) throws Exception {
		Kunde dummyKunde = new Kunde();
		
		dummyKunde.PKID = kundeID;
		
		if (kundeID == "KUD0001") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Mustermann";
			dummyKunde.Vorname = "Monika";
		}
		else if (kundeID == "KUD0002") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Titel = "Prof. Dr.";
			dummyKunde.Name = "Staller";
			dummyKunde.Vorname = "Hubert";
		}
		else if (kundeID == "KUD0003") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Schloss Britz";
		}
		else if (kundeID == "KUD0004") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Sommer";
			dummyKunde.Vorname = "Lisa";
		}
		else if (kundeID == "FIR0002") {
			dummyKunde.PrivatKunde = false;
			dummyKunde.Firma = "Bädergalerie Bocholt";
		}
		else if (kundeID == "FIR0001") {
				dummyKunde.PrivatKunde = false;
				dummyKunde.Firma = "Siemens PG";
				dummyKunde.Abteilung = "OI 41";
		}
		else if (kundeID == "KUD0010") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Poppins";
			dummyKunde.Vorname = "Mary";
		}
		else if (kundeID == "KUD0011") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Brown";
			dummyKunde.Vorname = "Walter C.";
		}
		else if (kundeID == "KUD0020") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Casero";
			dummyKunde.Vorname = "Carmen Garcés";
		}
		else if (kundeID == "KUD0021") {
			dummyKunde.PrivatKunde = true;
			dummyKunde.Name = "Cortés";
			dummyKunde.Vorname = "José Ayuso";
		}
		else {
			throw new Exception ("unbekannter Kunde mit ID " + kundeID);
		}
				
		return dummyKunde;
	}
}
