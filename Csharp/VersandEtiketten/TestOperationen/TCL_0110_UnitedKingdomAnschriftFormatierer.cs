using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestOperationen
{
    [TestClass]
    public class TCL_0110_UnitedKingdomAnschriftFormatierer
    {
        #region Testvorbereitung ----------------------------------------------------
        private Adresse CreateAdresseLeer()
        {
            return new Adresse();
        }

        private Kunde CreateKundeLeer()
        {
            return new Kunde();
        }

        private Adresse CreateAdresse1()
        {
            Adresse adresse = new Adresse();

            adresse.Strasse = "Upper Littleton";
            adresse.Hausnummer = "1";
            adresse.PostLeitInfo = "OX14 4PG";
            adresse.Ort = "Abingdon";
            adresse.Ortsteil = "Appleford";
            adresse.Land = "United Kingdom";

            return adresse;
        }

        private Adresse CreateAdresse2()
        {
            Adresse adresse = new Adresse();

            adresse.Strasse = "John Street";
            adresse.Hausnummer = "27";
            adresse.PostLeitInfo = "SO23 9AP";
            adresse.Ort = "Winchester";
            adresse.Land = "United Kingdom";

            return adresse;
        }

        private Kunde CreateKunde1()
        {
            Kunde kunde = new Kunde();

            kunde.PrivatKunde = true;
            kunde.Name = "Poppins";
            kunde.Vorname = "Mary";

            return kunde;
        }

        private Kunde CreateFirmenKunde()
        {
            Kunde firmenKunde = new Kunde();

            firmenKunde.PrivatKunde = false;
            firmenKunde.Firma = "Testing Company";
            firmenKunde.Abteilung = "Test Development";

            return firmenKunde;
        }

        private Kunde CreateFirmenKundeOhneAbteilung()
        {
            Kunde firmenKunde = new Kunde();

            firmenKunde.PrivatKunde = false;
            firmenKunde.Firma = "Import INC";

            return firmenKunde;
        }
        #endregion

        [TestMethod]
        public void T001_GetLaenderkennung()
        {

            // --- Testvorbereitung --------------------------------

            UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            String laenderKennungResult = testObject.GetLaenderKennung();

            // --- Testvalidierung --------------------------------

            Assert.AreEqual("gbr", laenderKennungResult.ToLowerInvariant());
        }

        [TestMethod]
        public void T010_AnschriftErstellung_leer()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateKundeLeer();
            Adresse adresse = this.CreateAdresseLeer();

            UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(1, testResult.Count);
            Assert.AreEqual("", testResult[0]);
        }

        [TestMethod]
        public void T100_AnschriftErstellung_PrivatKunde()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateKunde1();
            Adresse adresse = this.CreateAdresse1();

            UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(6, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Mary Poppins", testResult[lineNbr++]);
            Assert.AreEqual("1 Upper Littleton", testResult[lineNbr++]);
            Assert.AreEqual("Appleford", testResult[lineNbr++]);
            Assert.AreEqual("ABINGDON", testResult[lineNbr++]);
            Assert.AreEqual("OX14 4PG", testResult[lineNbr++]);
            Assert.AreEqual("UNITED KINGDOM", testResult[lineNbr++]);
        }

        [TestMethod]
        public void T110_AnschriftErstellung_FirmenKunde()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateFirmenKunde();
            Adresse adresse = this.CreateAdresse1();

            UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(7, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Testing Company", testResult[lineNbr++]);
            Assert.AreEqual("Test Development", testResult[lineNbr++]);
            Assert.AreEqual("1 Upper Littleton", testResult[lineNbr++]);
            Assert.AreEqual("Appleford", testResult[lineNbr++]);
            Assert.AreEqual("ABINGDON", testResult[lineNbr++]);
            Assert.AreEqual("OX14 4PG", testResult[lineNbr++]);
            Assert.AreEqual("UNITED KINGDOM", testResult[lineNbr++]);
        }

        [TestMethod]
        public void T120_AnschriftErstellung_FirmenKundeOhneAbteilung()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateFirmenKundeOhneAbteilung();
            Adresse adresse = this.CreateAdresse2();

            UnitedKingdomAnschriftFormatierer testObject = new UnitedKingdomAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(5, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Import INC", testResult[lineNbr++]);
            Assert.AreEqual("27 John Street", testResult[lineNbr++]);
            Assert.AreEqual("WINCHESTER", testResult[lineNbr++]);
            Assert.AreEqual("SO23 9AP", testResult[lineNbr++]);
            Assert.AreEqual("UNITED KINGDOM", testResult[lineNbr++]);
        }
    }
}
