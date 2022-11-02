package IO;

import java.util.List;

//-------------------------------------------------------------
// IO-Interface zum Druck von Etiketten
//-------------------------------------------------------------
public interface IEtikettDrucker {
	public void druckeEtikett(List<String> zeilen);
}
