package entitete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TransakcijskiRacun implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String stevilkaTRR;
	private Calendar datumOdprja;
	private Calendar datumZaprtja;
	private boolean zaprt;
	private BigDecimal stanje;
	private Komitent idKom;
	private List<Racun> racuni = new ArrayList<Racun>();
	private List<Transakcija> transakcije = new ArrayList<Transakcija>();
	private List<BancnaKartica> bancneKartice = new ArrayList<BancnaKartica>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStevilkaTRR() {
		return stevilkaTRR;
	}

	public void setStevilkaTRR(String stevilkaTRR) {
		this.stevilkaTRR = stevilkaTRR;
	}

	public Calendar getDatumOdprja() {
		return datumOdprja;
	}

	public void setDatumOdprja(Calendar datumOdprja) {
		this.datumOdprja = datumOdprja;
	}

	public Calendar getDatumZaprtja() {
		return datumZaprtja;
	}

	public void setDatumZaprtja(Calendar datumZaprtja) {
		this.datumZaprtja = datumZaprtja;
	}

	public boolean isZaprt() {
		return zaprt;
	}

	public void setZaprt(boolean zaprt) {
		this.zaprt = zaprt;
	}

	public BigDecimal getStanje() {
		return stanje;
	}

	public void setStanje(BigDecimal stanje) {
		this.stanje = stanje;
	}

	public Komitent getIdKom() {
		return idKom;
	}

	public void setIdKom(Komitent idKom) {
		this.idKom = idKom;
	}

	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}

	public List<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}

	public List<BancnaKartica> getBancneKartice() {
		return bancneKartice;
	}

	public void setBancneKartice(List<BancnaKartica> bancneKartice) {
		this.bancneKartice = bancneKartice;
	}

}
