package IO;

import java.util.Iterator;
import java.util.List;

// ------------------------------------------------------------
// IO-Operation: Stub eines Etikettdruckers für die Demo
//-------------------------------------------------------------
public class EtikettDruckerStub implements IEtikettDrucker {

	@Override
	public void DruckeEtikett(List<String> etikettZeilen) {
		Iterator<String> iter = etikettZeilen.iterator();
		
		while (iter.hasNext()) {
			String anschriftZeile = iter.next();
			System.out.println(anschriftZeile);
		}
		
		System.out.println("------------------------------------------");
	}
}
