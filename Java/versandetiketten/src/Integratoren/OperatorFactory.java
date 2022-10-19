package Integratoren;

import Operationen.IAnschriftFormatierer;
import Operationen.SpainAnschriftFormatierer;
import IO.EtikettDruckerStub;
import IO.IEtikettDrucker;
import Operationen.GermanAnschriftFormatierer;
import Operationen.UnitedKingdomAnschriftFormatierer;

//-------------------------------------------------------------
// Eine Factory, die Operatoren erzeugt.
// Ein Integrator, der auch ein wenig Logik enthält.
//-------------------------------------------------------------
public class OperatorFactory {
	public static IAnschriftFormatierer BuildAnschriftFormatierer(String laenderKennung) throws Exception {
		IAnschriftFormatierer anschriftFormatierer = null;
		
		if (laenderKennung.toLowerCase().equals("ger")) {
			anschriftFormatierer = new GermanAnschriftFormatierer();			
		}
		
		if (laenderKennung.toLowerCase().equals("gbr")) {
			anschriftFormatierer =  new UnitedKingdomAnschriftFormatierer();			
		}
		
		if (laenderKennung.toLowerCase().equals("esp")) {
			anschriftFormatierer = new SpainAnschriftFormatierer();			
		}
		
		if (anschriftFormatierer == null) {
			throw new Exception("Kein Formatierer für Länderkennung " + laenderKennung);
		}
		
		if (!anschriftFormatierer.GetLaenderKennung().toLowerCase().contentEquals(laenderKennung.toLowerCase())) {
			throw new Exception("falsche Länderkennung des Anschrift-Formatierers (" + 
					anschriftFormatierer.GetLaenderKennung() + ") != "
					+ laenderKennung);
		}
		
		return anschriftFormatierer;
	}

	public static IEtikettDrucker BuildEtikettDrucker() {
		return new EtikettDruckerStub();
	}
}
