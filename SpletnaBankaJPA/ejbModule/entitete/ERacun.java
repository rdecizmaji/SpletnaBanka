package entitete;

import java.io.Serializable;
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
public class ERacun implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private long stevilkaRacuna;
	private String krajIzdaje;
	private String nacinPlacila;
	private String referenca;
	private Calendar datumIzdaje;
	private Calendar datumOd;
	private Calendar datumDo;
	private Calendar datumZapadlosti;
	private long idTr;
	private long idKn;
	//private TransakcijskiRacun idTr;
	//private KodaNamena idKn;
	private String TRRprejmnika;
	//private List<Postavka> postavke;
	private boolean izbrisan=false;
	private boolean placan=false;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getStevilkaRacuna() {
		return stevilkaRacuna;
	}
	public void setStevilkaRacuna(long stevilkaRacuna) {
		this.stevilkaRacuna = stevilkaRacuna;
	}
	public String getKrajIzdaje() {
		return krajIzdaje;
	}
	public void setKrajIzdaje(String krajIzdaje) {
		this.krajIzdaje = krajIzdaje;
	}
	public String getNacinPlacila() {
		return nacinPlacila;
	}
	public void setNacinPlacila(String nacinPlacila) {
		this.nacinPlacila = nacinPlacila;
	}
	public String getReferenca() {
		return referenca;
	}
	public void setReferenca(String referenca) {
		this.referenca = referenca;
	}
	public Calendar getDatumIzdaje() {
		return datumIzdaje;
	}
	public void setDatumIzdaje(Calendar datumIzdaje) {
		this.datumIzdaje = datumIzdaje;
	}
	public Calendar getDatumOd() {
		return datumOd;
	}
	public void setDatumOd(Calendar datumOd) {
		this.datumOd = datumOd;
	}
	public Calendar getDatumDo() {
		return datumDo;
	}
	public void setDatumDo(Calendar datumDo) {
		this.datumDo = datumDo;
	}
	public Calendar getDatumZapadlosti() {
		return datumZapadlosti;
	}
	public void setDatumZapadlosti(Calendar datumZapadlosti) {
		this.datumZapadlosti = datumZapadlosti;
	}
	/*@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
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
	}*/
	public boolean isIzbrisan() {
		return izbrisan;
	}
	public void setIzbrisan(boolean izbrisan) {
		this.izbrisan = izbrisan;
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
	/*@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public List<Postavka> getPostavke() {
		return postavke;
	}
	public void setPostavke(List<Postavka> postavke) {
		this.postavke = postavke;
	}*/
	public long getIdTr() {
		return idTr;
	}
	public void setIdTr(long idTr) {
		this.idTr = idTr;
	}
	public long getIdKn() {
		return idKn;
	}
	public void setIdKn(long idKn) {
		this.idKn = idKn;
	}
	
	
}
