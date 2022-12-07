using TestFixtures;

namespace TestIO
{
    /// <summary>
    /// Dieser Test schreibt die XML-Datendateien und ist normalerweise auskommentiert.
    /// </summary>
    //[TestClass]
    public class TCOI_0010_KundenUndAdressenGenerator
    {
        [TestMethod]
        public void T010_schreibeKunde()
        {
            KundenUndAdressenGenerator kundenUndAdressenGenerator = new KundenUndAdressenGenerator();

            kundenUndAdressenGenerator.SchreibeKunde("KUD0001", "Kunde.xml");
        }

        [TestMethod]
        public void T100_SchreibeAlleKunden()
        {
            KundenUndAdressenGenerator kundenUndAdressenGenerator = new KundenUndAdressenGenerator();

            kundenUndAdressenGenerator.SchreibeAlleKunden("AlleKunden.xml");
        }

        [TestMethod]
        public void T100_SchreibeAlleAdressen()
        {
            KundenUndAdressenGenerator kundenUndAdressenGenerator = new KundenUndAdressenGenerator();

            kundenUndAdressenGenerator.SchreibeAlleAdressen("AlleAdressen.xml");
        }
    }
}