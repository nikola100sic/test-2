package test.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import dao.KartaDAO;
import dao.VozDAO;
import model.Karta;
import model.Voz;
import test.util.Konzola;
import test.util.Tabela;

public class VozUI {
	
	private static VozDAO vozDao;
	private static KartaDAO kartaDAO;

	public static void setVozDao(VozDAO vozDao) {
		VozUI.vozDao = vozDao;
	}
	

	public static void setKartaDAO(KartaDAO kartaDAO) {
		VozUI.kartaDAO = kartaDAO;
	}

	
	public static Voz pronalazenje() throws Exception {
		long id = Konzola.ocitajLong("Unesite Id");
		Voz voz = vozDao.get(id);
		if(voz==null) {
			System.out.println("Nema voza sa tim id-em");
		}
		return voz;
	}
	
	public static void prikazSvih() {
		try {
			Collection<Voz> vozovi = vozDao.getAll();
			for(Voz voz : vozovi) {
//				Collection<Karta> karte = kartaDAO.getAll(voz.getId());
//				voz.dodajKarte(karte);
				System.out.println(voz);
				
				
			}
			
		} catch (Exception e) {
			System.out.println("Doslo je do greske");
			e.printStackTrace();
		}
	}
	
	public static void prikazJednog() {
		try {
			Voz voz = pronalazenje();
			if(voz==null) {
				return;
				
			}
			System.out.println(voz);
			System.out.println();
			for(Karta k:voz.getKarte()) {
			System.out.print(k);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
