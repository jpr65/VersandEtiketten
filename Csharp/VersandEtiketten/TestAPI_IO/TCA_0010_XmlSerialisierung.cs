using API_IO;
using IO_Operationen;
using System.Xml;

namespace TestAPI_IO
{
    [TestClass]
    public class TCA_0010_XmlSerialisierung
    {
        private String TestDataPath = IoConfig.StubXmlDataPath;

        [TestMethod]
        public void CRUD_SingleXml()
        {
            IoDataForXml testData = new IoDataForXml
            {
                Alter = 10,
                Name = "Jedermann"
            };

            string testFileName = Path.Combine(TestDataPath, "testSingleElement.xml");

            XmlWriter<IoDataForXml> xmlWriter = new XmlWriter<IoDataForXml>();

            xmlWriter.WriteIntoFile(testData, testFileName);

            XmlReader<IoDataForXml> xmlReader = new XmlReader<IoDataForXml>();

            IoDataForXml? dataRead = xmlReader.ReadFromFile(testFileName);

            Assert.IsNotNull(dataRead);

            Assert.AreEqual(testData.Name, dataRead.Name);
            Assert.AreEqual(testData.Alter, dataRead.Alter);

        }
    }
}