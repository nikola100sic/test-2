package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class Voz {
	private long id;
	
	private int brojVoza;
	private String naziv;
	private LocalDateTime datumPolaska;
	private double cenaKarte;
	private int brojMesta;
	
	
	Collection<Karta> karte = new ArrayList<Karta>();

	public Voz(long id, int brojVoza, String naziv, LocalDateTime datumPolaska, double cenaKarte, int brojMesta) {
		super();
		this.id = id;
		this.brojVoza = brojVoza;
		this.naziv = naziv;
		this.datumPolaska = datumPolaska;
		this.cenaKarte = cenaKarte;
		this.brojMesta = brojMesta;
	}


	public Voz(long id, int brojVoza, String naziv, LocalDateTime datumPolaska, double cenaKarte, int brojMesta,
			Collection<Karta> karte) {
		super();
		this.id = id;
		this.brojVoza = brojVoza;
		this.naziv = naziv;
		this.datumPolaska = datumPolaska;
		this.cenaKarte = cenaKarte;
		this.brojMesta = brojMesta;
		this.karte = karte;
	}

	public long getId() {
		return id;
	}


	public int getBrojVoza() {
		return brojVoza;
	}

	public void setBrojVoza(int brojVoza) {
		this.brojVoza = brojVoza;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public LocalDateTime getDatumPolaska() {
		return datumPolaska;
	}

	public void setDatumPolaska(LocalDateTime datumPolaska) {
		this.datumPolaska = datumPolaska;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public Collection<Karta> getKarte() {
		return Collections.unmodifiableCollection(karte);
	}
	

	public void dodajKartu (Karta karta) {
		this.karte.add(karta);
	}

	public void dodajKarte (Collection<Karta> karte) {
		this.karte.addAll(karte);
	
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
		Voz other = (Voz) obj;
		return id == other.id;
	}
	
	public int brojslobodnihMesta () {
		return  brojMesta-karte.size();
	
	}
	
	public boolean isPopunjen() {
		return karte.size()>=brojMesta;
	}
	
	public boolean isPosao() {
		return datumPolaska.isBefore(LocalDateTime.now());
	}
	

	@Override
	public String toString() {
		return "Voz: Id voza: " + id + " Broj voza: " + brojVoza + " Naziv: " + naziv + " Datum polaska: " + datumPolaska
				+ " Cena karte: " + cenaKarte + " Broj mesta: " + brojMesta  + (this.karte.size()==0 ? "" :" Broj slobodnih mesta: "+ brojslobodnihMesta());
	}
	
	
		

	public double cena() {
		for(Karta k: karte) {
		if(k.getRazred()==2) {
			return cenaKarte*0.85;
		}else if(k.getRazred() ==1) {
			return cenaKarte;
		}
		}
		return Double.MAX_VALUE;
		
	}
	
	
}
