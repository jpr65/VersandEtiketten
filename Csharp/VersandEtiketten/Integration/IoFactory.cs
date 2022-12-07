using IO_Operationen;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Integration
{
    /// <summary>
    /// Integration: Eine Factory, die eine Anbindung an die Außenwelt erzeugt.
    /// </summary>
    public class IoFactory
    {
        public static MiddleWareStub middleWareStub = new MiddleWareStub();

        public static MiddleWareInterface getMiddleWare()
        {
            return middleWareStub;
        }
    }
}
