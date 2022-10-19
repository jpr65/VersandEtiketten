import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;
import Operationen.SpainAnschriftFormatierer;

/**
 * @author rp
 *
 */

public class TCL_0120_SpainAnschriftFormatierer {

	private Adresse CreateAdresseLeer() {
		return new Adresse();
	}

	private Kunde CreateKundeLeer() {
		return new Kunde();
	}
	
	private Adresse CreateAdresse1() {
		Adresse adresse = new Adresse();
		
		adresse.Strasse = "Calle Huertas";
		adresse.Hausnummer = "18";
		adresse.Flur = "4°";
		adresse.Tuer = "C";
		adresse.PostLeitInfo = "09692";
		adresse.Ort = "Canicosa De La Sierra";
		adresse.Ortsteil = "Barrio de San Roque";
		adresse.Provinz = "Burgos";
		adresse.Land = "Spain";
		
		return adresse;
	}
	
	private Adresse CreateAdresse2() {
		Adresse adresse = new Adresse();
		
		adresse.PostLeitInfo = "08028";
		adresse.Ort = "Barcelona";
		adresse.Strasse = "Av. Joan XXIII";
		adresse.Flur = "s/n";
		adresse.Land = "Spain";
		
		return adresse;
	}

	private Kunde CreateKunde1() {
		Kunde kunde = new Kunde();
		
		kunde.Vorname = "Naviera";
		kunde.Name = "Casarejos";
		kunde.PrivatKunde = true;
		
		return kunde;
	}
	
	private Kunde CreateFirmenKunde() {
		Kunde firmenKunde = new Kunde();
		
		firmenKunde.PrivatKunde = false;
		firmenKunde.Firma = "FC Barcelona";
		firmenKunde.Abteilung = "Shop";
		
		return firmenKunde;
	}
	
	/**
	 * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T010_AnschriftErstellung_leer() {
		
		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateKundeLeer();
		Adresse adresse = this.CreateAdresseLeer();
		
		SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();
		
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
		
		SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();
		
		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------

		assertEquals(6, testResult.size());
		int lineNbr = 0;
		assertEquals("Naviera Casarejos", testResult.get(lineNbr++));
		assertEquals("Calle Huertas 18, 4°, C", testResult.get(lineNbr++));
		assertEquals("Barrio de San Roque", testResult.get(lineNbr++));
		assertEquals("09692 CANICOSA DE LA SIERRA", testResult.get(lineNbr++));
		assertEquals("BURGOS", testResult.get(lineNbr++));
		assertEquals("SPAIN", testResult.get(lineNbr++));
	}
	
	/**
	 * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
	 */
	@Test
	void T110_AnschriftErstellung_FirmenKunde() {
		
		// --- Testvorbereitung --------------------------------
		
		Kunde kunde = this.CreateFirmenKunde();
		Adresse adresse = this.CreateAdresse2();
		
		SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();
		
		// --- Testdurchführung --------------------------------
		
		List<String> testResult = testObject.AnschriftErstellung(kunde, adresse);
		
		// --- Testvalidierung --------------------------------

		assertEquals(5, testResult.size());
		int lineNbr = 0;
		assertEquals("FC Barcelona", testResult.get(lineNbr++));
		assertEquals("Shop", testResult.get(lineNbr++));
		assertEquals("Av. Joan XXIII, s/n", testResult.get(lineNbr++));
		assertEquals("08028 BARCELONA", testResult.get(lineNbr++));
		assertEquals("SPAIN", testResult.get(lineNbr++));
	}
}
