package Operationen;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;

//-------------------------------------------------------------
// Interface f�r die Anschrift-Formatierer,
// f�r jedes Land wird ein eigener Formatierer implementiert
//-------------------------------------------------------------
public interface IAnschriftFormatierer {
	public String GetLaenderKennung();
	public List<String> AnschriftErstellung(Kunde KundeArg, Adresse AdresseArg);
}
