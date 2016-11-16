package entitete;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KodaNamena implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String koda;
	//private List<Racun> racuni= new ArrayList<Racun>();
	//private List<ERacun> eracuni= new ArrayList<ERacun>();


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
	
	/*@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public List<Racun> getRacuni() {
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	public List<ERacun> getEracuni() {
		return eracuni;
	}

	public void setEracuni(List<ERacun> eracuni) {
		this.eracuni = eracuni;
	}*/
	

}
