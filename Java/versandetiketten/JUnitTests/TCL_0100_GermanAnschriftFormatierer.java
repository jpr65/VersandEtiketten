import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.Assert.*;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;
import Operationen.GermanAnschriftFormatierer;

/**
 * @author rp
 *
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TCL_0100_GermanAnschriftFormatierer {

	private Adresse CreateAdresseLeer() {
		return new Adresse();
	}

	private Kunde CreateKundeLeer() {
		return new Kunde();
	}
	
	private Adresse CreateAdresse1() {
		Adresse adresse = new Adresse();
		
		adresse.Strasse = "Alt-Britz";
		adresse.Hausnummer = "18";
		adresse.PostLeitInfo = "12359";
		adresse.Ort = "Berlin";
		adresse.Ortsteil = "Ortsteil Neukoelln";
		adresse.Land = "Germany";
		
		return adresse;
	}
	
	private Adresse CreateAdressePackstation() {
		Adresse adresse = new Adresse();
		
		adresse.PackstationNr = "4711";
		adresse.PackstationKundenNr = "1234567";
		adresse.PostLeitInfo = "12359";
		adresse.Ort = "Berlin";
		
		return adresse;
	}

	private Adresse CreateFirmenAdresse() {
		Adresse adresse = new Adresse();
		
		adresse.Strasse = "Wittener Str.";
		adresse.Hausnummer = "45";
		adresse.PostLeitInfo = "44789";
		adresse.Ort = "Bochum";
		adresse.Land = "Germany";
		
		return adresse;
	}

	private Kunde CreateKunde1() {
		Kunde kunde = new Kunde();
		
		kunde.PrivatKunde = true;
		kunde.Titel = "Prof. Dr.";
		kunde.Name = "Staller";
		kunde.Vorname = "Hubert";
		
		return kunde;
	}
	
	private Kunde CreateFirmenKunde() {
		Kunde firmenKunde = new Kunde();
		
		firmenKunde.PrivatKunde = false;
		firmenKunde.Firma = "Aral AG";
		firmenKunde.Abteilung = "Tankstellen-Planung";
		
		return firmenKunde;
	}
	
	/**
	 * Test method for {@link Operationen.GermanAnschriftFormatierer#GetLaenderkennung()}.
	 */
	@Test
	void T001_GetLaenderkennung() {

		// --- Testvorbereitung --------------------------------
		
		GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();
		
		// --- Testdurchführung --------------------------------
		
		String laenderKennungResult = testObject.GetLaenderKennung();
				
		// --- Testvalidierung --------------------------------
		
		assertEquals("ger", laenderKennungResult.toLowerCase());
	}
	
	/**
	 * Test method for {@link Operationen.GermanAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T010_AnschriftErstellung_leer() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateKundeLeer();
		Adresse adresse = this.CreateAdresseLeer();
		
		GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();
		
		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(1, testResult.size());
		assertEquals("", testResult.get(0));
	}
	
	/**
	 * Test method for {@link Operationen.GermanAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T100_AnschriftErstellung_PrivatKunde() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateKunde1();
		Adresse adresse = this.CreateAdresse1();
		
		GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(5, testResult.size());
		int lineNbr = 0;
		assertEquals("Prof. Dr. Hubert Staller", testResult.get(lineNbr++));
		assertEquals("Ortsteil Neukoelln", testResult.get(lineNbr++));
		assertEquals("Alt-Britz 18", testResult.get(lineNbr++));
		assertEquals("12359 BERLIN", testResult.get(lineNbr++));
		assertEquals("GERMANY", testResult.get(lineNbr++));
	}
	
	/**
	 * Test method for {@link Operationen.GermanAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T110_AnschriftErstellung_FirmenKunde() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateFirmenKunde();
		Adresse adresse = this.CreateFirmenAdresse();
		
		GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(5, testResult.size());
		int lineNbr = 0;
		assertEquals("Aral AG", testResult.get(lineNbr++));
		assertEquals("Tankstellen-Planung", testResult.get(lineNbr++));
		assertEquals("Wittener Str. 45", testResult.get(lineNbr++));
		assertEquals("44789 BOCHUM", testResult.get(lineNbr++));
		assertEquals("GERMANY", testResult.get(lineNbr++));
	}

	/**
	 * Test method for {@link Operationen.GermanAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T200_AnschriftErstellung_Packstation() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateKunde1();
		Adresse adresse = this.CreateAdressePackstation();
		
		GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(4, testResult.size());
		int lineNbr = 0;
		assertEquals("Prof. Dr. Hubert Staller", testResult.get(lineNbr++));
		assertEquals("1234567", testResult.get(lineNbr++));
		assertEquals("Packstation 4711", testResult.get(lineNbr++));
		assertEquals("12359 BERLIN", testResult.get(lineNbr++));
	}
}
