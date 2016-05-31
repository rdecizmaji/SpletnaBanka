package entitete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
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
	private int postnaSt;
	private String drzava;
	private long emso;
	private int davcnaSt;
	private String email;
	private Calendar datum;
	private Calendar datumVnosa;
	private String uporabniskoIme;
	private String geslo;
	private boolean izbrisan;
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
	
	public Calendar getDatumVnosa() {
		return datumVnosa;
	}

	public void setDatumVnosa(Calendar datumVnosa) {
		this.datumVnosa = datumVnosa;
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

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public long getEmso() {
		return emso;
	}

	public void setEmso(long emso) {
		this.emso = emso;
	}

	public int getDavcnaSt() {
		return davcnaSt;
	}

	public void setDavcnaSt(int davcnaSt) {
		this.davcnaSt = davcnaSt;
	}

	public int getIdKomitent() {
		return idKomitent;
	}

	public void setIdKomitent(int idKomitent) {
		this.idKomitent = idKomitent;
	}

	public int getPostnaSt() {
		return postnaSt;
	}

	public void setPostnaSt(int postnaSt) {
		this.postnaSt = postnaSt;
	}

	public boolean isIzbrisan() {
		return izbrisan;
	}

	public void setIzbrisan(boolean izbrisan) {
		this.izbrisan = izbrisan;
	}
	public String zdruzi(String ime, String priimek){
		
		return ime +" "+priimek;
	}
}
