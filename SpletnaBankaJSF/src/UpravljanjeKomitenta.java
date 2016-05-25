
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.IKomitent;
import ejb.ITransakcijskiRacun;
import ejb.KomitentEJB;

import entitete.Komitent;

@ManagedBean(name = "upravljanjeKomitenta")
@SessionScoped
public class UpravljanjeKomitenta {
	@EJB
	IKomitent kom;
	
	private Komitent komitent=new Komitent();
	private List<Komitent> komitenti=new ArrayList<Komitent>();
	private Date datumR;

	public void registrirajKomitenta(){
		
		//pretvorba iz Date v Calendar
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumR);
		komitent.setDatum(cal);
		
		//klicana metoda za vnos
		kom.shrani(komitent);
		
		//ustvari nova insatnca
		komitent=new Komitent();
		datumR=null;
	}
	
	public String dodajTRR(){
		
		return "pregledTransakcijskihRacunov";
	}
	
	public String urediKomitenta (){
		return "banka";
	}


	public Komitent getKomitent() {
		return komitent;
	}

	public void setKomitent(Komitent komitent) {
		this.komitent = komitent;
	}

	public Date getDatumR() {
		return datumR;
	}

	public void setDatumR(Date datumR) {
		this.datumR = datumR;
	}
	public List<Komitent> getKomitenti() {
		komitenti=kom.vrniVse();
		return komitenti;
	}
	public String pretvori(Calendar c){
		SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
		String preoblikovan = oblika.format(c.getTime());
		return preoblikovan;
	}
	
	
}
