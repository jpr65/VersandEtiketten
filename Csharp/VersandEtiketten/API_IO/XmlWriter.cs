using System.Xml.Serialization;

namespace API_IO
{
    public class XmlWriter<T>
    {
        public void WriteIntoFile(T dataObject, String fileName)
        {
            try
            {
                using (FileStream fileInputStream = File.OpenWrite(fileName))
                {
                    WriteIntoStream(dataObject, fileInputStream);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception FileIO! :" + ex.ToString());
            }
        }

        private void WriteIntoStream(T dataObject, FileStream fos)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(T));

            try
            {
                serializer.Serialize(fos, dataObject);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception XmlEncode:" + ex.ToString());
            }
        }
    }
}
