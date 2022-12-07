using API;
using Daten;

namespace Operationen
{
    /// <summary>
    /// Operation: Anschrift formatieren, Variante für GBR (UnitedKingdom)
    /// https://www.upu.int/en/Postal-Solutions/Programmes-Services/Addressing-Solutions
    /// Siehe Doku-Ordner, gbrEn.pdf
    /// </summary>
    public class UnitedKingdomAnschriftFormatierer : IAnschriftFormatierer
    {

        private String laenderKennung = "GBR";


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
            this.ErstelleStrasseZeile(anschriftListe, adresseArg);
            this.ErstelleOrtsteilZeile(anschriftListe, adresseArg);
            this.ErstelleOrtsZeile(anschriftListe, adresseArg);
            this.ErstellePostcodeZeile(anschriftListe, adresseArg);
            this.ErstelleLandZeile(anschriftListe, adresseArg);
            return anschriftListe;
        }

        private void ErstelleStrasseZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? strasseZeile = StringUtil.AddOptionalPart(adresseArg.Hausnummer, adresseArg.Strasse);

            if (!String.IsNullOrWhiteSpace(strasseZeile))
            {
                anschriftListe.Add(strasseZeile);
            }
        }

        private void ErstellePostcodeZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            if (!String.IsNullOrWhiteSpace(adresseArg.PostLeitInfo))
            {
                anschriftListe.Add(adresseArg.PostLeitInfo);
            }
        }

        private void ErstelleOrtsZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? ortZeile = StringUtil.ToUpperCase(adresseArg.Ort);

            if (!String.IsNullOrWhiteSpace(ortZeile))
            {
                anschriftListe.Add(ortZeile);
            }
        }

        private void ErstelleLandZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? land = StringUtil.ToUpperCase(adresseArg.Land);

            if (!String.IsNullOrWhiteSpace(land))
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
    }
}
