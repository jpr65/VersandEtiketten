package Operationen;

import java.util.ArrayList;
import java.util.List;

import API.StringUtil;
import Daten.*;
import Operationen.IAnschriftFormatierer;

//----------------------------------------------------------------------------------
// Operation: Anschrift formatieren, Variante für Deutschland (GER)
// https://www.upu.int/en/Postal-Solutions/Programmes-Services/Addressing-Solutions
// Siehe Doku-Ordner, deuEn.pdf
//----------------------------------------------------------------------------------
public class GermanAnschriftFormatierer implements IAnschriftFormatierer {

	private String laenderKennung = "GER";

	@Override
	public String GetLaenderKennung() {
		return laenderKennung;
	}
	
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
		String zeileNamen = kundeArg.Titel;
		
		zeileNamen = StringUtil.AddOptionalPart(zeileNamen, kundeArg.Vorname);
		zeileNamen = StringUtil.AddOptionalPart(zeileNamen, kundeArg.Name);

		anschriftListe.add(zeileNamen);
		
		return anschriftListe;
	}
	
	private ArrayList<String> FirmaAnschriftErstellung(ArrayList<String> anschriftListe, Kunde kundeArg) {
		anschriftListe.add(kundeArg.Firma);
		
		if (!StringUtil.IsEmpty(kundeArg.Abteilung)) {
			anschriftListe.add(kundeArg.Abteilung);
		}
		
		return anschriftListe;
	}

	private ArrayList<String> AdresseErstellung(ArrayList<String> anschriftListe, Adresse adresseArg) {
		this.ErstelleOrtsteilZeile(anschriftListe, adresseArg);
		this.ErstellePackstation(anschriftListe, adresseArg);
		this.ErstelleStrasseZeile(anschriftListe, adresseArg);
		this.ErstelleOrtsZeile(anschriftListe, adresseArg);
		this.ErstelleLandZeile(anschriftListe, adresseArg);
		return anschriftListe;
	}

	private void ErstelleStrasseZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String strasseZeile = adresseArg.Strasse;
		
		strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Hausnummer);
		
		if (!StringUtil.IsEmpty(strasseZeile)) {
			anschriftListe.add(strasseZeile);
		}
	}

	private void ErstelleOrtsZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String ortZeile = adresseArg.PostLeitInfo;
		
		ortZeile = StringUtil.AddOptionalPart(ortZeile, StringUtil.ToUpperCase(adresseArg.Ort));
		
		if (!StringUtil.IsEmpty(ortZeile)) {
			anschriftListe.add(ortZeile);
		}
	}
	
	private void ErstelleLandZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		if (!StringUtil.IsEmpty(adresseArg.Land)) {
			anschriftListe.add(StringUtil.ToUpperCase(adresseArg.Land));
		}
	}
	
	private void ErstelleOrtsteilZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		if (!StringUtil.IsEmpty(adresseArg.Ortsteil)) {
			anschriftListe.add(adresseArg.Ortsteil);
		}
	}
	
	private void ErstellePackstation(ArrayList<String> anschriftListe, Adresse adresseArg) {
		if (!StringUtil.IsEmpty(adresseArg.PackstationNr)) {
			if (!StringUtil.IsEmpty(adresseArg.PackstationKundenNr)) {
				anschriftListe.add(adresseArg.PackstationKundenNr);
			}
			anschriftListe.add("Packstation " + adresseArg.PackstationNr);
		}
	}

}
