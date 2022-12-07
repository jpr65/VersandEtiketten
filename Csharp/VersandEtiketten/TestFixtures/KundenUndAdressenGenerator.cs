using API_IO;
using Daten;
using IO_Operationen;

namespace TestFixtures
{
    /// <summary>
    /// Fixture-Klasse, die Kunden-Infos und Adressen generiert und in eine Datei schreibt.
    /// </summary>
    public class KundenUndAdressenGenerator
    {
        public String XmlDataPath { get; set; } = IoConfig.StubXmlDataPath;

        public Adresse LeseAdresseDummy(String adresseID)
        {
            Adresse dummyAdresse = new Adresse();

            dummyAdresse.PKID = adresseID;

            if (adresseID == "ADR001") {
                dummyAdresse.PostLeitInfo = "44787";
                dummyAdresse.Ort = "Bochum";
                dummyAdresse.Strasse = "Viktoriastraße";
                dummyAdresse.Hausnummer = "13b";
            }
            else if (adresseID == "ADR002") {
                dummyAdresse.PostLeitInfo = "91055";
                dummyAdresse.Ort = "Erlangen";
                dummyAdresse.Strasse = "Postfach";
                dummyAdresse.Land = "GERMANY";
            }

            else if (adresseID == "ADR003")
            {
                dummyAdresse.PostLeitInfo = "46397";
                dummyAdresse.Ort = "Bocholt";
                dummyAdresse.Strasse = "Münsterstr.";
                dummyAdresse.Hausnummer = "123";
            }
            else if (adresseID == "ADR004")
            {
                dummyAdresse.PostLeitInfo = "12359";
                dummyAdresse.Ort = "Berlin";
                dummyAdresse.Strasse = "Alt-Britz";
                dummyAdresse.Hausnummer = "18";
                dummyAdresse.Ortsteil = "Ortsteil Neukoelln";
                dummyAdresse.Land = "GERMANY";
            }
            else if (adresseID == "ADR005")
            {
                dummyAdresse.PostLeitInfo = "53113";
                dummyAdresse.Ort = "Bonn";
                dummyAdresse.Land = "GERMANY";
                dummyAdresse.PackstationNr = "Packstation 101";
                dummyAdresse.PackstationKundenNr = "1234567";
                dummyAdresse.Land = "GERMANY";
            }
            else if (adresseID == "ADR010")
            {
                dummyAdresse.PostLeitInfo = "OX14 4PG";
                dummyAdresse.Ort = "ABINGDON";
                dummyAdresse.Hausnummer = "1";
                dummyAdresse.Strasse = "Upper Littleton";
                dummyAdresse.Ortsteil = "Appleford";
                dummyAdresse.Land = "UNITED KINGDOM";
            }
            else if (adresseID == "ADR011")
            {
                dummyAdresse.PostLeitInfo = "EC1Y 8SY";
                dummyAdresse.Ort = "LONDON";
                dummyAdresse.Hausnummer = "49";
                dummyAdresse.Strasse = "Featherstone Street";
                dummyAdresse.Land = "UNITED KINGDOM";
            }
            else if (adresseID == "ADR020")
            {
                dummyAdresse.PostLeitInfo = "29400";
                dummyAdresse.Ort = "Marbella";
                dummyAdresse.Hausnummer = "18";
                dummyAdresse.Flur = "4º";
                dummyAdresse.Tuer = "C";
                dummyAdresse.Strasse = "Calle Huertas";
                dummyAdresse.Provinz = "Málaga";
                dummyAdresse.Land = "SPAIN";
            }
            else if (adresseID == "ADR021")
            {
                dummyAdresse.PostLeitInfo = "09692";
                dummyAdresse.Ort = "CANICOSA DE LA SIERRA";
                dummyAdresse.Hausnummer = "27";
                dummyAdresse.Strasse = "Plaza de las Descalzas";
                dummyAdresse.Ortsteil = "Barrio de San Roque";
                dummyAdresse.Provinz = "BURGOS";
                dummyAdresse.Land = "SPAIN";
            }
            else
            {
                throw new Exception("unbekannte Adresse mit ID " + adresseID);
            }

            return dummyAdresse;
        }

