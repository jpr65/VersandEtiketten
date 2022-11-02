package Integratoren;

import IO.MiddleWareStub;
import IO.MiddleWareInterface;

//--------------------------------------------------------------------------
// Integration: Eine Factory, die eine Anbindung an die Au�enwelt erzeugt.
//--------------------------------------------------------------------------
public class IoFactory {
	
	public static MiddleWareStub middleWareStub = new MiddleWareStub();

	public static MiddleWareInterface getMiddleWare() {
		
		return middleWareStub;
	}

}
