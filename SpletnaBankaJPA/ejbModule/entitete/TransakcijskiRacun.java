package entitete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class TransakcijskiRacun implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String stevilkaTRR;
	private Calendar datumOdprja;
	private Calendar datumZaprtja;
	private boolean zaprt;
	private BigDecimal stanje;
	private Komitent komitent;
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
	
	@OneToMany
	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}
	
	@OneToMany
	public List<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
	@OneToMany
	public List<BancnaKartica> getBancneKartice() {
		return bancneKartice;
	}

	public void setBancneKartice(List<BancnaKartica> bancneKartice) {
		this.bancneKartice = bancneKartice;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Komitent getKomitent() {
		return komitent;
	}

	public void setKomitent(Komitent komitent) {
		this.komitent = komitent;
	}

}
