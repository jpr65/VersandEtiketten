package IO;

import Daten.Adresse;
import Daten.Kunde;

//---------------------------------------------------------------------------------
// Interface zur Middleware
//---------------------------------------------------------------------------------

public interface MiddleWareInterface {
	public Adresse leseAdresse(String adresseID ) throws Exception;
	public Kunde leseKunde(String kundeID ) throws Exception;
}