        public Kunde LeseKundeDummy(String kundeID)
        {
            Kunde dummyKunde = new Kunde();

            dummyKunde.PKID = kundeID;

            if (kundeID == "KUD0001")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Mustermann";
                dummyKunde.Vorname = "Monika";
            }
            else if (kundeID == "KUD0002")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Titel = "Prof. Dr.";
                dummyKunde.Name = "Staller";
                dummyKunde.Vorname = "Hubert";
            }
            else if (kundeID == "KUD0003")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Schloss Britz";
            }
            else if (kundeID == "KUD0004")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Sommer";
                dummyKunde.Vorname = "Lisa";
            }
            else if (kundeID == "FIR0002")
            {
                dummyKunde.PrivatKunde = false;
                dummyKunde.Firma = "Bädergalerie Bocholt";
            }
            else if (kundeID == "FIR0001")
            {
                dummyKunde.PrivatKunde = false;
                dummyKunde.Firma = "Siemens PG";
                dummyKunde.Abteilung = "OI 41";
            }
            else if (kundeID == "KUD0010")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Poppins";
                dummyKunde.Vorname = "Mary";
            }
            else if (kundeID == "KUD0011")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Brown";
                dummyKunde.Vorname = "Walter C.";
            }
            else if (kundeID == "KUD0020")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Casero";
                dummyKunde.Vorname = "Carmen Garcés";
            }
            else if (kundeID == "KUD0021")
            {
                dummyKunde.PrivatKunde = true;
                dummyKunde.Name = "Cortés";
                dummyKunde.Vorname = "José Ayuso";
            }
            else
            {
                throw new Exception("unbekannter Kunde mit ID " + kundeID);
            }

            return dummyKunde;
        }

        public void SchreibeAlleKunden(String dateiName) {

            String[] kundeIdArr = {
        "KUD0001", "KUD0002", "KUD0003", "KUD0004", "FIR0001", "FIR0002",
                                "KUD0010", "KUD0011", "KUD0020", "KUD0021"};
            List<Kunde> kundeListe = new List<Kunde>();

            foreach (String kundeID in kundeIdArr)
            {
                Kunde kunde = LeseKundeDummy(kundeID);
                kundeListe.Add(kunde);
            }

            SchreibeKunden(kundeListe, dateiName);
        }

        public void SchreibeKunden(List<Kunde> kundeListe, String dateiName)
        {
            XmlWriter<List<Kunde>> kundeWriter = new XmlWriter<List<Kunde>>();

            String dateiNameMitPfad = Path.Combine(XmlDataPath, dateiName);

            Console.WriteLine("Write " + kundeListe.Count + " Kunden in Datei " + dateiNameMitPfad);

            kundeWriter.WriteIntoFile(kundeListe, dateiNameMitPfad);
        }

        public void SchreibeAlleAdressen(String dateiName)
        {

            String[]
            adresseIdArr = {
        "ADR001", "ADR002", "ADR003", "ADR004", "ADR005", "ADR010", "ADR011",
                                    "ADR020", "ADR021", };
            List<Adresse> adresseListe = new List<Adresse>();

            foreach (String adresseID in adresseIdArr)
            {
                Adresse adresse = LeseAdresseDummy(adresseID);
                adresseListe.Add(adresse);
            }

            SchreibeAdressen(adresseListe, dateiName);
        }

        public void SchreibeAdressen(List<Adresse> AdresseListe, String dateiName)
        {
            XmlWriter<List<Adresse>> AdresseWriter = new XmlWriter<List<Adresse>>();

            String dateiNameMitPfad = Path.Combine(XmlDataPath, dateiName);

            Console.WriteLine("Write " + AdresseListe.Count + " Adressen in Datei " + dateiNameMitPfad);

            AdresseWriter.WriteIntoFile(AdresseListe, dateiNameMitPfad);
        }

        public void SchreibeKunde(String kundeID, String dateiName)
        {
            Kunde kunde = LeseKundeDummy(kundeID);
            SchreibeKunde(kunde, dateiName);
        }

        public void SchreibeKunde(Kunde kunde, String dateiName)
        {
            XmlWriter<Kunde> kundeWriter = new XmlWriter<Kunde>();

            String dateiNameMitPfad = Path.Combine(XmlDataPath, dateiName);

            Console.WriteLine("Write Kunde " + kunde.PKID + " in Datei " + dateiNameMitPfad);

            kundeWriter.WriteIntoFile(kunde, dateiNameMitPfad);
        }
    }
}