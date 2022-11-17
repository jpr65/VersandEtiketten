package IO;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;
import IO.API.XmlReaderStandardJava;

//---------------------------------------------------------------------------------
// IO-Klasse, die Kunden-Infos und Adressen aus XML-Dateien einliest
//---------------------------------------------------------------------------------
public class KundenUndAdressenReader {
	
	public List<Kunde> LeseKundenAusXml(String dateiName) {
		XmlReaderStandardJava<List<Kunde>> kundeReader = new XmlReaderStandardJava<List<Kunde>>();
		
		String dateiNameMitPfad = IoConfig.getStubXmlDataPath() + "/" + dateiName;
		
		System.out.println("Lese Kunden aus Datei " + dateiNameMitPfad);
		
		List<Kunde> kundeListe = kundeReader.readFromFile(dateiNameMitPfad);
		
		System.out.println(kundeListe.size() + " Kunden gelesen.");
		
		return kundeListe;
	}

	public List<Adresse> LeseAdressenAusXml(String dateiName) {
		XmlReaderStandardJava<List<Adresse>> adresseReader = new XmlReaderStandardJava<List<Adresse>>();
		
		String dateiNameMitPfad = IoConfig.getStubXmlDataPath() + "/" + dateiName;
		
		System.out.println("Lese Adressen aus Datei " + dateiNameMitPfad);
		
		List<Adresse> adresseListe = adresseReader.readFromFile(dateiNameMitPfad);
		
		System.out.println(adresseListe.size() + " Adressen gelesen.");
		
		return adresseListe;
	}
}
