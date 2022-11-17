package Operationen;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;

/**
 * @author rp
 *
 */
public class TCL_0110_UnitedKingdomAnschriftFormatierer {

	private Adresse CreateAdresseLeer() {
		return new Adresse();
	}

	private Kunde CreateKundeLeer() {
		return new Kunde();
	}
	
	private Adresse CreateAdresse1() {
		Adresse adresse = new Adresse();
		
		adresse.Strasse = "Upper Littleton";
		adresse.Hausnummer = "1";
		adresse.PostLeitInfo = "OX14 4PG";
		adresse.Ort = "Abingdon";
		adresse.Ortsteil = "Appleford";
		adresse.Land = "United Kingdom";
		
		return adresse;
	}

	private Adresse CreateAdresse2() {
		Adresse adresse = new Adresse();
		
		adresse.Strasse = "John Street";
		adresse.Hausnummer = "27";
		adresse.PostLeitInfo = "SO23 9AP";
		adresse.Ort = "Winchester";
		adresse.Land = "United Kingdom";
		
		return adresse;
	}

	private Kunde CreateKunde1() {
		Kunde kunde = new Kunde();
		
		kunde.PrivatKunde = true;
		kunde.Name = "Poppins";
		kunde.Vorname = "Mary";
		
		return kunde;
	}
	
	private Kunde CreateFirmenKunde() {
		Kunde firmenKunde = new Kunde();
		
		firmenKunde.PrivatKunde = false;
		firmenKunde.Firma = "Testing Company";
		firmenKunde.Abteilung = "Test Development";
		
		return firmenKunde;
	}
	
	private Kunde CreateFirmenKundeOhneAbteilung() {
		Kunde firmenKunde = new Kunde();
		
		firmenKunde.PrivatKunde = false;
		firmenKunde.Firma = "Import INC";
		
		return firmenKunde;
	}
	
	
	
	/**
	 * Test method for {@link Operationen.UnitedKingdomAnschriftFormatierer#GetLaenderkennung()}.
	 */
	@Test
	void T001_GetLaenderkennung() {

		// --- Testvorbereitung --------------------------------
		
		UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();
		
		// --- Testdurchführung --------------------------------
		
		String laenderKennungResult = testObject.GetLaenderKennung();
				
		// --- Testvalidierung --------------------------------
		
		assertEquals("gbr", laenderKennungResult.toLowerCase());
	}
	
	/**
	 * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T010_AnschriftErstellung_leer() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateKundeLeer();
		Adresse adresse = this.CreateAdresseLeer();
		
		UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(1, testResult.size());
		assertEquals("", testResult.get(0));
	}
	
	/**
	 * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T100_AnschriftErstellung_PrivatKunde() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateKunde1();
		Adresse adresse = this.CreateAdresse1();
		
		UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(6, testResult.size());
		int lineNbr = 0;
		assertEquals("Mary Poppins", testResult.get(lineNbr++));
		assertEquals("1 Upper Littleton", testResult.get(lineNbr++));
		assertEquals("Appleford", testResult.get(lineNbr++));
		assertEquals("ABINGDON", testResult.get(lineNbr++));
		assertEquals("OX14 4PG", testResult.get(lineNbr++));
		assertEquals("UNITED KINGDOM", testResult.get(lineNbr++));
	}
	
	/**
	 * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T110_AnschriftErstellung_FirmenKunde() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateFirmenKunde();
		Adresse adresse = this.CreateAdresse1();
		
		UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(7, testResult.size());
		int lineNbr = 0;
		assertEquals("Testing Company", testResult.get(lineNbr++));
		assertEquals("Test Development", testResult.get(lineNbr++));
		assertEquals("1 Upper Littleton", testResult.get(lineNbr++));
		assertEquals("Appleford", testResult.get(lineNbr++));
		assertEquals("ABINGDON", testResult.get(lineNbr++));
		assertEquals("OX14 4PG", testResult.get(lineNbr++));
		assertEquals("UNITED KINGDOM", testResult.get(lineNbr++));
	}

	/**
	 * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T120_AnschriftErstellung_FirmenKundeOhneAbteilung() {

		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateFirmenKundeOhneAbteilung();
		Adresse adresse = this.CreateAdresse2();
		
		UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(5, testResult.size());
		int lineNbr = 0;
		assertEquals("Import INC", testResult.get(lineNbr++));
		assertEquals("27 John Street", testResult.get(lineNbr++));
		assertEquals("WINCHESTER", testResult.get(lineNbr++));
		assertEquals("SO23 9AP", testResult.get(lineNbr++));
		assertEquals("UNITED KINGDOM", testResult.get(lineNbr++));
	}
}
