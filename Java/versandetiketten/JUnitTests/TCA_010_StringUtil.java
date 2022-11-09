import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

import static org.junit.Assert.*;

import API.StringUtil;

/**
 * @author rp
 *
 */
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class TCA_010_StringUtil {

	/**
	 * Test method for {@link API.StringUtil#IsEmpty(java.lang.String)}.
	 */
	@Test
	void T010_IsEmpty_Str() {
		assertTrue(StringUtil.IsEmpty(null));
		assertTrue(StringUtil.IsEmpty(""));
		assertTrue(StringUtil.IsEmpty(" "));
		assertTrue(StringUtil.IsEmpty("\t"));
		
		assertTrue(StringUtil.IsEmpty(" \t\n"));
		
		assertFalse(StringUtil.IsEmpty("text"));
	}

	
	/**
	 * Test method for {@link API.StringUtil#IsEmpty(java.lang.String)}.
	 */
	@Test
	void T020_ToUpperCase() {
		assertEquals(null, StringUtil.ToUpperCase(null));
		assertEquals("", StringUtil.ToUpperCase(""));
		assertEquals(" ", StringUtil.ToUpperCase(" "));
		assertEquals("\t", StringUtil.ToUpperCase("\t"));
		
		assertEquals("A", StringUtil.ToUpperCase("a"));
		assertEquals("1", StringUtil.ToUpperCase("1"));
		assertEquals(" B ", StringUtil.ToUpperCase(" b "));
		assertEquals("TEXT", StringUtil.ToUpperCase("text"));
		assertEquals("TEXT", StringUtil.ToUpperCase("Text"));
		assertEquals("TEXT", StringUtil.ToUpperCase("TEXT"));

		assertEquals("BRÖTCHEN", StringUtil.ToUpperCase("Brötchen"));
		assertEquals("SMÅLAND", StringUtil.ToUpperCase("Småland"));
	}

	
	/**
	 * Test method for {@link API.StringUtil#AddOptionalPart(java.lang.String, java.lang.String)}.
	 */
	@Test
	void T100_AddOptionalPart_StrStr_empty() {
		assertEquals(null, StringUtil.AddOptionalPart(null,  null));
		assertEquals("", StringUtil.AddOptionalPart("",  null));
		assertEquals("\t", StringUtil.AddOptionalPart(null,  "\t"));
		assertEquals(" ", StringUtil.AddOptionalPart(null,  " "));

		assertEquals("", StringUtil.AddOptionalPart("",  ""));
		assertEquals("  ", StringUtil.AddOptionalPart(" ",  " "));
}

	/**
	 * Test method for {@link API.StringUtil#AddOptionalPart(java.lang.String, java.lang.String)}.
	 */
	@Test
	void T110_AddOptionalPart_StrStr_1stEmpty() {
		assertEquals("A", StringUtil.AddOptionalPart(null, "A"));
		assertEquals("B", StringUtil.AddOptionalPart("", "B"));
		assertEquals("\tC", StringUtil.AddOptionalPart("\t", "C"));
		assertEquals(" D", StringUtil.AddOptionalPart(" ", "D"));
	}

	/**
	 * Test method for {@link API.StringUtil#AddOptionalPart(java.lang.String, java.lang.String)}.
	 */
	@Test
	void T120_AddOptionalPart_StrStr_2ndEmpty() {
		assertEquals("A", StringUtil.AddOptionalPart("A",  null));
		assertEquals("B", StringUtil.AddOptionalPart("B",  ""));
		assertEquals("C\t", StringUtil.AddOptionalPart("C",  "\t"));
		assertEquals("D ", StringUtil.AddOptionalPart("D",  " "));
	}

	/**
	 * Test method for {@link API.StringUtil#AddOptionalPart(java.lang.String, java.lang.String)}.
	 */
	@Test
	void T130_AddOptionalPart_StrStr() {
		assertEquals("A B", StringUtil.AddOptionalPart("A", "B"));
		assertEquals("C   D", StringUtil.AddOptionalPart("C ", " D"));

		assertEquals("Herbert Meyer", StringUtil.AddOptionalPart("Herbert", "Meyer"));
		assertEquals("Kirch AG", StringUtil.AddOptionalPart("", "Kirch AG"));
	}

	/**
	 * Test method for {@link API.StringUtil#AddOptionalPart(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void T200_AddOptionalPart_StrStrStr_nulls() {
		assertEquals(null, StringUtil.AddOptionalPart(null,  null, null));
		
		assertEquals("", StringUtil.AddOptionalPart("",  null, null));
		assertEquals("\t", StringUtil.AddOptionalPart("\t",  null, null));
		assertEquals(" ", StringUtil.AddOptionalPart(" ",  null, null));
		assertEquals("B", StringUtil.AddOptionalPart("B",  null, null));
		assertEquals("ü", StringUtil.AddOptionalPart("ü",  null, null));
		
		assertEquals("", StringUtil.AddOptionalPart(null,  "", null));
		assertEquals("\t", StringUtil.AddOptionalPart(null,  "\t", null));
		assertEquals(" ", StringUtil.AddOptionalPart(null,  " ", null));
		assertEquals("C", StringUtil.AddOptionalPart(null,  "C", null));
		assertEquals("ä", StringUtil.AddOptionalPart(null,  "ä", null));
		
		assertEquals("", StringUtil.AddOptionalPart("",  "", null));
		assertEquals("  ", StringUtil.AddOptionalPart(" ",  " ", null));
		assertEquals("ef", StringUtil.AddOptionalPart("e",  "f", null));
	}
	
	/**
	 * Test method for {@link API.StringUtil#AddOptionalPart(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	void T210_AddOptionalPart_StrStrStr() {
		assertEquals("A", StringUtil.AddOptionalPart("A", "", ""));
		assertEquals("B", StringUtil.AddOptionalPart("", "B", ""));
		assertEquals("CD", StringUtil.AddOptionalPart("C", "D", ""));
		assertEquals("E-F", StringUtil.AddOptionalPart("E", "F", "-"));
		assertEquals("G\tH", StringUtil.AddOptionalPart("G", "H", "\t"));
		
		assertEquals("Meyer, Herbert", StringUtil.AddOptionalPart("Meyer", "Herbert", ", "));
		assertEquals("Kirch-AG", StringUtil.AddOptionalPart("Kirch", "AG", "-"));
	}

}
