package test.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import dao.KartaDAO;
import model.Karta;


public class KartaImpl implements KartaDAO {
	
	private final Connection conn;

	public KartaImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public Collection<Karta> getAll(long idVoza) throws Exception {
		Collection< Karta> karte = new ArrayList<Karta>();
		String sql = "SELECT id, datumProdajeKarte, kupac, razred FROM karte WHERE idVoza=?";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			int parm=0;
			stmt.setLong(++parm, idVoza);
			try (ResultSet rset = stmt.executeQuery()) {
				while (rset.next()) {
					int kolona = 0;
					long id = rset.getLong(++kolona);
					LocalDateTime datumIVreme = rset.getTimestamp(++kolona).toLocalDateTime();
					String kupac = rset.getString(++kolona);
					int razred = rset.getInt(++kolona);
					 Karta karta = new Karta(id, datumIVreme, kupac, razred);
					 karte.add(karta);
					 
					 
				}
			}
		}
		return karte;
	}

	@Override
	public void addKarta(Karta karta) throws Exception {
		String sql = "INSERT INTO karte (idVoza,datumProdajeKarte, kupac, razred) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			int parm =0;
			stmt.setLong(++parm, karta.getId());
			stmt.setTimestamp(++parm, Timestamp.valueOf(karta.getDatumProdaje()));
			stmt.setString(++parm, karta.getKupac());
			stmt.setInt(++parm, karta.getRazred());
			stmt.executeUpdate();
		}
	}


	

}
