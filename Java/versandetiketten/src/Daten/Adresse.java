package Daten;

//---------------------------------------------------------------------------------
// Datenklasse für Adressen
//---------------------------------------------------------------------------------
public class Adresse {
	public String PKID;
	
	// Packstation, Deutschland
	public String PackstationNr;
	public String PackstationKundenNr;
		
	public String Strasse;
	public String Hausnummer;
	
	// Flur und Tür für Spanien
	public String Flur;
	public String Tuer;
	
	public String Ortsteil;
	public String Ort;
	public String PostLeitInfo; // enthält die Postleitzahl (PLZ) oder Postal District (UK)
	public String Provinz;      // für Spanien
	public String Land;
}
