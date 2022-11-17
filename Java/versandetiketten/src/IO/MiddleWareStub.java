package IO;

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
	
	public void FillKundeDict(List<Kunde> kundeListe) {
		kundeDict = new Hashtable<String, Kunde>();
		
		for (Kunde kunde: kundeListe) {
			kundeDict.put(kunde.PKID, kunde);
		}
	}

	public void FillAdresseDict(List<Adresse> adresseListe) {
		adresseDict = new Hashtable<String, Adresse>();
		
		for (Adresse adresse: adresseListe) {
			adresseDict.put(adresse.PKID, adresse);
		}
		
	}

	
	
	
}
