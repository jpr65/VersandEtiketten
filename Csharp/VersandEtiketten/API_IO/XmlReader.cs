using System.Xml.Serialization;

namespace API_IO
{
    public class XmlReader<T>
    {
       public T? readFromFile(String fileName)
        {
            T? dezerialized = default(T);

            try
            {
                using (FileStream fileInputStream = File.OpenRead(fileName))
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

    private T? ReadFromStream(FileStream fileInputStream)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(List<T>));
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