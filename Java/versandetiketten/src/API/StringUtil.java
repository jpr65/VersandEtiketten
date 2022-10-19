package API;

//---------------------------------------------------------------------------------
// API: Utilities für Strings
//---------------------------------------------------------------------------------
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
