namespace Daten
{
    /// <summary>
    /// Datenklasse für Kunden
    /// </summary>
    public class Kunde
    {
        public String? PKID { get; set; }

        public Boolean PrivatKunde { get; set; } = true;

        public String? Titel { get; set; } = "";
        public String? Name { get; set; } = "";
        public String? Vorname { get; set; } = "";

        public String? Firma { get; set; } = "";
        public String? Abteilung { get; set; } = "";
    }
}