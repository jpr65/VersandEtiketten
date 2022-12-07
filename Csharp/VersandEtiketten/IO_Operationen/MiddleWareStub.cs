using Daten;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IO_Operationen
{
    /// <summary>
    /// IO-Stub, der Kunden-Infos und Adressen liefert.
    /// Diese Daten werden üblicherweise von der Middleware 
    /// oder einer Persistenz-API bereitgestellt.
    /// Der Stub wird nur solange benötigt, bis eine Implementierung
    /// im realen System vorliegt.
    ///
    ///i/ Zum Testen der Operations-Klassen "*AnschriftFormatierer" werden weder der Stub
    ///i/ noch die spätere Implementierung verwendet.
    ///i/ Die Operations-Klassen haben keinen Zugriff auf die IO-Klassen, das ist nur
    ///i/ den Integrations-Klassen erlaubt.
    /// </summary>
    public class MiddleWareStub : MiddleWareInterface
    {
        private Dictionary<String, Kunde> kundeDict = new Dictionary<String, Kunde>();
        private Dictionary<String, Adresse> adresseDict = new Dictionary<String, Adresse>();

        public Adresse LeseAdresse(String? adresseID)
        {
            if (adresseID == null)
            {
                throw new Exception("adresseID nicht gesetzt!");
            }

            Adresse adresse = adresseDict[adresseID];

            if (adresse == null)
            {
                throw new Exception("adresse zu ID " + adresseID + " unbekannt!");
            }

            return adresse;
        }


        public Kunde LeseKunde(String? kundeID)
        {
            if (kundeID == null)
            {
                throw new Exception("kundeID nicht gesetzt!");
            }

            Kunde kunde = kundeDict[kundeID];

            if (kunde == null)
            {
                throw new Exception("kunde zu ID " + kundeID + " unbekannt!");
            }

            return kunde;
        }


        public void FillKundeDict(List<Kunde>? kundeListe)
        {
            if (kundeListe == null)
            {
                return;
            }

            kundeDict = new Dictionary<String, Kunde>();

            foreach (Kunde kunde in kundeListe)
            {
                if (kunde.PKID != null)
                {
                    kundeDict.Add(kunde.PKID, kunde);
                }
            }
        }

        public void FillAdresseDict(List<Adresse>? adresseListe)
        {
            if (adresseListe == null)
            {
                return;
            }

            adresseDict = new Dictionary<String, Adresse>();

            foreach (Adresse adresse in adresseListe)
            {
                if (adresse.PKID != null)
                {
                    adresseDict.Add(adresse.PKID, adresse);
                }
            }
        }
    }
}
