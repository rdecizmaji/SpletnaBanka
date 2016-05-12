package entitete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Komitent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idKomitent;
	private String ime;
	private String priimek;
	private String naslov;
	private String posta;
	private String email;
	private Calendar datum;
	private String uporabniskoIme;
	private String geslo;
	private List<TransakcijskiRacun> transakcijskiRacuni = new ArrayList<TransakcijskiRacun>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@OneToMany
	public List<TransakcijskiRacun> getTransakcijskiRacuni() {
		return transakcijskiRacuni;
	}

	public void setTransakcijskiRacuni(List<TransakcijskiRacun> transakcijskiRacuni) {
		this.transakcijskiRacuni = transakcijskiRacuni;
	}

}
