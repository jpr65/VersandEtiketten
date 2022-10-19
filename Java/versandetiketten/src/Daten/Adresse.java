package Daten;

//---------------------------------------------------------------------------------
// Datenklasse f�r Adressen
//---------------------------------------------------------------------------------
public class Adresse {
	public String PKID;
	
	// Packstation, Deutschland
	public String PackstationNr;
	public String PackstationKundenNr;
		
	public String Strasse;
	public String Hausnummer;
	
	// Flur und T�r f�r Spanien
	public String Flur;
	public String Tuer;
	
	public String Ortsteil;
	public String Ort;
	public String PostLeitInfo; // enth�lt die Postleitzahl (PLZ) oder Postal District (UK)
	public String Provinz;      // f�r Spanien
	public String Land;
}
