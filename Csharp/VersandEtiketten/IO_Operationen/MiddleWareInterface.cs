using Daten;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IO_Operationen
{
    /// <summary>
    /// Interface zur Middleware
    /// </summary>
    public interface MiddleWareInterface
    {
        public Adresse LeseAdresse(String? adresseID);
        public Kunde LeseKunde(String? kundeID);
    }
}
