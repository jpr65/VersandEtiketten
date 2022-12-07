using System.Xml.Serialization;
using TestFixtures;

namespace TestIO
{
    /// <summary>
    /// Dieser Test schreibt die XML-Datendateien, die vom MiddleWareStub gelesen werden.
    /// </summary>
    [TestClass]
    public class TCOI_0010_KundenUndAdressenGenerator
    {
        private String TestDataPath = TestIoConfig.TestXmlDataPath;

        private KundenUndAdressenGenerator CreateTestObject()
        {
            return new KundenUndAdressenGenerator()
            {
                XmlDataPath = TestDataPath
            };
        }

        [TestMethod]
        public void T010_schreibeKunde()
        {
            KundenUndAdressenGenerator kundenUndAdressenGenerator = CreateTestObject();

            kundenUndAdressenGenerator.SchreibeKunde("KUD0001", "Kunde.xml");

            Assert.IsTrue(File.Exists(Path.Combine(TestDataPath, "Kunde.xml")));
        }

        [TestMethod]
        public void T100_SchreibeAlleKunden()
        {
            KundenUndAdressenGenerator kundenUndAdressenGenerator = CreateTestObject();

            kundenUndAdressenGenerator.SchreibeAlleKunden("AlleKunden.xml");

            Assert.IsTrue(File.Exists(Path.Combine(TestDataPath, "AlleKunden.xml")));
        }

        [TestMethod]
        public void T100_SchreibeAlleAdressen()
        {
            KundenUndAdressenGenerator kundenUndAdressenGenerator = CreateTestObject();

            kundenUndAdressenGenerator.SchreibeAlleAdressen("AlleAdressen.xml");

            Assert.IsTrue(File.Exists(Path.Combine(TestDataPath, "AlleAdressen.xml")));
        }
    }
}