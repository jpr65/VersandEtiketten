package Operationen;

import java.util.List;

import Daten.Adresse;
import Daten.Kunde;

public interface IAnschriftFormatierer {
	public List<String> AnschriftErstellung(Kunde KundeArg, Adresse AdresseArg);
}
