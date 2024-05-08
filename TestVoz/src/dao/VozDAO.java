package dao;

import java.util.Collection;

import model.Voz;


public interface VozDAO {

	public Collection<Voz> getAll() throws Exception;
	public Voz get(long id) throws Exception;
	
 

	

}
