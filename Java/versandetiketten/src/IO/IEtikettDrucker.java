package IO;

import java.util.List;

//-------------------------------------------------------------
// IO-Interface zum Druck von Etiketten
//-------------------------------------------------------------
public interface IEtikettDrucker {
	public void DruckeEtikett(List<String> zeilen);
}
