package API;

//---------------------------------------------------------------------------------------------
// API: Utilities für Strings
//
//i/    Diese API-Klasse darf nur die Java-APIs aufrufen
//i/    Deshalb werden APIs üblicherweise als eigene Library im Projekt abgelegt.
//i/    Daten-, Operations- und Integrationsklassen sind dann für die API nicht sichtbar.
//i/    Auf eine eigene Lib wurde hier verzichtet, um das Projekt einfacher zu gestalten.
//---------------------------------------------------------------------------------------------
public class StringUtil {
	public static boolean IsEmpty(String str) {
		if (str == null) {
			return true;
		}
		
		return str.isBlank();
	}
	
	public static String ToUpperCase(String str) {
		if (str == null) {
			return str;
		}
		
		return str.toUpperCase();
	}
	
	public static String AddOptionalPart(String leftPartStr, String newPartStr) {
		return AddOptionalPart(leftPartStr, newPartStr, " ");
	}
	
	public static String AddOptionalPart(String leftPartStr, String newPartStr, String separator) {
		String resultStr = leftPartStr;
		
		if (resultStr == null) {
			return newPartStr;
		}
		
		if (newPartStr == null) {
			return resultStr;
		}
		
		if (!IsEmpty(resultStr) && !IsEmpty(newPartStr)) {
			resultStr += separator;
		}
		
		resultStr += newPartStr;
		
		return resultStr;
	}
}
