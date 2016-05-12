package entitete;

import java.io.Serializable;

public class TipKartice implements Serializable{
	private int id;
	private String nazivTipa;
	private boolean kreditna;
	private boolean debetna;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazivTipa() {
		return nazivTipa;
	}
	public void setNazivTipa(String nazivTipa) {
		this.nazivTipa = nazivTipa;
	}
	public boolean isKreditna() {
		return kreditna;
	}
	public void setKreditna(boolean kreditna) {
		this.kreditna = kreditna;
	}
	public boolean isDebetna() {
		return debetna;
	}
	public void setDebetna(boolean debetna) {
		this.debetna = debetna;
	}
}
