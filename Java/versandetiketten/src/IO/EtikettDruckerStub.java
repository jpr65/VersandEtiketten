package IO;

import java.util.Iterator;
import java.util.List;

// ------------------------------------------------------------
// IO-Operation: Stub eines Etikettdruckers für die Demo
//
// Hier würde üblicherweise ein Interface
// zu einem echten Drucker bedient.
//-------------------------------------------------------------
public class EtikettDruckerStub implements IEtikettDrucker {

	@Override
	public void druckeEtikett(List<String> etikettZeilen) {
		Iterator<String> iter = etikettZeilen.iterator();
		
		while (iter.hasNext()) {
			String anschriftZeile = iter.next();
			System.out.println(anschriftZeile);
		}
		
		System.out.println("------------------------------------------");
	}
}
