package model;

import java.time.LocalDateTime;
import java.util.Objects;

import test.util.Konzola;

public class Karta {
	
	private  long id;
	private LocalDateTime datumProdaje;
	private String kupac;
	private int razred;
	
	Voz voz;

	public Karta() {
		super();
	}

	public Karta(long id, LocalDateTime datumProdaje, String kupac, int razred) {
		super();
		this.id = id;
		this.datumProdaje = datumProdaje;
		this.kupac = kupac;
		this.razred = razred;
	}

	public Karta(int id, LocalDateTime datumProdaje, String kupac, int razred, Voz voz) {
		super();
		this.id = id;
		this.datumProdaje = datumProdaje;
		this.kupac = kupac;
		this.razred = razred;
		this.voz = voz;
	}

	public Karta(LocalDateTime datumProdaje, String kupac, int razred) {
		this.datumProdaje= datumProdaje;
		this.kupac = kupac;
		this.razred= razred;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDatumProdaje() {
		return datumProdaje;
	}

	public void setDatumProdaje(LocalDateTime datumProdaje) {
		this.datumProdaje = datumProdaje;
	}

	public String getKupac() {
		return kupac;
	}

	public void setKupac(String kupac) {
		this.kupac = kupac;
	}

	public int getRazred() {
		return razred;
	}

	public void setRazred(int razred) {
		this.razred = razred;
	}

	public Voz getVoz() {
		return this.voz;
	}

	public void setVoz(Voz voz) {
		this.voz = voz;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Karta other = (Karta) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Karta: Id: " + id + " Datum prodaje=" + Konzola.formatiraj(datumProdaje) + " Kupac: " + kupac + " Razred:" + razred +"\n";
	}
	
	
	
	
	
	

}
