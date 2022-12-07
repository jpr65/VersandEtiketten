using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TestAPI_IO
{
    [TestClass]
    public class TCA_0001_ManageTestDirs
    {
        private String TestDataPath = TestIoConfig.TestXmlDataPath;

        [TestMethod]
        public void T000_CreateDirs()
        {
            Directory.CreateDirectory(TestDataPath);

            Assert.IsTrue(Directory.Exists(TestDataPath));
        }

        [TestMethod]
        public void T010_CleanUpDirs()
        {
            foreach (string fileName in Directory.GetFiles(TestDataPath))
            {
                File.Delete(fileName);
            }

            int countFiles = Directory.GetFiles(TestDataPath).Count();

            Assert.AreEqual(0, countFiles, "Nicht alles gelöscht!");
        }
    }
}
