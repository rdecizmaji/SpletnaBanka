package nmb.transakcije.vao;

import java.io.Serializable;
import java.math.BigDecimal;

public class Postavka implements Serializable {

	private static final long serialVersionUID = 8186495818804038710L;

	private int id;
	private String naziv;
	private int kolicina;
	private String enota_mere;
	private BigDecimal cena_na_enoto;
	private BigDecimal vrednostZddv;
	
	public Postavka() {
	}
	
	public Postavka(entitete.Postavka p) {
		if (p==null) return;
		
		setId(p.getId());
		setNaziv(p.getStoritev());
		setKolicina(p.getKolicina());
		setEnota_mere(p.getEnota_mere());
		setCena_na_enoto(p.getCena_na_enoto());
		setVrednostZddv(p.getVrednostZddv());
	}
	
	public entitete.Postavka toEJBPostavka() {
		entitete.Postavka ret=new entitete.Postavka();
		
		ret.setId(id);
		ret.setStoritev(naziv);
		ret.setKolicina(kolicina);
		ret.setEnota_mere(enota_mere);
		ret.setCena_na_enoto(cena_na_enoto);
		ret.setVrednostZddv(vrednostZddv);
		
		return ret;
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
	public int getKolicina() {
		return kolicina;
	}
	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	public String getEnota_mere() {
		return enota_mere;
	}
	public void setEnota_mere(String enota_mere) {
		this.enota_mere = enota_mere;
	}
	public BigDecimal getCena_na_enoto() {
		return cena_na_enoto;
	}
	public void setCena_na_enoto(BigDecimal cena_na_enoto) {
		this.cena_na_enoto = cena_na_enoto;
	}
	public BigDecimal getVrednostZddv() {
		return vrednostZddv;
	}
	public void setVrednostZddv(BigDecimal vrednostZddv) {
		this.vrednostZddv = vrednostZddv;
	}
	
}
