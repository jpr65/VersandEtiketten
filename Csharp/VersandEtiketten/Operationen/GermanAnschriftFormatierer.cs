using API;
using Daten;

namespace Operationen
{
    /// <summary>
    /// Operation: Anschrift formatieren, Variante für Deutschland (GER)
    /// https://www.upu.int/en/Postal-Solutions/Programmes-Services/Addressing-Solutions
    /// Siehe Doku-Ordner, deuEn.pdf
    /// </summary>
    public class GermanAnschriftFormatierer : IAnschriftFormatierer
    {
        private String laenderKennung = "GER";

        public String GetLaenderKennung()
        {
            return laenderKennung;
        }

        public List<String?> AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)
        {
            List<String?> anschriftListe = new List<String?>();

            if (kundeArg.PrivatKunde)
            {
                anschriftListe = this.KundeAnschriftErstellung(anschriftListe, kundeArg);
            }
            else
            {
                anschriftListe = this.FirmaAnschriftErstellung(anschriftListe, kundeArg);
            }

            anschriftListe = this.AdresseErstellung(anschriftListe, adresseArg);

            return anschriftListe;
        }

        private List<String?> KundeAnschriftErstellung(List<String?> anschriftListe, Kunde kundeArg)
        {
            String? zeileNamen = kundeArg.Titel;

            zeileNamen = StringUtil.AddOptionalPart(zeileNamen, kundeArg.Vorname);
            zeileNamen = StringUtil.AddOptionalPart(zeileNamen, kundeArg.Name);

            anschriftListe.Add(zeileNamen);

            return anschriftListe;
        }

        private List<String?> FirmaAnschriftErstellung(List<String?> anschriftListe, Kunde kundeArg)
        {
            anschriftListe.Add(kundeArg.Firma);

            if (!String.IsNullOrWhiteSpace(kundeArg.Abteilung))
            {
                anschriftListe.Add(kundeArg.Abteilung);
            }

            return anschriftListe;
        }

        private List<String?> AdresseErstellung(List<String?> anschriftListe, Adresse adresseArg)
        {
            this.ErstelleOrtsteilZeile(anschriftListe, adresseArg);
            this.ErstellePackstation(anschriftListe, adresseArg);
            this.ErstelleStrasseZeile(anschriftListe, adresseArg);
            this.ErstelleOrtsZeile(anschriftListe, adresseArg);
            this.ErstelleLandZeile(anschriftListe, adresseArg);
            return anschriftListe;
        }

        private void ErstelleStrasseZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? strasseZeile = adresseArg.Strasse;

            strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Hausnummer);

            if (!String.IsNullOrWhiteSpace(strasseZeile))
            {
                anschriftListe.Add(strasseZeile);
            }
        }

        private void ErstelleOrtsZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? ortZeile = adresseArg.PostLeitInfo;

            ortZeile = StringUtil.AddOptionalPart(ortZeile, StringUtil.ToUpperCase(adresseArg.Ort));

            if (!String.IsNullOrWhiteSpace(ortZeile))
            {
                anschriftListe.Add(ortZeile);
            }
        }

        private void ErstelleLandZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            if (!String.IsNullOrWhiteSpace(adresseArg.Land))
            {
                anschriftListe.Add(StringUtil.ToUpperCase(adresseArg.Land));
            }
        }

        private void ErstelleOrtsteilZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            if (!String.IsNullOrWhiteSpace(adresseArg.Ortsteil))
            {
                anschriftListe.Add(adresseArg.Ortsteil);
            }
        }

        private void ErstellePackstation(List<String?> anschriftListe, Adresse adresseArg)
        {
            if (!String.IsNullOrWhiteSpace(adresseArg.PackstationNr))
            {
                if (!String.IsNullOrWhiteSpace(adresseArg.PackstationKundenNr))
                {
                    anschriftListe.Add(adresseArg.PackstationKundenNr);
                }
                anschriftListe.Add("Packstation " + adresseArg.PackstationNr);
            }
        }

    }
}