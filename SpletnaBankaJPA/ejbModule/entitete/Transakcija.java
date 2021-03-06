package entitete;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Transakcija implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String naziv;
	private BigDecimal znesek;
	private Calendar datum;
	private int stKartice;//????
	//private String sifraRacuna;//??TRR
	private Racun racun;
	private ERacun eRacun;
	private TransakcijskiRacun idTran;
	private TransakcijskiRacun TRRprejemnika;
	private BigDecimal trenutnoStanje;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public BigDecimal getZnesek() {
		return znesek;
	}

	public void setZnesek(BigDecimal db) {
		this.znesek = db;
	}

	public Calendar getDatum() {
		return datum;
	}

	public void setDatum(Calendar datum) {
		this.datum = datum;
	}

	public int getStKartice() {
		return stKartice;
	}

	public void setStKartice(int stKartice) {
		this.stKartice = stKartice;
	}
	
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	public TransakcijskiRacun getIdTran() {
		return idTran;
	}

	public void setIdTran(TransakcijskiRacun idTran) {
		this.idTran = idTran;
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public ERacun geteRacun() {
		return eRacun;
	}

	public void seteRacun(ERacun eRacun) {
		this.eRacun = eRacun;
	}
	@ManyToOne(cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	public TransakcijskiRacun getTRRprejemnika() {
		return TRRprejemnika;
	}

	public void setTRRprejemnika(TransakcijskiRacun tRRprejemnika) {
		TRRprejemnika = tRRprejemnika;
	}

	public BigDecimal getTrenutnoStanje() {
		return trenutnoStanje;
	}

	public void setTrenutnoStanje(BigDecimal trenutnoStanje) {
		this.trenutnoStanje = trenutnoStanje;
	}
}
