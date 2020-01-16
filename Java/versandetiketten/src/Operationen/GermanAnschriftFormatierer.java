package Operationen;

import java.util.ArrayList;
import java.util.List;

import Daten.*;
import Operationen.IAnschriftFormatierer;

//Operation: Anschrift formatieren, deutsche Variante
public class GermanAnschriftFormatierer implements IAnschriftFormatierer {

	@Override
	public List<String> AnschriftErstellung(Kunde kundeArg, Adresse adresseArg) {
		ArrayList<String> anschriftListe = new ArrayList<String>();
		
		if (kundeArg.PrivatKunde) {
			anschriftListe = this.KundeAnschriftErstellung(anschriftListe, kundeArg);
		}
		else {
			anschriftListe = this.FirmaAnschriftErstellung(anschriftListe, kundeArg);
		}
		
		anschriftListe = this.AdresseErstellung(anschriftListe, adresseArg);
		
		return anschriftListe;
	}

	private ArrayList<String> KundeAnschriftErstellung(ArrayList<String> anschriftListe, Kunde kundeArg) {
		String zeileNamen = kundeArg.Vorname + " " + kundeArg.Name;
		anschriftListe.add(zeileNamen);
		
		return anschriftListe;
	}
	
	private ArrayList<String> FirmaAnschriftErstellung(ArrayList<String> anschriftListe, Kunde kundeArg) {
		anschriftListe.add(kundeArg.Firma);
		if (!kundeArg.Abteilung.isBlank()) {
			anschriftListe.add(kundeArg.Abteilung);
		}
		
		return anschriftListe;
	}

	private ArrayList<String> AdresseErstellung(ArrayList<String> anschriftListe, Adresse adresseArg) {
		anschriftListe.add(this.ErstelleStrasseZeile(adresseArg));
		anschriftListe.add(this.ErstelleOrtsZeile(adresseArg));
		return anschriftListe;
	}

	private String ErstelleStrasseZeile(Adresse adresseArg) {
		String strasseZeile = adresseArg.Strasse;
		
		if (!adresseArg.Hausnummer.isBlank()) {
			if (!strasseZeile.isBlank()) {
				strasseZeile += " ";
			}
			
			strasseZeile += adresseArg.Hausnummer;
		}
		
		return strasseZeile;
	}

	private String ErstelleOrtsZeile(Adresse adresseArg) {
		String ortZeile = adresseArg.PostLeitInfo + " " + adresseArg.Ort;
		
		return ortZeile;
	}

	
	

}
