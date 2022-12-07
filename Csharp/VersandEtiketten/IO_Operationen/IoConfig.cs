using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IO_Operationen
{
    /// <summary>
    /// IO-Configuration mit Pfaden, z.B. für Zugriff auf Datendateien
    /// </summary>
    public class IoConfig
    {
        static public String StubXmlDataPath
        {
            get
            {
                return "Z:\\user\\rp\\prj_public\\Beispiele\\Versandetiketten\\Csharp\\Data";
            }
        }
    }
}
