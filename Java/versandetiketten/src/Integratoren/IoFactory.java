package Integratoren;

import IO.MiddleWareStub;
import IO.MiddleWareInterface;

public class IoFactory {
	
	public static MiddleWareStub middleWareStub = new MiddleWareStub();

	public static MiddleWareInterface GetMiddleWare() {
		
		return middleWareStub;
	}

}
