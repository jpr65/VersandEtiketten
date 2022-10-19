package Operationen;

import java.util.ArrayList;
import java.util.List;

import API.StringUtil;
import Daten.*;
import Operationen.IAnschriftFormatierer;

//---------------------------------------------------------------------------------
// Operation: Anschrift formatieren, Variante für ESP (Spanien)
// https://www.upu.int/en/Postal-Solutions/Programmes-Services/Addressing-Solutions
// Siehe Doku-Ordner, espEn.pdf
//---------------------------------------------------------------------------------
public class SpainAnschriftFormatierer implements IAnschriftFormatierer {

	private String laenderKennung = "ESP";

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
		
		if (!kundeArg.Abteilung.isBlank()) {
			anschriftListe.add(kundeArg.Abteilung);
		}
		
		return anschriftListe;
	}

	private ArrayList<String> AdresseErstellung(ArrayList<String> anschriftListe, Adresse adresseArg) {
		this.ErstelleStrasseZeile(anschriftListe, adresseArg);
		this.ErstelleOrtsteilZeile(anschriftListe, adresseArg);
		this.ErstelleOrtsZeile(anschriftListe, adresseArg);
		this.ErstelleProvinzZeile(anschriftListe, adresseArg);
		this.ErstelleLandZeile(anschriftListe, adresseArg);
		
		return anschriftListe;
	}

	private void ErstelleStrasseZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String strasseZeile = adresseArg.Strasse;
		
		strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Hausnummer);
		strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Flur, ", ");
		strasseZeile = StringUtil.AddOptionalPart(strasseZeile, adresseArg.Tuer, ", ");
		
		if (!StringUtil.IsEmpty(strasseZeile)) {
			anschriftListe.add(strasseZeile);
		}
	}
	
	private void ErstelleOrtsteilZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		if (!StringUtil.IsEmpty(adresseArg.Ortsteil)) {
			anschriftListe.add(adresseArg.Ortsteil);
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
		String land = StringUtil.ToUpperCase(adresseArg.Land);
		
		if (!StringUtil.IsEmpty(land)) {
			anschriftListe.add(land);
		}
	}
	
	private void ErstelleProvinzZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String provinz = StringUtil.ToUpperCase(adresseArg.Provinz);
		
		if (!StringUtil.IsEmpty(provinz)) {
			anschriftListe.add(provinz);
		}
	}
}
