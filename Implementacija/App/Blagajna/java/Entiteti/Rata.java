package Entiteti;

import java.util.Date;

import org.hibernate.Session;

import Dodaci.TipDuga;

public class Rata {
	
	private double vrijednost;
	private boolean jeLiUplacena;
	private Date datumZaduzenja;
	private Date datumRazduzenja;
	private Date rokUplate;		
	
	public Rata() {}
	public Rata(double vrijednost, boolean jeLiUplacena, Date datumZaduzenja,
			Date datumRazduzenja, Date rokUplate) {
		super();
		this.vrijednost = vrijednost;
		this.jeLiUplacena = jeLiUplacena;
		this.datumZaduzenja = datumZaduzenja;
		this.datumRazduzenja = datumRazduzenja;
		this.rokUplate = rokUplate;		
	}
	
	public double getVrijednost() {
		return vrijednost;
	}
	public void setVrijednost(double vrijednost) {
		this.vrijednost = vrijednost;
	}
	public boolean isJeLiUplacena() {
		return jeLiUplacena;
	}
	public void setJeLiUplacena(boolean jeLiUplacena) {
		this.jeLiUplacena = jeLiUplacena;
	}
	public Date getDatumZaduzenja() {
		return datumZaduzenja;
	}
	public void setDatumZaduzenja(Date datumZaduzenja) {
		this.datumZaduzenja = datumZaduzenja;
	}
	public Date getDatumRazduzenja() {
		return datumRazduzenja;
	}
	public void setDatumRazduzenja(Date datumRazduzenja) {
		this.datumRazduzenja = datumRazduzenja;
	}
	public Date getRokUplate() {
		return rokUplate;
	}
	public void setRokUplate(Date rokUplate) {
		this.rokUplate = rokUplate;
	}
	
	public void dodajRatu(Session session) {
		
	}
	public void urediRatu(Session session) {
		
	}
}
