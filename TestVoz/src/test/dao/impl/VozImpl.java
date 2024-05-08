package test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import dao.KartaDAO;
import dao.VozDAO;
import model.Karta;
import model.Voz;

public class VozImpl implements VozDAO {
	
	private final Connection conn;
	KartaDAO kartadao;

	public VozImpl(Connection conn, KartaDAO kartaDao) {
		super();
		this.kartadao= kartaDao;
		this.conn = conn;
	}



	@Override
	public Collection<Voz> getAll() throws Exception {
		Collection<Voz>vozovi = new ArrayList<Voz>();
		String sql = "SELECT id,brojVoza,nazivVoza,datumPolaska,cenaKarte,brojMesta FROM vozovi";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			try (ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					int brojVoza = rset.getInt(++kolona);
					String naziv = rset.getString(++kolona);
					LocalDateTime datumivreme= rset.getTimestamp(++kolona).toLocalDateTime();
					double cena = rset.getDouble(++kolona);
					int brojMesta = rset.getInt(++kolona);
					Voz voz = new Voz(id, brojVoza, naziv, datumivreme, cena, brojMesta);
					Collection<Karta>karte = kartadao.getAll(id);
					voz.dodajKarte(karte);
					vozovi.add(voz);
					
					
					
				}
			}
		}
		return vozovi;
	}
	




	@Override
	public Voz get(long id) throws Exception {
		Voz voz = null;
		String sql = "SELECT brojVoza,nazivVoza,datumPolaska,cenaKarte,brojMesta FROM vozovi WHERE id=?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			int parm=0;
			stmt.setLong(++parm, id);
			try (ResultSet rset = stmt.executeQuery()) {
				int kolona=0;
				if(rset.next()) {
					int brojVoza = rset.getInt(++kolona);
					String naziv = rset.getString(++kolona);
					LocalDateTime datumivreme= rset.getTimestamp(++kolona).toLocalDateTime();
					double cena = rset.getDouble(++kolona);
					int brojMesta = rset.getInt(++kolona);
					voz = new Voz(id, brojVoza, naziv, datumivreme, cena, brojMesta);
					Collection<Karta> karte = kartadao.getAll(id);
					voz.dodajKarte(karte);
					
					
					
				}
			}
		}
		return voz;
	}		
	

}
