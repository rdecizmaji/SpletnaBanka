package entitete;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Postavka implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String storitev;
	private int kolicina;
	private String enota_mere;
	private BigDecimal cena_na_enoto;
	private int popust;
	private BigDecimal znesek_popusta;
	private int ddv;
	private BigDecimal vrednostZddv;
	//private ERacun idEr;
	private long idER;
	private boolean izbrisan=false;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStoritev() {
		return storitev;
	}
	public void setStoritev(String storitev) {
		this.storitev = storitev;
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
		if(popust!=0) {
			BigDecimal b1=new BigDecimal("100");
			BigDecimal kol=new BigDecimal(kolicina);
			BigDecimal b2=new BigDecimal(popust);
			znesek_popusta=((cena_na_enoto.multiply(b2)).divide(b1)).multiply(kol);
		}
	}
	public int getPopust() {
		return popust;
	}
	public void setPopust(int popust) {
		this.popust = popust;
		if(popust!=0) {
			BigDecimal b1=new BigDecimal("100");
			BigDecimal kol=new BigDecimal(kolicina);
			BigDecimal b2=new BigDecimal(popust);
			znesek_popusta=((cena_na_enoto.multiply(b2)).divide(b1)).multiply(kol);
		}
	}
	public BigDecimal getZnesek_popusta() {
		return znesek_popusta;
	}
	public void setZnesek_popusta(BigDecimal znesek_popusta) {
		this.znesek_popusta = znesek_popusta;
	}
	public int getDdv() {
		return ddv;
	}
	public void setDdv(int ddv) {
		this.ddv = ddv;
		if(znesek_popusta!=null){
			BigDecimal b1=new BigDecimal("100");
			BigDecimal d=new BigDecimal(ddv);
			BigDecimal kol=new BigDecimal(kolicina);
			BigDecimal osnova=(cena_na_enoto.multiply(kol)).subtract(znesek_popusta);
			BigDecimal znesekDavka=(osnova.multiply(d)).divide(b1);
			vrednostZddv=osnova.add(znesekDavka);
		
		}else{
			BigDecimal b1=new BigDecimal("100");
			BigDecimal d=new BigDecimal(ddv);
			BigDecimal kol=new BigDecimal(kolicina);
			BigDecimal osnova=cena_na_enoto.multiply(kol);
			BigDecimal znesekDavka=(osnova.multiply(d)).divide(b1);
			vrednostZddv=osnova.add(znesekDavka);
			
		}	
		
	}
	public BigDecimal getVrednostZddv() {
		return vrednostZddv;
	}
	public void setVrednostZddv(BigDecimal vrednostZddv) {
		this.vrednostZddv = vrednostZddv;
		
	}
	/*@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public ERacun getIdEr() {
		return idEr;
	}
	public void setIdEr(ERacun idEr) {
		this.idEr = idEr;
	}*/
	public boolean isIzbrisan() {
		return izbrisan;
	}
	public void setIzbrisan(boolean izbrisan) {
		this.izbrisan = izbrisan;
	}
	public long getIdER() {
		return idER;
	}
	public void setIdER(long idER) {
		this.idER = idER;
	}
	
}
