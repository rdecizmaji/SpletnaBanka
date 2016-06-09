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
public class Racun implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String sifraRacuna;
	private String namen;
	private Calendar datumIzdaje;
	private Calendar datumPlacila;
	private boolean placan;
	private String TRRprejmnika;
	private BigDecimal znesek;
	private boolean izbrisan;
	private TransakcijskiRacun idTr;
	private KodaNamena idKn;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSifraRacuna() {
		return sifraRacuna;
	}

	public void setSifraRacuna(String sifraRacuna) {
		this.sifraRacuna = sifraRacuna;
	}

	public String getNamen() {
		return namen;
	}

	public void setNamen(String namen) {
		this.namen = namen;
	}

	public Calendar getDatumIzdaje() {
		return datumIzdaje;
	}

	public void setDatumIzdaje(Calendar datumIzdaje) {
		this.datumIzdaje = datumIzdaje;
	}

	public Calendar getDatumPlacila() {
		return datumPlacila;
	}

	public void setDatumPlacila(Calendar datumPlacila) {
		this.datumPlacila = datumPlacila;
	}

	public boolean isPlacan() {
		return placan;
	}

	public void setPlacan(boolean placan) {
		this.placan = placan;
	}

	public String getTRRprejmnika() {
		return TRRprejmnika;
	}

	public void setTRRprejmnika(String tRRprejmnika) {
		TRRprejmnika = tRRprejmnika;
	}

	public BigDecimal getZnesek() {
		return znesek;
	}

	public void setZnesek(BigDecimal znesek) {
		this.znesek = znesek;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public TransakcijskiRacun getIdTr() {
		return idTr;
	}

	public void setIdTr(TransakcijskiRacun idTr) {
		this.idTr = idTr;
	}
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public KodaNamena getIdKn() {
		return idKn;
	}

	public void setIdKn(KodaNamena idKn) {
		this.idKn = idKn;
	}

	public boolean isIzbrisan() {
		return izbrisan;
	}

	public void setIzbrisan(boolean izbrisan) {
		this.izbrisan = izbrisan;
	}
}
