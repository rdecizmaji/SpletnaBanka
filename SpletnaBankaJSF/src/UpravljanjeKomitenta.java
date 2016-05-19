
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.IKomitent;
import ejb.KomitentEJB;
import entitete.Komitent;

@ManagedBean(name = "upravljanjeKomitenta")
@SessionScoped
public class UpravljanjeKomitenta {
	
	@EJB
	IKomitent kom;
	
	private Komitent komitent=new Komitent(); 
	
	public void registrirajKomitenta(){
		System.out.println(komitent);
		kom.shrani(komitent);
		komitent=new Komitent();
	}

	public Komitent getKomitent() {
		return komitent;
	}

	public void setKomitent(Komitent komitent) {
		this.komitent = komitent;
	}
	
}
