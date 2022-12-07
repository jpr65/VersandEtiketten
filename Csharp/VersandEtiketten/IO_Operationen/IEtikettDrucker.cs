using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace IO_Operationen
{
    /// <summary>
    /// IO-Interface zum Druck von Etiketten
    /// </summary>
    public interface IEtikettDrucker
    {
        public void DruckeEtikett(List<String?>? zeilen);
    }
}
