package nmb.transakcije.vao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class TransakcijskiRacun implements Serializable {

	private static final long serialVersionUID = -5701299310029785889L;
	
	private String stevilkaTRR;
	private Calendar datumOdprtja;
	private BigDecimal stanje;
	private int komitent;
	private Set<Transakcija> transakcije = new HashSet<Transakcija>();
	
	public TransakcijskiRacun(){
		
	}
	
	public TransakcijskiRacun(entitete.TransakcijskiRacun t){
		if (t==null) return;
		setStevilkaTRR(t.getStevilkaTRR());
		setDatumOdprtja(t.getDatumOdprtja());
		setStanje(t.getStanje());
		setKomitent(t.getKomitent().getId());
		for (entitete.Transakcija tran:t.getTransakcije()) {
			transakcije.add(new Transakcija(tran));
		}
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
	public BigDecimal getStanje() {
		return stanje;
	}
	public void setStanje(BigDecimal stanje) {
		this.stanje = stanje;
	}
	public int getKomitent() {
		return komitent;
	}
	public void setKomitent(int komitent) {
		this.komitent = komitent;
	}
	public Set<Transakcija> getTransakcije() {
		return transakcije;
	}
	public void setTransakcije(Set<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
}
