package entitete;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TransakcijskiRacun {
	private int id;
	private String stevilkaTRR;
	private Calendar datumOdprja;
	private Calendar datumZaprtja;
	private boolean zaprt;
	private BigDecimal stanje;
	
	private Komitent idKom;

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

}
