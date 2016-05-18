package entitete;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KodaNamena implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String koda;
	private List<Racun> racuni= new ArrayList<Racun>();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKoda() {
		return koda;
	}

	public void setKoda(String koda) {
		this.koda = koda;
	}
	
	@OneToMany
	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}

}
