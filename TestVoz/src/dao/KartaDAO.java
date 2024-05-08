package dao;

import java.sql.SQLException;
import java.util.Collection;

import model.Karta;
import model.Voz;

public interface KartaDAO {


	public Collection<Karta> getAll(long idVoza) throws Exception;

	public void addKarta(Karta karta) throws Exception;

}
