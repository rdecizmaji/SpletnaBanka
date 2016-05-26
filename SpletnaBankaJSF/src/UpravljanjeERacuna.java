import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.IKodaNamena;
import entitete.KodaNamena;

@ManagedBean(name = "upravljanjeERacuna")
@SessionScoped
public class UpravljanjeERacuna {

	@EJB
	IKodaNamena koda;
	
	List<KodaNamena> kn=new ArrayList<KodaNamena>();

	public List<KodaNamena> getKn() {
		kn=koda.vrniVse();
		return kn;
	}

	public void setKn(List<KodaNamena> kn) {
		this.kn = kn;
	}
	
	
}
 