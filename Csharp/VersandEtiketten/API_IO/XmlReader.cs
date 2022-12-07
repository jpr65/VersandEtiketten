using System.Xml.Serialization;

namespace API_IO
{
    public class XmlReader<T>
    {
       public T? ReadFromFile(String fileName)
        {
            T? dezerialized = default(T);

            try
            {
                using (StreamReader fileInputStream = new StreamReader(fileName))
                {
                    return ReadFromStream(fileInputStream);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception FileIO! :" + ex.ToString());
            }

            return dezerialized;
        }

    private T? ReadFromStream(StreamReader fileInputStream)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(T));
            T? dataObject = default(T);

            try
            {
                dataObject = (T?)serializer.Deserialize(fileInputStream);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception XmlDecode:" + ex.ToString());
            }

            return dataObject;
        }
    }
}