namespace Daten
{
    /// <summary>
    /// Datenklasse für Adressen
    /// </summary>
    public class Adresse
    {
        public String? PKID { get; set; }

        // Packstation, Deutschland
        public String? PackstationNr { get; set; }
        public String? PackstationKundenNr { get; set; }

        public String? Strasse { get; set; }
        public String? Hausnummer { get; set; }

        // Flur und Tür für Spanien
        public String? Flur { get; set; }
        public String? Tuer { get; set; }

        public String? Ortsteil { get; set; }
        public String? Ort { get; set; }
        public String? PostLeitInfo { get; set; } // enthält die Postleitzahl (PLZ) oder Postal District (UK)
        public String? Provinz { get; set; }      // für Spanien
        public String? Land { get; set; }
    }
}
