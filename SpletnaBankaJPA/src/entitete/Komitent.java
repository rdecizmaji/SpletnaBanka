package entitete;

import java.io.Serializable;
import java.util.Calendar;

public class Komitent implements Serializable{
	private int idKomitent;
	private String ime;
	private String priimek;
	private String naslov;
	private String posta;
	private String email;
	private Calendar datum;
	private String uporabniskoIme;
	private String geslo;
	public int getId() {
		return idKomitent;
	}
	public void setId(int id) {
		this.idKomitent = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPriimek() {
		return priimek;
	}
	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}
	public String getNaslov() {
		return naslov;
	}
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	public String getPosta() {
		return posta;
	}
	public void setPosta(String posta) {
		this.posta = posta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getDatum() {
		return datum;
	}
	public void setDatum(Calendar datum) {
		this.datum = datum;
	}
	public String getUporabniskoIme() {
		return uporabniskoIme;
	}
	public void setUporabniskoIme(String uporabniskoIme) {
		this.uporabniskoIme = uporabniskoIme;
	}
	public String getGeslo() {
		return geslo;
	}
	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}
	
	
}
