using API_IO;
using Daten;

namespace IO_Operationen
{
    /// <summary>
    /// IO-Klasse, die Kunden-Infos und Adressen aus XML-Dateien einliest
    /// </summary>
    public class KundenUndAdressenReader
    {
        public List<Kunde>? LeseKundenAusXml(String dateiName)
        {
            XmlReader<List<Kunde>> kundeReader = new XmlReader<List<Kunde>>();

            String dateiNameMitPfad = Path.Combine(IoConfig.StubXmlDataPath,dateiName);

            Console.WriteLine("Lese Kunden aus Datei " + dateiNameMitPfad);

            List<Kunde>? kundeListe = kundeReader.readFromFile(dateiNameMitPfad);

            int anzGelesen = 0;

            if (kundeListe != null)
            {
                anzGelesen = kundeListe.Count;
            }

            Console.WriteLine(anzGelesen + " Kunden gelesen.");

            return kundeListe;
        }

        public List<Adresse>? LeseAdressenAusXml(String dateiName)
        {
            XmlReader<List<Adresse>> adresseReader = new XmlReader<List<Adresse>>();

            String dateiNameMitPfad = Path.Combine(IoConfig.StubXmlDataPath, dateiName);

            Console.WriteLine("Lese Adressen aus Datei " + dateiNameMitPfad);

            List<Adresse>? adresseListe = adresseReader.readFromFile(dateiNameMitPfad);

            int anzGelesen = 0;

            if (adresseListe != null)
            {
                anzGelesen = adresseListe.Count;
            }

            Console.WriteLine(anzGelesen + " Adressen gelesen.");

            return adresseListe;
        }
    }
}
