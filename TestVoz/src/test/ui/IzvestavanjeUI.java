package test.ui;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import dao.VozDAO;
import model.Karta;
import model.StavkaIzvestaja;
import model.Voz;
import test.util.Konzola;

public class IzvestavanjeUI {
	
	public static VozDAO vozDao;

	public static void setVozDao(VozDAO vozDao) {
		IzvestavanjeUI.vozDao = vozDao;
	}
	
	public static void izvestavanje() {
		LocalDateTime pocetni = Konzola.ocitajDateTime("Unesite pocetni datum");
		LocalDateTime krajnji = Konzola.ocitajDateTime("Unesite pocetni datum");
		try {
			Collection<Voz> vozovi = vozDao.getAll();
			Set<String> naziviVoza = new LinkedHashSet<String>();
			for(Voz v : vozovi) {
				naziviVoza.add(v.getNaziv());
			}
			
			List<StavkaIzvestaja> izvestaj = new ArrayList<StavkaIzvestaja>();
			for(String naziv : naziviVoza) {
				double ukupanPrihod =0;
				int maksBrojKArata = Integer.MIN_VALUE;
				LocalDateTime datumMaksBrojaProdatih = null;
				
				for(Voz voz : vozovi) {
					if((voz.getNaziv().equals(naziv))&&(voz.getDatumPolaska().isAfter(pocetni)|| (voz.getDatumPolaska()==pocetni))
							&&(voz.getDatumPolaska().isBefore(krajnji)||voz.getDatumPolaska()==krajnji)) {
						for(Karta karta : voz.getKarte()) {
							ukupanPrihod= ukupanPrihod+voz.cena();
						}
						
						int brojProdatih = voz.getKarte().size();
						if(brojProdatih>maksBrojKArata) {
							maksBrojKArata=brojProdatih;
							datumMaksBrojaProdatih= voz.getDatumPolaska();
							StavkaIzvestaja stavka = new StavkaIzvestaja(naziv, ukupanPrihod, datumMaksBrojaProdatih);
							izvestaj.add(stavka);
						
						}
					}
					
							
				}
				
			}
			izvestaj.sort(StavkaIzvestaja::compareUkupniPrihod);
			for(StavkaIzvestaja s : izvestaj) {
				System.out.println(s);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
