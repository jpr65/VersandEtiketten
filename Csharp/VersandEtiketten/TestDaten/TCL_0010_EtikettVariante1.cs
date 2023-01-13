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
        [DataRow(0, 0)]
        [DataRow(1, 0)]
        [DataRow(7, 0)]
        [DataRow(0, 1)]
        [DataRow(0, 9)]
        [DataRow(1, 1)]
        [DataRow(2, 3)]
        public void T100_TestBelegteZeilen(int leereZeilenVorgabe, int gefuellteZeilenVorgabe)
        {
            // --- Testvorbereitung --------------------------------

            EtikettVariante1 testObject = this.CreateTestObject(leereZeilenVorgabe, gefuellteZeilenVorgabe);

            // --- Testdurchführung --------------------------------

            int zeilenBelegt = testObject.BelegteZeilenAnz();

            // --- Testvalidierung --------------------------------

            Assert.AreEqual(gefuellteZeilenVorgabe, zeilenBelegt);
        }
    }
}