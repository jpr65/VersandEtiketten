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

        private void WriteIntoStream(T dataObject, StreamWriter streamWriter)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(T));

            try
            {
                serializer.Serialize(streamWriter, dataObject);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception XmlEncode:" + ex.ToString());
            }
        }
    }
}
