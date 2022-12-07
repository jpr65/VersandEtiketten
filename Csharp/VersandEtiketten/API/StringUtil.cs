namespace API
{
    /// <summary>
    /// API: Utilities für Strings, auch aufrufbar, falls der str == null ist
    ///
    ///i/    Diese API-Klasse darf nur die DOTNET-APIs aufrufen
    ///i/    Deshalb werden APIs als eigene Library im Projekt abgelegt.
    ///i/    Daten-, Operations- und Integrationsklassen sind für die API nicht sichtbar.
    /// </summary>
    public class StringUtil
    {
        /// <summary>
        /// Wandelt in Großbuchstaben um und fängt str == null ab.
        /// </summary>
        public static String? ToUpperCase(String? str)
        {
            if (str == null)
            {
                return str;
            }

            return str.ToUpperInvariant();
        }

        /// <summary>
        /// Anders als bei String.Join() wird der Separator nur angehängt,
        /// wenn beide Strings nicht (leer oder null) sind und der Separator != null ist.
        /// </summary>
        public static String? AddOptionalPart(String? leftPartStr, String? newPartStr, String? separator = " ")
        {

            if (leftPartStr == null)
            {
                return newPartStr;
            }

            if (newPartStr == null)
            {
                return leftPartStr;
            }

            String resultStr = leftPartStr;

            if (separator != null && !String.IsNullOrWhiteSpace(resultStr) && !String.IsNullOrWhiteSpace(newPartStr))
            {
                resultStr += separator;
            }

            resultStr += newPartStr;

            return resultStr;
        }
    }
}