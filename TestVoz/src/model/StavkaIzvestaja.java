package model;

import java.time.LocalDateTime;

public class StavkaIzvestaja {
	public final String nazivVoza;
	public  final double ukupniPrihodi;
	public final LocalDateTime datumPolaska;
	
	
	public StavkaIzvestaja(String nazivVoza, double ukupniPrihodi, LocalDateTime datumPolaska) {
		this.nazivVoza = nazivVoza;
		this.ukupniPrihodi = ukupniPrihodi;
		this.datumPolaska = datumPolaska;
	}


	@Override
	public String toString() {
		return "StavkaIzvestaja>> Naziv voza:" + nazivVoza + " Ukupni prihodi: " + ukupniPrihodi + " Datum polaska voza sa najvise prodatih karata:"
				+ datumPolaska+ "\n";
	}
	 
	
	public static int compareUkupniPrihod(StavkaIzvestaja stavka1, StavkaIzvestaja stavka2) { // kriterijum sortiranja
		return -Double.compare(stavka1.ukupniPrihodi, stavka2.ukupniPrihodi); // opadajući redosled
	}
	

}
