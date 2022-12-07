using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestOperationen
{
    [TestClass]
    public class TCL_0120_SpainAnschriftFormatierer
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

            adresse.Strasse = "Calle Huertas";
            adresse.Hausnummer = "18";
            adresse.Flur = "4°";
            adresse.Tuer = "C";
            adresse.PostLeitInfo = "09692";
            adresse.Ort = "Canicosa De La Sierra";
            adresse.Ortsteil = "Barrio de San Roque";
            adresse.Provinz = "Burgos";
            adresse.Land = "Spain";

            return adresse;
        }

        private Adresse CreateAdresse2()
        {
            Adresse adresse = new Adresse();

            adresse.PostLeitInfo = "08028";
            adresse.Ort = "Barcelona";
            adresse.Strasse = "Av. Joan XXIII";
            adresse.Flur = "s/n";
            adresse.Land = "Spain";

            return adresse;
        }

        private Kunde CreateKunde1()
        {
            Kunde kunde = new Kunde();

            kunde.Vorname = "Naviera";
            kunde.Name = "Casarejos";
            kunde.PrivatKunde = true;

            return kunde;
        }

        private Kunde CreateFirmenKunde()
        {
            Kunde firmenKunde = new Kunde();

            firmenKunde.PrivatKunde = false;
            firmenKunde.Firma = "FC Barcelona";
            firmenKunde.Abteilung = "Shop";

            return firmenKunde;
        }

        private Kunde CreateFirmenKundeOhneAbteilung()
        {
            Kunde firmenKunde = new Kunde();

            firmenKunde.PrivatKunde = false;
            firmenKunde.Firma = "International Imports";

            return firmenKunde;
        }
        #endregion


        /**
         * Test method for {@link Operationen.SpainAnschriftFormatierer#GetLaenderkennung()}.
         */
        [TestMethod]
        public void T001_GetLaenderkennung()
        {

            // --- Testvorbereitung --------------------------------

            SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            String laenderKennungResult = testObject.GetLaenderKennung();

            // --- Testvalidierung --------------------------------

            Assert.AreEqual("esp", laenderKennungResult.ToLowerInvariant());
        }

        /**
         * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
         */
        [TestMethod]
        public void T010_AnschriftErstellung_leer()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateKundeLeer();
            Adresse adresse = this.CreateAdresseLeer();

            SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(1, testResult.Count);
            Assert.AreEqual("", testResult[0]);
        }

        /**
         * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
         */
        [TestMethod]
        public void T100_AnschriftErstellung_PrivatKunde()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateKunde1();
            Adresse adresse = this.CreateAdresse1();

            SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(6, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("Naviera Casarejos", testResult[lineNbr++]);
            Assert.AreEqual("Calle Huertas 18, 4°, C", testResult[lineNbr++]);
            Assert.AreEqual("Barrio de San Roque", testResult[lineNbr++]);
            Assert.AreEqual("09692 CANICOSA DE LA SIERRA", testResult[lineNbr++]);
            Assert.AreEqual("BURGOS", testResult[lineNbr++]);
            Assert.AreEqual("SPAIN", testResult[lineNbr++]);
        }

        /**
         * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
         */
        [TestMethod]
        public void T110_AnschriftErstellung_FirmenKunde()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateFirmenKunde();
            Adresse adresse = this.CreateAdresse2();

            SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(5, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("FC Barcelona", testResult[lineNbr++]);
            Assert.AreEqual("Shop", testResult[lineNbr++]);
            Assert.AreEqual("Av. Joan XXIII, s/n", testResult[lineNbr++]);
            Assert.AreEqual("08028 BARCELONA", testResult[lineNbr++]);
            Assert.AreEqual("SPAIN", testResult[lineNbr++]);
        }

        /**
         * Test method for {@link Operationen.SpainAnschriftFormatierer#AnschriftErstellung(Kunde kundeArg, Adresse adresseArg)}.
         */
        [TestMethod]
        public void T120_AnschriftErstellung_FirmenKundeOhneAbteilung()
        {

            // --- Testvorbereitung --------------------------------

            Kunde kunde = this.CreateFirmenKundeOhneAbteilung();
            Adresse adresse = this.CreateAdresse2();

            SpainAnschriftFormatierer testObject = new SpainAnschriftFormatierer();

            // --- Testdurchführung --------------------------------

            List<String?> testResult = testObject.AnschriftErstellung(kunde, adresse);

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(4, testResult.Count);
            int lineNbr = 0;
            Assert.AreEqual("International Imports", testResult[lineNbr++]);
            Assert.AreEqual("Av. Joan XXIII, s/n", testResult[lineNbr++]);
            Assert.AreEqual("08028 BARCELONA", testResult[lineNbr++]);
            Assert.AreEqual("SPAIN", testResult[lineNbr++]);
        }
    }
}
