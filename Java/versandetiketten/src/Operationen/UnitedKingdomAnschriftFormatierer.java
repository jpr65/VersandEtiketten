package Operationen;

import java.util.ArrayList;
import java.util.List;

import API.StringUtil;
import Daten.*;
import Operationen.IAnschriftFormatierer;

//---------------------------------------------------------------------------------
// Operation: Anschrift formatieren, Variante für GBR (UnitedKingdom)
// https://www.upu.int/en/Postal-Solutions/Programmes-Services/Addressing-Solutions
// Siehe Doku-Ordner, gbrEn.pdf
//---------------------------------------------------------------------------------
public class UnitedKingdomAnschriftFormatierer implements IAnschriftFormatierer {

	private String laenderKennung = "GBR";

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
		this.ErstellePostcodeZeile(anschriftListe, adresseArg);
		this.ErstelleLandZeile(anschriftListe, adresseArg);
		return anschriftListe;
	}

	private void ErstelleStrasseZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String strasseZeile = adresseArg.Hausnummer;
		
		if (!StringUtil.IsEmpty(adresseArg.Hausnummer)) {
			if (!StringUtil.IsEmpty(strasseZeile)) {
				strasseZeile += " ";
			}
			
			strasseZeile += adresseArg.Strasse;
		}
		
		if (!StringUtil.IsEmpty(strasseZeile)) {
			anschriftListe.add(strasseZeile);
		}
	}

	private void ErstellePostcodeZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		if (!StringUtil.IsEmpty(adresseArg.PostLeitInfo)) {
			anschriftListe.add(adresseArg.PostLeitInfo);
		}
	}
	
	private void ErstelleOrtsZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String ortZeile = StringUtil.ToUpperCase(adresseArg.Ort);
		
		if (!StringUtil.IsEmpty(ortZeile)) {
			anschriftListe.add(ortZeile);
		}
	}
	
	private void ErstelleLandZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		String land = StringUtil.ToUpperCase(adresseArg.Land);
		
		if (!StringUtil.IsEmpty(land)) {
			anschriftListe.add(StringUtil.ToUpperCase(adresseArg.Land));
		}
	}
	
	private void ErstelleOrtsteilZeile(ArrayList<String> anschriftListe, Adresse adresseArg) {
		if (!StringUtil.IsEmpty(adresseArg.Ortsteil)) {
			anschriftListe.add(adresseArg.Ortsteil);
		}
	}
}
