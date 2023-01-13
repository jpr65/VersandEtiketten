namespace TestAPI_IO
{
    [TestClass]
    public class TCA_0010_XmlSerialisierung
    {
        private String TestDataPath = TestIoConfig.TestXmlDataPath;

        [TestMethod]
        public void T_010_CreateReadDelete_SingleXml()
        {
            IoDataForXml testData = new IoDataForXml
            {
                Alter = DateTime.Now.Second,
                Name = "Jedermann"
            };

            string testFileName = Path.Combine(TestDataPath, "testSingleElement.xml");

            // --- Test Write --------------------------------------------------------
            
            XmlWriter<IoDataForXml> xmlWriter = new XmlWriter<IoDataForXml>();

            xmlWriter.WriteIntoFile(testData, testFileName);

            Assert.IsTrue(File.Exists(testFileName));

            // --- Test Read --------------------------------------------------------
            
            XmlReader<IoDataForXml> xmlReader = new XmlReader<IoDataForXml>();

            IoDataForXml? dataRead = xmlReader.ReadFromFile(testFileName);

            Assert.IsNotNull(dataRead);

            Assert.AreEqual(testData.Name, dataRead.Name);
            Assert.AreEqual(testData.Alter, dataRead.Alter);

            // --- Aufräumen und Datei löschen ---------------------------------------
            
            File.Delete(testFileName);

            Assert.IsFalse(File.Exists(testFileName));
        }
    }
}