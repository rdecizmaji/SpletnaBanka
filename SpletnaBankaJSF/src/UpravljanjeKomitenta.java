
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
import entitete.TransakcijskiRacun;

@ManagedBean(name = "upravljanjeKomitenta")
@SessionScoped
public class UpravljanjeKomitenta {
	@EJB
	IKomitent kom;
	
	private Komitent komitent=new Komitent();
	private List<Komitent> komitenti=new ArrayList<Komitent>();
	private Date datumR;
	private Komitent izbrani;
	
	public String komitentPodrobno(Komitent k){
		izbrani=k;
		return "pregledKomitenta";
	}

	public String registrirajKomitenta(){
		
		//pretvorba iz Date v Calendar
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumR);
		komitent.setDatum(cal);
		
		//klicana metoda za vnos
		kom.shrani(komitent);
		
		//ustvari nova insatnca
		komitent=new Komitent();
		datumR=null;
		
		return "listaKomitentov";
	}
	
	public String dodajTRR(){
		
		return "pregledTransakcijskihRacunov";
	}
	
	public String dodajKartico(){
		
		return "vseKartice";
	}
	
	public String urediKomitenta (){
		System.out.println("asd");
		kom.shrani(izbrani);
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

	public Komitent getIzbrani() {
		return izbrani;
	}

	public void setIzbrani(Komitent izbrani) {
		this.izbrani = izbrani;
	}
	public String izbraniK(Komitent k) {
		izbrani=k;
		return "/Banka/pregledKomitenta";
	}
	public List<TransakcijskiRacun> vrniTRR(){
		List<TransakcijskiRacun> tr=new ArrayList<TransakcijskiRacun>();
		tr=kom.vrniTRRje(izbrani);
		return tr;
	}
}
