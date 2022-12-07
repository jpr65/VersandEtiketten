namespace TestDaten
{
    [TestClass]
    public class TCL_0010_EtikettVariante1
    {
        private EtikettVariante1 CreateTestObject(int leereZeilen, int gefuellteZeilen)
        {
            EtikettVariante1 testObject = new EtikettVariante1();

            testObject.AnschriftZeilen = new List<String?>();

            for (int idx = 0; idx < leereZeilen; idx++)
            {
                testObject.AnschriftZeilen.Add("");
            }

            for (int idx = 0; idx < gefuellteZeilen; idx++)
            {
                testObject.AnschriftZeilen.Add("Zeile " + idx);
            }

            return testObject;
        }

        [TestMethod]
        public void T010_BelegteZeilenAnz_ListIsNull()
        {
            // --- Testvorbereitung --------------------------------

            EtikettVariante1 testObject = new EtikettVariante1();

            // --- Testdurchführung --------------------------------

            int zeilenBelegt = testObject.BelegteZeilenAnz();

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(0, zeilenBelegt);
        }

        [TestMethod]
        public void T010_belegteZeilen_0_0()
        {
            TestBelegteZeilen(0, 0);
        }

        private void TestBelegteZeilen(int leereZeilenVorgabe, int gefuellteZeilenVorgabe)
        {
            // --- Testvorbereitung --------------------------------

            EtikettVariante1 testObject = this.CreateTestObject(leereZeilenVorgabe, gefuellteZeilenVorgabe);

            // --- Testdurchführung --------------------------------

            int zeilenBelegt = testObject.BelegteZeilenAnz();

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(gefuellteZeilenVorgabe, zeilenBelegt);
        }

        [TestMethod]
        public void T100_belegteZeilen_1_0()
        {
            TestBelegteZeilen(1, 0);
        }

        [TestMethod]
        public void T110_belegteZeilen_7_0()
        {
            TestBelegteZeilen(1, 0);
        }

        [TestMethod]
        public void T200_belegteZeilen_0_1()
        {
            TestBelegteZeilen(0, 1);
        }

        [TestMethod]
        public void T210_belegteZeilen_0_9()
        {
            TestBelegteZeilen(0, 9);
        }

        [TestMethod]
        public void T300_belegteZeilen_1_1()
        {
            TestBelegteZeilen(0, 1);
        }

        [TestMethod]
        public void T310_belegteZeilen_2_3()
        {
            TestBelegteZeilen(2, 3);
        }
    }
}