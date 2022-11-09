package Integratoren;

import Operationen.IAnschriftFormatierer;
import Operationen.SpainAnschriftFormatierer;
import API.StringUtil;
import IO.EtikettDruckerStub;
import IO.IEtikettDrucker;
import Operationen.GermanAnschriftFormatierer;
import Operationen.UnitedKingdomAnschriftFormatierer;

//-------------------------------------------------------------
// Integration: Eine Factory, die Operatoren erzeugt.
//
//i/ Factories bilden eine Ausnahme, 
//i/ sie dürfen auch ein wenig Logik enthalten,
//i/ die zur Erzeugung der Instanzen benötigt wird.
//-------------------------------------------------------------
public class OperatorFactory {
	public static IAnschriftFormatierer buildAnschriftFormatierer(String laenderKennung) throws Exception {
		IAnschriftFormatierer anschriftFormatierer = null;
		
		if (StringUtil.IsEmpty(laenderKennung)) {
			throw new Exception("Keine Länderkennung angegeben!");
		}
		
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
		
		if (!anschriftFormatierer.GetLaenderKennung().toLowerCase().equals(laenderKennung.toLowerCase())) {
			throw new Exception("falsche Länderkennung des Anschrift-Formatierers (" + 
					anschriftFormatierer.GetLaenderKennung() + ") != "
					+ laenderKennung);
		}
		
		return anschriftFormatierer;
	}

	public static IEtikettDrucker buildEtikettDrucker() {
		return new EtikettDruckerStub();
	}
}
