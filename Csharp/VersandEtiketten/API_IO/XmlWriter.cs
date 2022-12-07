using System.Xml.Serialization;

namespace API_IO
{
    public class XmlWriter<T>
    {
        public void WriteIntoFile(T dataObject, String fileName)
        {
            try
            {
                using (StreamWriter fileInputStream = new StreamWriter(fileName))
                {
                    WriteIntoStream(dataObject, fileInputStream);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception FileIO! :" + ex.ToString());
            }
        }

        public void WriteIntoStream(T dataObject, TextWriter textWriter)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(T));

            try
            {
                serializer.Serialize(textWriter, dataObject);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception XmlEncode:" + ex.ToString());
            }
        }
    }
}
