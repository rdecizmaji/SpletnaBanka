package entitete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private Calendar datumOdprtja;
	private Calendar datumZaprtja;
	private boolean zaprt;
	private BigDecimal stanje;
	private Komitent komitent;
	private Set<Racun> racuni = new HashSet<Racun>();
	//private List<ERacun> eracuni = new ArrayList<ERacun>();
	private Set<Transakcija> transakcije = new HashSet<Transakcija>();
	private Set<BancnaKartica> bancneKartice = new HashSet<BancnaKartica>();

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

	public Calendar getDatumOdprtja() {
		return datumOdprtja;
	}

	public void setDatumOdprtja(Calendar datumOdprtja) {
		this.datumOdprtja = datumOdprtja;
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
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public Set<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(Set<Racun> racuni) {
		this.racuni = racuni;
	}
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.MERGE)
	public Set<Transakcija> getTransakcije() {
		return transakcije;
	}

	public void setTransakcije(Set<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public Set<BancnaKartica> getBancneKartice() {
		return bancneKartice;
	}

	public void setBancneKartice(Set<BancnaKartica> bancneKartice) {
		this.bancneKartice = bancneKartice;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Komitent getKomitent() {
		return komitent;
	}

	public void setKomitent(Komitent komitent) {
		this.komitent = komitent;
	}
	/*@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public List<ERacun> getEracuni() {
		return eracuni;
	}

	public void setEracuni(List<ERacun> eracuni) {
		this.eracuni = eracuni;
	}
	*/
	
	@Override
	public String toString() {
		return getId()+":"+getStevilkaTRR()+"("+getStanje()+" eur)";
	}
}
