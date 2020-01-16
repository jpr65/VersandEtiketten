package VersandEtiketten;

import java.util.Iterator;

import Daten.EtikettVariante1;
import Integratoren.VersandEtikettenErstellen;

class JavaMain {
	public static void main(String[] args) {
		VersandEtikettenErstellen versandEtikettenErsteller = new VersandEtikettenErstellen();
		
		EtikettVariante1 etikett = versandEtikettenErsteller.VersandEtikettVariante1("KUD0001", "ADR0002", "GER", null);
		
		Iterator<String> iter = etikett.anschriftZeilen.iterator();
		
		while (iter.hasNext()) {
			String anschriftZeile = iter.next();
			System.out.println(anschriftZeile);
		}
	}
}