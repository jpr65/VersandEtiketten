using Daten;
using Integration;
using IO_Operationen;

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
        }

        private static void LeseKundenUndAdressen()
        {
            MiddleWareStub middleWareStub = (MiddleWareStub)IoFactory.getMiddleWare();
            KundenUndAdressenReader reader = new KundenUndAdressenReader();

            //i/ try-catch darf auch im Integrator verwendet werden,
            //i/ da einige Fehler nur hier abgefangen werden können.
            try
            {
                List<Kunde>? kundenListe = reader.LeseKundenAusXml("AlleKunden.xml");
                List<Adresse>? adressenListe = reader.LeseAdressenAusXml("AlleAdressen.xml");

                middleWareStub.FillKundeDict(kundenListe);
                middleWareStub.FillAdresseDict(adressenListe);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Fehler beim Lesen der Kunden/Adressen");
                Console.WriteLine(ex.Message);
                Console.WriteLine("------------------------------------------");
            }
        }

        private static void PrintEtikett(VersandEtikettenErsteller versandEtikettenErsteller,
            String? KundeId, String? AdresseId, String? Land)
        {
            try
            {
                EtikettVariante1 etikett = versandEtikettenErsteller.VersandEtikettVariante1(KundeId, AdresseId, Land, null);

                IEtikettDrucker etikettDrucker = OperatorFactory.buildEtikettDrucker();
                etikettDrucker.DruckeEtikett(etikett.AnschriftZeilen);

                anzahlEtikettenGedruckt++;
                anzahlZeilenBelegt += etikett.BelegteZeilenAnz();
            }
                catch (Exception ex)
                {
                    Console.WriteLine("Fehler beim Drucken des Etiketts");
                    Console.WriteLine(ex.Message);
                    Console.WriteLine("------------------------------------------");
                }
        }
    }
}