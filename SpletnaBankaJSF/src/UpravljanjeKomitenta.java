import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dodatniRazredi.TrrGenerator;
import ejb.IKomitent;
import ejb.ITipKartice;
import ejb.ITransakcijskiRacun;
import entitete.BancnaKartica;
import entitete.Komitent;
import entitete.TipKartice;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

@ManagedBean(name = "upravljanjeKomitenta")
@SessionScoped
public class UpravljanjeKomitenta {
	@EJB
	IKomitent kom;
	@EJB
	ITipKartice tipkar;
	@EJB
	ITransakcijskiRacun trr;
	
	private Komitent komitent=new Komitent();
	private List<Komitent> komitenti=new ArrayList<Komitent>();
	private Date datumR;
	private Komitent izbrani;
	private TransakcijskiRacun izbraniTrr;
	private TipKartice tipkartice;
	private Komitent prejemnik=new Komitent();
	private TransakcijskiRacun transakcijskiRacun = new TransakcijskiRacun();
	private List<TransakcijskiRacun> trrji = new ArrayList<TransakcijskiRacun>();
	private List<Transakcija> transakcije = new ArrayList<Transakcija>();
	
	
	//UPRAVLJANJE KOMITENTA 
	
	public String komitentPodrobno(Komitent k){
		izbrani=k;
		return "pregledKomitenta";
	}

	public String registrirajKomitenta(){
		
		//pretvorba iz Date v Calendar
		datumR = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumR);
		komitent.setDatum(cal);
		
		//dodajanje TRR
		
		//klicana metoda za vnos
		
		kom.shrani(komitent);
		izbrani = kom.najdi(komitent);
		dodajTRR();
		//ustvari nova insatnca
		komitent = izbrani;
		komitent=new Komitent();
		datumR=null;
		
		return "listaKomitentov";
	}
	
	//TRRJI IN KARTICE
	
	public String trrPodrobno(TransakcijskiRacun trr) {
		izbraniTrr = trr;
		return "pregledTransakcij.xhtml";
	}
	
	public String dodajTRR() {
		System.out.println("Dodaj trr...");
		transakcijskiRacun = new TransakcijskiRacun();
		TrrGenerator tg = new TrrGenerator();
		transakcijskiRacun.setStevilkaTRR(tg.generirajIBAN(izbrani.getDrzava()));
		transakcijskiRacun.setDatumOdprtja(Calendar.getInstance());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 10);
		transakcijskiRacun.setDatumZaprtja(cal);
		transakcijskiRacun.setZaprt(false);
		BigDecimal bd = new BigDecimal(0);
		transakcijskiRacun.setStanje(bd);
		trr.shrani(transakcijskiRacun);
		Komitent k1 = kom.najdi(izbrani);
		transakcijskiRacun.setKomitent(k1);
		trr.edit(transakcijskiRacun);
		return "pregledTransakcijskihRacunov";
	}
	
	public String dodajKartico(){
		BancnaKartica novakartica = new BancnaKartica();
		return "vseKartice";
	}
	
	public List<TipKartice> vrniTipeKartic(){
		return tipkar.vrniVse();
	}
	
	public String urediKomitenta (){
		System.out.println("asd");
		kom.shrani(izbrani);
		return "pregledKomitenta";
	}
	
	public List<TransakcijskiRacun> vrniTRR(Komitent k){
		List<TransakcijskiRacun> tr=new ArrayList<TransakcijskiRacun>();
		tr=kom.vrniTRRje(k);
		return tr;
	}
	/*
	 * 
	 * TRANSAKCIJE
	 * 
	 */
	
	//OSTALE FUNKCIJE 
		public String pretvori(Calendar c){
			SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
			String preoblikovan = oblika.format(c.getTime());
			return preoblikovan;
		}
	
	//GETTI SETTI
	
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
	
	public TipKartice getTipkartice() {
		return tipkartice;
	}

	public void setTipkartice(TipKartice tipkartice) {
		this.tipkartice = tipkartice;
	}

	public Komitent getPrejemnik() {
		return prejemnik;
	}

	public void setPrejemnik(Komitent prejemnik) {
		this.prejemnik = prejemnik;
	}
	
	public List<TransakcijskiRacun> getTrrji() {
		trrji = kom.vrniTRRje(izbrani);
		return trrji;
	}

	public void setTrrji(List<TransakcijskiRacun> trrji) {
		this.trrji = trrji;
	}
	
	public TransakcijskiRacun getTransakcijskiRacun() {
		return transakcijskiRacun;
	}

	public void setTransakcijskiRacun(TransakcijskiRacun transakcijskiRacun) {
		this.transakcijskiRacun = transakcijskiRacun;
	}
	
	public List<Transakcija> getTransakcije() {
		transakcije = trr.vrniTransakcije(izbraniTrr);
		return transakcije;
	}

	public void setTransakcije(List<Transakcija> transakcije) {
		this.transakcije = transakcije;
	}
	
	public TransakcijskiRacun getIzbraniTrr() {
		return izbraniTrr;
	}

	public void setIzbraniTrr(TransakcijskiRacun izbraniTrr) {
		this.izbraniTrr = izbraniTrr;
	}
	
   public List<Komitent> dopolni(String query) {
        List<Komitent> vsiKomitenti = komitenti=kom.vrniVse();
        List<Komitent> izbraniKomitenti = new ArrayList<Komitent>();
         
        for (int i = 0; i < vsiKomitenti.size(); i++) {
            Komitent kom = vsiKomitenti.get(i);
            if(kom.getIme().toLowerCase().startsWith(query)) {
                izbraniKomitenti.add(kom);
            }
        }
         
        return izbraniKomitenti;
    }
   public String nastaviPrejmnika(Komitent k){
	   if(k!=null){
		    prejemnik=k;
		    return k.getIme()+" "+k.getPriimek();
	   }
	   else
		   return null;
		  
   }
   public String razveljavi(){
	   prejemnik=new Komitent();
	   return "/Banka/ustvariERacun2";
   }
}
