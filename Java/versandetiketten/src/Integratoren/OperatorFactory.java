package Integratoren;

import Operationen.IAnschriftFormatierer;
import Operationen.GermanAnschriftFormatierer;

// Eine Factory, die Operatoren erzeugt
public class OperatorFactory {
	public static IAnschriftFormatierer BuildAnschriftFormatierer(String laenderKennung) {
		if (laenderKennung.toLowerCase().equals("ger")) {
			return new GermanAnschriftFormatierer();			
		}
		
		return null;
	}
}
