using API;
using Daten;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Operationen
{
    /// <summary>
    /// Operation: Anschrift formatieren, Variante für ESP (Spanien)
    /// https://www.upu.int/en/Postal-Solutions/Programmes-Services/Addressing-Solutions
    /// Siehe Doku-Ordner, espEn.pdf
    /// </summary>
    public class SpainAnschriftFormatierer : IAnschriftFormatierer
    {

        private String laenderKennung = "ESP";


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
            this.ErstelleProvinzZeile(anschriftListe, adresseArg);
            this.ErstelleLandZeile(anschriftListe, adresseArg);

            return anschriftListe;
        }

        private void ErstelleStrasseZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? strasseZeile = adresseArg.Strasse;

            strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Hausnummer);
            strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Flur, ", ");
            strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Tuer, ", ");

            if (!String.IsNullOrWhiteSpace(strasseZeile))
            {
                anschriftListe.Add(strasseZeile);
            }
        }

        private void ErstelleOrtsteilZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            if (!String.IsNullOrWhiteSpace(adresseArg.Ortsteil))
            {
                anschriftListe.Add(adresseArg.Ortsteil);
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
            String? land = StringUtil.ToUpperCase(adresseArg.Land);

            if (!String.IsNullOrWhiteSpace(land))
            {
                anschriftListe.Add(land);
            }
        }

        private void ErstelleProvinzZeile(List<String?> anschriftListe, Adresse adresseArg)
        {
            String? provinz = StringUtil.ToUpperCase(adresseArg.Provinz);

            if (!String.IsNullOrWhiteSpace(provinz))
            {
                anschriftListe.Add(provinz);
            }
        }
    }
}
