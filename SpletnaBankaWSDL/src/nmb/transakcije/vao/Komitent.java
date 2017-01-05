package nmb.transakcije.vao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entitete.TransakcijskiRacun;

public class Komitent implements Serializable {

	private static final long serialVersionUID = -4811814986031737809L;
	
	private int id;
	private String ime;
	private String priimek;
	private String naslov;
	private String posta;
	private String postnaSt;
	private String drzava;
	private String emso;
	private String davcnaSt;
	private String email;
	private String uporabniskoIme;
	private String geslo;
	private List<String> transakcijskiRacuni = new ArrayList<String>();
	
	public Komitent() {
	}
	
	public Komitent(entitete.Komitent ejbKomitent) {
		if (ejbKomitent==null) return;
		setId(ejbKomitent.getId());
		setIme(ejbKomitent.getIme());
		setPriimek(ejbKomitent.getPriimek());
		setNaslov(ejbKomitent.getNaslov());
		setPosta(ejbKomitent.getPosta());
		setPostnaSt(ejbKomitent.getPostnaSt());
		setDrzava(ejbKomitent.getDrzava());
		setEmso(ejbKomitent.getEmso());
		setDavcnaSt(ejbKomitent.getDavcnaSt());
		setEmail(ejbKomitent.getEmail());
		setUporabniskoIme(ejbKomitent.getUporabniskoIme());
		setGeslo(ejbKomitent.getGeslo());
		for (TransakcijskiRacun tr : ejbKomitent.getTransakcijskiRacuni())
			transakcijskiRacuni.add(tr.getStevilkaTRR());
	}
	
	public entitete.Komitent toEjbKomitent() {
		entitete.Komitent ret=new entitete.Komitent();
		ret.setId(getId());
		ret.setIme(getIme());
		ret.setPriimek(getPriimek());
		ret.setNaslov(getNaslov());
		ret.setPosta(getPosta());
		ret.setPostnaSt(getPostnaSt());
		ret.setDrzava(getDrzava());
		ret.setEmso(getEmso());
		ret.setDavcnaSt(getDavcnaSt());
		ret.setEmail(getEmail());
		ret.setUporabniskoIme(getUporabniskoIme());
		ret.setGeslo(getGeslo());
		//TODO trr
		return ret;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getPostnaSt() {
		return postnaSt;
	}
	public void setPostnaSt(String postnaSt) {
		this.postnaSt = postnaSt;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public String getEmso() {
		return emso;
	}
	public void setEmso(String emso) {
		this.emso = emso;
	}
	public String getDavcnaSt() {
		return davcnaSt;
	}
	public void setDavcnaSt(String davcnaSt) {
		this.davcnaSt = davcnaSt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public List<String> getTransakcijskiRacuni() {
		return transakcijskiRacuni;
	}
	public void setTransakcijskiRacuni(List<String> transakcijskiRacuni) {
		this.transakcijskiRacuni = transakcijskiRacuni;
	}

}