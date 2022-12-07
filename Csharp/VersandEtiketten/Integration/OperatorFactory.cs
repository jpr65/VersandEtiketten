using IO_Operationen;
using Operationen;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Integration
{
    /// <summary>
    /// Integration: Eine Factory, die Operatoren erzeugt.
    ///
    ///i/ Factories bilden eine Ausnahme, 
    ///i/ sie dürfen auch ein wenig Logik enthalten,
    ///i/ die zur Erzeugung der Instanzen benötigt wird.
    /// </summary>
    public class OperatorFactory
    {
        public static IAnschriftFormatierer buildAnschriftFormatierer(String laenderKennung)
        {
            IAnschriftFormatierer? anschriftFormatierer = null;

            if (String.IsNullOrWhiteSpace(laenderKennung))
            {
                throw new Exception("Keine Länderkennung angegeben!");
            }

            if (laenderKennung.ToLowerInvariant() == "ger")
            {
                anschriftFormatierer = new GermanAnschriftFormatierer();
            }

            if (laenderKennung.ToLowerInvariant() == "gbr")
            {
                anschriftFormatierer = new UnitedKingdomAnschriftFormatierer();
            }

            if (laenderKennung.ToLowerInvariant() == "esp")
            {
                anschriftFormatierer = new SpainAnschriftFormatierer();
            }

            if (anschriftFormatierer == null)
            {
                throw new Exception("Kein Formatierer für Länderkennung " + laenderKennung);
            }

            if (anschriftFormatierer.GetLaenderKennung().ToLowerInvariant() != laenderKennung.ToLowerInvariant())
            {
                throw new Exception("falsche Länderkennung des Anschrift-Formatierers (" +
                        anschriftFormatierer.GetLaenderKennung() + ") != "
                        + laenderKennung);
            }

            return anschriftFormatierer;
        }

        public static IEtikettDrucker buildEtikettDrucker()
        {
            return new EtikettDruckerStub();
        }
    }
}
