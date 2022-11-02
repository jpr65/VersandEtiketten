package Daten;

import java.util.Iterator;
import java.util.List;

import API.StringUtil;

//-------------------------------------------------------------
// Datenklasse f�r Etikett, Variante 1
//
//i/ Hier wird die StringUtil Klasse aus der API verwendet.
//-------------------------------------------------------------
public class EtikettVariante1 {
	public List<String> anschriftZeilen;
	
	public int EtikettNr = 0;
	// weitere Daten
	
	// Methoden
	
	//i/ Eine solche Methode ist hier erlaubt, denn es werden
	//i/ nur eigene Daten betrachtet.
	//i/ Sie k�nnte aber auch als eine eigene Operation ausgelagert werden,
	//i/ falls die Methode komplexer wird oder aber verschiedene
	//i/ Implementierungen/Varianten m�glich sind.
	
	public int belegteZeilenAnz() {
		int zeilenBelegtCounter = 0;
		
		if (anschriftZeilen == null) {
			return 0;
		}
		
		Iterator<String> iter = anschriftZeilen.iterator();
		
		while (iter.hasNext()) {
			String anschriftZeile = iter.next();

			if (! StringUtil.IsEmpty(anschriftZeile)) {
				zeilenBelegtCounter++;
			}
		}
		
		return zeilenBelegtCounter;
	}
}
