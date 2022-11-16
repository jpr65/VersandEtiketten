package API;

//---------------------------------------------------------------------------------------------
// API: Utilities f�r Strings, auch aufrufbar, falls der str == null ist
//
//i/    Diese API-Klasse darf nur die Java-APIs aufrufen
//i/    Deshalb werden APIs �blicherweise als eigene Library im Projekt abgelegt.
//i/    Daten-, Operations- und Integrationsklassen sind dann f�r die API nicht sichtbar.
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
	
	//-----------------------------------------------------------------------
	//   Anders als bei String.join() wird der Separator nur angeh�ngt,
	//   wenn beide Strings nicht (leer oder null) sind.
	//-----------------------------------------------------------------------
	public static String AddOptionalPart(String leftPartStr, String newPartStr) {
		return AddOptionalPart(leftPartStr, newPartStr, " ");
	}
	
	//----------------------------------------------------------------------------------
	//   Anders als bei String.join() wird der Separator nur angeh�ngt,
	//   wenn beide Strings nicht (leer oder null) sind und der Separator != null ist.
	//----------------------------------------------------------------------------------
	public static String AddOptionalPart(String leftPartStr, String newPartStr, String separator) {
		
		if (leftPartStr == null) {
			return newPartStr;
		}
		
		if (newPartStr == null) {
			return leftPartStr;
		}
		
		String resultStr = leftPartStr;
		
		if (separator != null && !IsEmpty(resultStr) && !IsEmpty(newPartStr)) {
			resultStr += separator;
		}
		
		resultStr += newPartStr;
		
		return resultStr;
	}
}
