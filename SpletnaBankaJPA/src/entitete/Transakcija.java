package entitete;

import java.math.BigDecimal;
import java.util.Calendar;

public class Transakcija {
	private int id;
	private String naziv;
	private BigDecimal znesek;
	private Calendar datum;
	private int stKartice;
	private String sifraRacuna;
	private TransakcijskiRacun idTran;
	
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
	public void setZnesek(BigDecimal znesek) {
		this.znesek = znesek;
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
	public String getSifraRacuna() {
		return sifraRacuna;
	}
	public void setSifraRacuna(String sifraRacuna) {
		this.sifraRacuna = sifraRacuna;
	}
	public TransakcijskiRacun getIdTran() {
		return idTran;
	}
	public void setIdTran(TransakcijskiRacun idTran) {
		this.idTran = idTran;
	}
}
