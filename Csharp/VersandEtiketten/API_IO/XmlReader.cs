using System.Xml.Serialization;

namespace API_IO
{
    /// <summary>
    /// API_IO: Daten-Klassen vom Typ T aus XML lesen
    /// </summary>
    /// <typeparam name="T">Zu lesender Datentyp</typeparam>
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

    public T? ReadFromStream(TextReader textReader)
        {
            XmlSerializer serializer = new XmlSerializer(typeof(T));
            T? dataObject = default(T);

            try
            {
                dataObject = (T?)serializer.Deserialize(textReader);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Exception XmlDecode:" + ex.ToString());
            }

            return dataObject;
        }
    }
}