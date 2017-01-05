package nmb.transakcije.vao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

public class Transakcija implements Serializable {
	
	private static final long serialVersionUID = 6837504660265127856L;
	
	private int id;
	private String naziv;
	private BigDecimal znesek;
	private Calendar datum;
	private String trr;
	
	public Transakcija() {
	}
	
	public Transakcija(entitete.Transakcija tr) {
		if (tr==null) return;
		setId(tr.getId());
		setNaziv(tr.getNaziv());
		setZnesek(tr.getZnesek());
		setDatum(tr.getDatum());
		setTrr(tr.getIdTran().getStevilkaTRR());
	}
	
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
	public String getTrr() {
		return trr;
	}
	public void setTrr(String trr) {
		this.trr = trr;
	}
	
}