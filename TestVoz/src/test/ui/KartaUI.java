package test.ui;

import java.time.LocalDateTime;
import java.util.Collection;

import dao.KartaDAO;
import dao.VozDAO;
import model.Karta;
import model.Voz;
import test.util.Konzola;

public class KartaUI {
	public static KartaDAO kartaDao;
	public static VozDAO vozDAO;

	public static void setKartaDao(KartaDAO kartaDao) {
		KartaUI.kartaDao = kartaDao;
	}
	
	
	public static void setVozDAO(VozDAO vozDAO) {
		KartaUI.vozDAO = vozDAO;
	}


	public static void addTicket() {
		try {
			Voz voz = VozUI.pronalazenje();
			if(voz==null) {
				return;
			}
			
			if(voz.isPopunjen()) {
				System.out.println("Nema mesta u vozu");
				return;
			}
			if(voz.isPosao()) {
				System.out.println("Voz je vec otisao");
				return;
			}
			int razred = 0;
			do {
				razred = Konzola.ocitajInt("Unesite razred (1. ili 2.)");
			}while(!(razred==1 || razred==2));
			
			String kupac = Konzola.ocitajString("Unesite ime i prezime kupca");
			LocalDateTime datumProdaje = LocalDateTime.now();
			Karta karta = new Karta(voz.getId() ,datumProdaje, kupac, razred);
			karta.setVoz(voz);
			kartaDao.addKarta(karta);
			System.out.println("Uspesno ste kupili kartu za ovaj voz");
		} catch (Exception e) {
			System.out.println("Doslo je do greske");
			e.printStackTrace();
		}
		
		
			
			
	}
	
	

}
