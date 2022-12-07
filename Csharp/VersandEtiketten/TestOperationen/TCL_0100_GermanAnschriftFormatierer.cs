namespace TestOperationen
{
    [TestClass]
    public class TCL_0100_GermanAnschriftFormatierer
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

            adresse.Strasse = "Alt-Britz";
            adresse.Hausnummer = "18";
            adresse.PostLeitInfo = "12359";
            adresse.Ort = "Berlin";
            adresse.Ortsteil = "Ortsteil Neukoelln";
            adresse.Land = "Germany";

            return adresse;
        }

        private Adresse CreateAdressePackstation()
        {
            Adresse adresse = new Adresse();

            adresse.PackstationNr = "4711";
            adresse.PackstationKundenNr = "1234567";
            adresse.PostLeitInfo = "12359";
            adresse.Ort = "Berlin";

            return adresse;
        }

        private Adresse CreateFirmenAdresse()
        {
            Adresse adresse = new Adresse();

            adresse.Strasse = "Wittener Str.";
            adresse.Hausnummer = "45";
            adresse.PostLeitInfo = "44789";
            adresse.Ort = "Bochum";
            adresse.Land = "Germany";

            return adresse;
        }

        private Kunde CreateKunde1()
        {
            Kunde kunde = new Kunde();

            kunde.PrivatKunde = true;
            kunde.Titel = "Prof. Dr.";
            kunde.Name = "Staller";
            kunde.Vorname = "Hubert";

            return kunde;
        }

        private Kunde CreateFirmenKunde()
        {
            Kunde firmenKunde = new Kunde();

            firmenKunde.PrivatKunde = false;
            firmenKunde.Firma = "Aral AG";
            firmenKunde.Abteilung = "Tankstellen-Planung";

            return firmenKunde;
        }

        private Kunde CreateFirmenKundeOhneAbteilung()
        {
            Kunde firmenKunde = new Kunde();

            firmenKunde.PrivatKunde = false;
            firmenKunde.Firma = "Heinrich Schlotmüller GmbH";

            return firmenKunde;
        }

        #endregion

        [TestMethod]
        public void T001_GetLaenderkennung()
        {

            // --- Testvorbereitung --------------------------------

            GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            String laenderKennungResult = testObject.GetLaenderKennung();

            // --- Testvalidierung --------------------------------

            Assert.AreEqual("ger", laenderKennungResult.ToLowerInvariant());
        }

        [TestMethod]
        public void T010_AnschriftErstellung_leer()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateKundeLeer();
            Adresse adresse = this.CreateAdresseLeer();

            GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

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

            GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(5, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Prof. Dr. Hubert Staller", testResult[lineNbr++]);
            Assert.AreEqual("Ortsteil Neukoelln", testResult[lineNbr++]);
            Assert.AreEqual("Alt-Britz 18", testResult[lineNbr++]);
            Assert.AreEqual("12359 BERLIN", testResult[lineNbr++]);
            Assert.AreEqual("GERMANY", testResult[lineNbr++]);
        }

        [TestMethod]
        public void T110_AnschriftErstellung_FirmenKunde()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateFirmenKunde();
            Adresse adresse = this.CreateFirmenAdresse();

            GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(5, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Aral AG", testResult[lineNbr++]);
            Assert.AreEqual("Tankstellen-Planung", testResult[lineNbr++]);
            Assert.AreEqual("Wittener Str. 45", testResult[lineNbr++]);
            Assert.AreEqual("44789 BOCHUM", testResult[lineNbr++]);
            Assert.AreEqual("GERMANY", testResult[lineNbr++]);
        }

        [TestMethod]
        public void T120_AnschriftErstellung_FirmenKundeOhneAbteilung()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateFirmenKundeOhneAbteilung();
            Adresse adresse = this.CreateFirmenAdresse();

            GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(4, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Heinrich Schlotmüller GmbH", testResult[lineNbr++]);
            Assert.AreEqual("Wittener Str. 45", testResult[lineNbr++]);
            Assert.AreEqual("44789 BOCHUM", testResult[lineNbr++]);
            Assert.AreEqual("GERMANY", testResult[lineNbr++]);
        }

        [TestMethod]
        public void T200_AnschriftErstellung_Packstation()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateKunde1();
            Adresse adresse = this.CreateAdressePackstation();

            GermanAnschriftFormatierer testObject = new GermanAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(4, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Prof. Dr. Hubert Staller", testResult[lineNbr++]);
            Assert.AreEqual("1234567", testResult[lineNbr++]);
            Assert.AreEqual("Packstation 4711", testResult[lineNbr++]);
            Assert.AreEqual("12359 BERLIN", testResult[lineNbr++]);
        }
    }
}