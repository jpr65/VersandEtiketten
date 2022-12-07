using Integration;

namespace VersandEtiketten
{
    internal class Program
    {
        public static int anzahlEtikettenGedruckt = 0;
        public static int anzahlZeilenBelegt = 0;

        static void Main(string[] args)
        {
            LeseKundenUndAdressen();

            Console.WriteLine("======================================");

            VersandEtikettenErsteller versandEtikettenErsteller = new VersandEtikettenErsteller();

            PrintEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", "GER");
            PrintEtikett(versandEtikettenErsteller, "KUD0002", "ADR001", "GER");
            PrintEtikett(versandEtikettenErsteller, "FIR0001", "ADR002", "GER");
            PrintEtikett(versandEtikettenErsteller, "FIR0002", "ADR003", "GER");
            PrintEtikett(versandEtikettenErsteller, "KUD0003", "ADR004", "GER");
            PrintEtikett(versandEtikettenErsteller, "KUD0004", "ADR005", "GER");
            PrintEtikett(versandEtikettenErsteller, "KUD0010", "ADR010", "GBR");
            PrintEtikett(versandEtikettenErsteller, "KUD0011", "ADR011", "GBR");
            PrintEtikett(versandEtikettenErsteller, "KUD0020", "ADR020", "ESP");
            PrintEtikett(versandEtikettenErsteller, "KUD0021", "ADR021", "ESP");

            // unbekanntes Land für Formatierung
            PrintEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", null);
            PrintEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", "");
            PrintEtikett(versandEtikettenErsteller, "KUD0001", "ADR001", "AUT");

            // Unbekannte KundeId / AdresseId
            PrintEtikett(versandEtikettenErsteller, "KUD1001", "ADR001", "GER");
            PrintEtikett(versandEtikettenErsteller, "KUD0001", "ADR101", "GER");

            Console.WriteLine("Anzahl Etiketten (gesamt / gedruckt): "
                    + versandEtikettenErsteller.EtikettZaehler
                    + " / " + anzahlEtikettenGedruckt);

            Console.WriteLine("Anzahl Zeilen belegt insgesamt: "
                    + anzahlZeilenBelegt);
            Console.WriteLine("======================================");

            //i/ Bis hierhin keine Logik!

            // Der Code bis zum Ende der Methode könnte auskommentiert werden,
            // aber dann würde er bei Umbenennungen nicht berücksichtigt.

            Boolean erzeugeXmlDatenDateien = false;

            if (erzeugeXmlDatenDateien)
            {
                SchreibeKundenUndAdressen();
            }
        }

        private static void LeseKundenUndAdressen()
        {
            Console.WriteLine("leseKundenUndAdressen noch nicht implementiert.");
        }

        private static void PrintEtikett(VersandEtikettenErsteller versandEtikettenErsteller,
            String KundeId, String AdresseId, String Land)
        {
            Console.WriteLine("printEtikett noch nicht implementiert.");
        }

        private static void SchreibeKundenUndAdressen()
        {
            Console.WriteLine("schreibeKundenUndAdressen noch nicht implementiert.");
        }


    }
}