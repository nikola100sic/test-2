package test.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import dao.KartaDAO;
import dao.VozDAO;
import model.Voz;
import test.dao.impl.KartaImpl;
import test.dao.impl.VozImpl;
import test.util.Meni;
import test.util.Meni.FunkcionalnaStavkaMenija;
import test.util.Meni.IzlaznaStavkaMenija;
import test.util.Meni.StavkaMenija;

public class Application {



	private static void initDatabase() throws Exception {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/voz?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=Europe/Belgrade", 
				"root", 
				"root");
		
		KartaDAO kartaDao = new KartaImpl(conn);
		KartaUI.setKartaDao(kartaDao);
				
		VozDAO vozDao = new VozImpl(conn, kartaDao);
		VozUI.setVozDao(vozDao);
		VozUI.setKartaDAO(kartaDao);
		KartaUI.setVozDAO(vozDao);
		IzvestavanjeUI.setVozDao(vozDao);
	
	}

	static {
		try {
			initDatabase();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Greška pri povezivanju sa izvorom podataka!");
			
			System.exit(1);
		}
	}

	public static void main(String[] args) throws Exception {		
		
		Meni.pokreni("Voz", new StavkaMenija[] {
			new IzlaznaStavkaMenija("Izlaz"),
			new FunkcionalnaStavkaMenija("Prikaz svih vozova") {

				@Override
				public void izvrsi() { VozUI.prikazSvih();}
				
			}, 
			new FunkcionalnaStavkaMenija("Prikaz jednog voza sa prodatim kartama") {

				@Override
				public void izvrsi() { VozUI.prikazJednog();; }
				
			}, 
			new FunkcionalnaStavkaMenija("Prodaja karte") {

				@Override
				public void izvrsi() { KartaUI.addTicket();; }
				
			}, 
			new FunkcionalnaStavkaMenija("Izvestaj") {

				@Override
				public void izvrsi() { IzvestavanjeUI.izvestavanje(); }
				
			}
		});
	}

}
