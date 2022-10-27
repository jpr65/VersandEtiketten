package IO;

import Daten.Adresse;
import Daten.Kunde;

//---------------------------------------------------------------------------------
// Interface zur Middleware
//---------------------------------------------------------------------------------

public interface MiddleWareInterface {
	public Adresse LeseAdresse(String adresseID ) throws Exception;
	public Kunde LeseKunde(String kundeID ) throws Exception;
}
