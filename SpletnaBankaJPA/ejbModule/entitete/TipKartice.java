package entitete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class TipKartice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nazivTipa;
	private boolean kreditna;
	private boolean debetna;
	private Set<BancnaKartica> kartice=new HashSet<BancnaKartica>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@OneToMany
	public Set<BancnaKartica> getKartice() {
		return kartice;
	}
	public void setKartice(Set<BancnaKartica> kartice) {
		this.kartice = kartice;
	}
	@Override
	public String toString() {
		String vrsta="";
		if (kreditna==true){
			vrsta="kreditna";
		}
		if (debetna==true){
			vrsta="debetna";
		}
		
		return nazivTipa +": "+ vrsta;
	}
	
	
	
}
