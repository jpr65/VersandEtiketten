package Operationen;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;

//-------------------------------------------------------------
// Interface für die Anschrift-Formatierer,
// für jedes Land wird ein eigener Formatierer implementiert
//-------------------------------------------------------------
public interface IAnschriftFormatierer {
	public String GetLaenderKennung();
	public List<String> AnschriftErstellung(Kunde KundeArg, Adresse AdresseArg);
}
