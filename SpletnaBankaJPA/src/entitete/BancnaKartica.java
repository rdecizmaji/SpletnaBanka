package entitete;

import java.io.Serializable;
import java.util.Calendar;

public class BancnaKartica implements Serializable{
	private int id;
	private int stKartice;
	private int pinKoda;
	private Calendar datumVeljavnosti;
	private boolean veljavana;
	private Calendar datumObracuna;
	private TransakcijskiRacun idTr;
	private TipKartice idTk;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStKartice() {
		return stKartice;
	}
	public void setStKartice(int stKartice) {
		this.stKartice = stKartice;
	}
	public int getPinKoda() {
		return pinKoda;
	}
	public void setPinKoda(int pinKoda) {
		this.pinKoda = pinKoda;
	}
	public Calendar getDatumVeljavnosti() {
		return datumVeljavnosti;
	}
	public void setDatumVeljavnosti(Calendar datumVeljavnosti) {
		this.datumVeljavnosti = datumVeljavnosti;
	}
	public boolean isVeljavana() {
		return veljavana;
	}
	public void setVeljavana(boolean veljavana) {
		this.veljavana = veljavana;
	}
	public Calendar getDatumObracuna() {
		return datumObracuna;
	}
	public void setDatumObracuna(Calendar datumObracuna) {
		this.datumObracuna = datumObracuna;
	}
	public TransakcijskiRacun getIdTr() {
		return idTr;
	}
	public void setIdTr(TransakcijskiRacun idTr) {
		this.idTr = idTr;
	}
	public TipKartice getIdTk() {
		return idTk;
	}
	public void setIdTk(TipKartice idTk) {
		this.idTk = idTk;
	}
}
