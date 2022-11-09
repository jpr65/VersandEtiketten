package IO;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import Daten.Adresse;
import Daten.Kunde;

//---------------------------------------------------------------------------------
// IO-Stub, der Kunden-Infos und Adressen liefert.
// Diese Daten werden üblicherweise von der Middleware 
// oder einer Persistenz-API bereitgestellt.
// Der Stub wird nur solange benötigt, bis eine Implementierung
// im realen System vorliegt.
//
//i/ Zum Testen der Operations-Klassen "*AnschriftFormatierer" werden weder der Stub
//i/ noch die spätere Implementierung verwendet.
//i/ Die Operations-Klassen haben keinen Zugriff auf die IO-Klassen, das ist nur
//i/ den Integrations-Klassen erlaubt.
//---------------------------------------------------------------------------------
public class MiddleWareStub implements MiddleWareInterface {
	
	//i/ Nur die Stub weiß, wo die Daten liegen!
	private String xmlDataPath = "Z:/user/rp/prj_public/Beispiele/VersandEtiketten/Java/data";
	
	private Dictionary<String, Kunde> kundeDict = new Hashtable<String, Kunde>();
	private Dictionary<String, Adresse> adresseDict = new Hashtable<String, Adresse>();
	
	public Adresse leseAdresse(String adresseID) throws Exception {
		Adresse adresse = adresseDict.get(adresseID);
		
		if (adresse == null) {
			throw new Exception("adresse zu ID " + adresseID + " unbekannt!");
		}
		
		return adresse;
	}
	
	public Kunde leseKunde(String kundeID) throws Exception {
		Kunde kunde = kundeDict.get(kundeID);
		
		if (kunde == null) {
			throw new Exception("kunde zu ID " + kundeID + " unbekannt!");
		}
		
		return kunde;
	}
	
	// Dieser Teil liest aus den XML-Dateien die Kunden und Adressen --------------------------
	
	public void LeseKundenAusXml(String dateiName) {
		XmlReaderStandardJava<List<Kunde>> kundeReader = new XmlReaderStandardJava<List<Kunde>>();
		
		String dateiNameMitPfad = xmlDataPath + "/" + dateiName;
		
		System.out.println("Lese Kunden aus Datei " + dateiNameMitPfad);
		
		List<Kunde> kundeListe = kundeReader.readFromFile(dateiNameMitPfad);
		
		System.out.println(kundeListe.size() + " Kunden gelesen.");
		
		FillKundeDict(kundeListe);
	}

	private void FillKundeDict(List<Kunde> kundeListe) {
		kundeDict = new Hashtable<String, Kunde>();
		
		for (Kunde kunde: kundeListe) {
			kundeDict.put(kunde.PKID, kunde);
		}
	}

	public void LeseAdressenAusXml(String dateiName) {
		XmlReaderStandardJava<List<Adresse>> adresseReader = new XmlReaderStandardJava<List<Adresse>>();
		
		String dateiNameMitPfad = xmlDataPath + "/" + dateiName;
		
		System.out.println("Lese Adressen aus Datei " + dateiNameMitPfad);
		
		List<Adresse> adresseListe = adresseReader.readFromFile(dateiNameMitPfad);
		
		System.out.println(adresseListe.size() + " Adressen gelesen.");
		
		FillAdresseDict(adresseListe);
		
	}

	private void FillAdresseDict(List<Adresse> adresseListe) {
		adresseDict = new Hashtable<String, Adresse>();
		
		for (Adresse adresse: adresseListe) {
			adresseDict.put(adresse.PKID, adresse);
		}
		
	}
	
	// Dieser Teil erzeugt die XML-Dateien für Kunden und Adressen --------------------------
	
	public Adresse LeseAdresseDummy(String adresseID ) throws Exception {
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
	
	public Kunde LeseKundeDummy(String kundeID ) throws Exception {
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
	
	public void schreibeAlleKunden(String dateiName) throws Exception {
		
		String[] kundeIdArr = {	"KUD0001", "KUD0002", "KUD0003", "KUD0004", "FIR0001", "FIR0002", 
								"KUD0010", "KUD0011", "KUD0020", "KUD0021"};
		List<Kunde> kundeListe = new ArrayList<Kunde>() ;
	
		for (String kundeID: kundeIdArr) {
			Kunde kunde = LeseKundeDummy(kundeID);
			kundeListe.add(kunde);
		}
		
		schreibeKunden(kundeListe, dateiName);
	}
	
	public void schreibeKunden(List<Kunde> kundeListe, String dateiName) {
		XmlWriterStandardJava<List<Kunde>> kundeWriter = new XmlWriterStandardJava<List<Kunde>>();
		
		String dateiNameMitPfad = xmlDataPath + "/" + dateiName;
		
		System.out.println("Write " + kundeListe.size() + " Kunden in Datei " + dateiNameMitPfad);
		
		kundeWriter.writeIntoFile(kundeListe, dateiNameMitPfad);
	}
	
public void schreibeAlleAdressen(String dateiName) throws Exception {
		
		String[] adresseIdArr = {	"ADR001", "ADR002", "ADR003", "ADR004", "ADR005", "ADR010", "ADR011", 
									"ADR020", "ADR021", };
		List<Adresse> adresseListe = new ArrayList<Adresse>() ;
	
		for (String adresseID: adresseIdArr) {
			Adresse adresse = LeseAdresseDummy(adresseID);
			adresseListe.add(adresse);
		}
		
		schreibeAdressen(adresseListe, dateiName);
	}
	
	public void schreibeAdressen(List<Adresse> AdresseListe, String dateiName) {
		XmlWriterStandardJava<List<Adresse>> AdresseWriter = new XmlWriterStandardJava<List<Adresse>>();
		
		String dateiNameMitPfad = xmlDataPath + "/" + dateiName;
		
		System.out.println("Write " + AdresseListe.size() + " Adressen in Datei " + dateiNameMitPfad);
		
		AdresseWriter.writeIntoFile(AdresseListe, dateiNameMitPfad);
	}
	
	public void schreibeKunde(String kundeID, String dateiName) throws Exception {
		Kunde kunde = LeseKundeDummy(kundeID);
		schreibeKunde(kunde, dateiName);
	}
	
	public void schreibeKunde(Kunde kunde, String dateiName) {
		XmlWriterStandardJava<Kunde> kundeWriter = new XmlWriterStandardJava<Kunde>();
		
		String dateiNameMitPfad = xmlDataPath + "/" + dateiName;
		
		System.out.println("Write Kunde " + kunde.PKID + " in Datei " + dateiNameMitPfad);
		
		kundeWriter.writeIntoFile(kunde, dateiNameMitPfad);
	}
	
	
}
