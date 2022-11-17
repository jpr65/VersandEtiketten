import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import Daten.Adresse;
import Daten.EtikettVariante1;
import Daten.Kunde;
import Operationen.UnitedKingdomAnschriftFormatierer;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class TCL_0010_EtikettVariante1 {

	private EtikettVariante1 CreateTestObject(int leereZeilen, int gefuellteZeilen) {
		EtikettVariante1 testObject =  new EtikettVariante1();
		
		testObject.anschriftZeilen = new ArrayList<String>();
		
		for (int idx = 0; idx < leereZeilen; idx++) {
			testObject.anschriftZeilen.add("");
		}
		
		for (int idx = 0; idx < gefuellteZeilen; idx++) {
			testObject.anschriftZeilen.add("Zeile " + idx);
		}
		
		return testObject;
	}
	
	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T010_belegteZeilenAnz_ListIsNull() {
		// --- Testvorbereitung --------------------------------
		
		EtikettVariante1 testObject =  new EtikettVariante1();

		// --- Testdurchführung --------------------------------
		
		int zeilenBelegt = testObject.belegteZeilenAnz();
		
		// --- Testvalidierung --------------------------------
		
		assertEquals(0, zeilenBelegt);
	}
	
	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T010_belegteZeilen_0_0() {
		TestBelegteZeilen(0,0);
	}
	
	void TestBelegteZeilen(int leereZeilenVorgabe, int gefuellteZeilenVorgabe) {
		// --- Testvorbereitung --------------------------------
		
		EtikettVariante1 testObject = this.CreateTestObject(leereZeilenVorgabe, gefuellteZeilenVorgabe);

		// --- Testdurchführung --------------------------------
				
		int zeilenBelegt = testObject.belegteZeilenAnz();
				
		// --- Testvalidierung --------------------------------
				
		assertEquals(gefuellteZeilenVorgabe, zeilenBelegt);
	}

	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T100_belegteZeilen_1_0() {
		TestBelegteZeilen(1,0);
	}
	
	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T110_belegteZeilen_7_0() {
		TestBelegteZeilen(1,0);
	}

	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T200_belegteZeilen_0_1() {
		TestBelegteZeilen(0,1);
	}
	
	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T210_belegteZeilen_0_9() {
		TestBelegteZeilen(0,9);
	}
	
	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T300_belegteZeilen_1_1() {
		TestBelegteZeilen(0,1);
	}
	
	/**
	 * Test method for {@link Daten.EtikettVariante1#belegteZeilenAnz()}.
	 */
	@Test
	void T310_belegteZeilen_2_3() {
		TestBelegteZeilen(2,3);
	}
}
