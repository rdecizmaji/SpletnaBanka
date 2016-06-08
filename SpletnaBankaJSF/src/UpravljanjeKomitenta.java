import java.math.BigDecimal;

import java.text.DateFormat;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import dodatniRazredi.Graf;
import dodatniRazredi.TrrGenerator;
import ejb.IKodaNamena;
import ejb.IKomitent;
import ejb.IRacun;
import ejb.ITipKartice;
import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.BancnaKartica;
import entitete.KodaNamena;
import entitete.Komitent;
import entitete.Racun;
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
	@EJB
	IKodaNamena kn;
	@EJB
	IRacun r;
	@EJB
	ITransakcija tr;

	private Komitent komitent = new Komitent();
	private List<Komitent> komitenti = new ArrayList<Komitent>();
	private Date datumR;
	private String datumU;
	private Komitent izbrani;
	public static Komitent glavni;
	private TransakcijskiRacun izbraniTrr;
	private TipKartice tipkartice;
	private Komitent prejemnik = new Komitent();
	private Transakcija transakcija = new Transakcija();
	private TransakcijskiRacun transakcijskiRacun = new TransakcijskiRacun();
	private List<TransakcijskiRacun> trrji = new ArrayList<TransakcijskiRacun>();
	private List<Transakcija> transakcije = new ArrayList<Transakcija>();
	private List<Racun> racuni = new ArrayList<Racun>();
	private String currentTime;
	List<List<Transakcija>> listi=new ArrayList<List<Transakcija>>();
	private LineChartModel lineModel;

	public LineChartModel getLineModel() {
		narisiGraf();
		createLineModels(listi);
		return lineModel;
	}

    private void createLineModels(List<List<Transakcija>> listi) {
         
    	lineModel = initCategoryModel(listi);
        lineModel.setTitle("Transakcije");
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Datum"));
    }
     
    private LineChartModel initCategoryModel(List<List<Transakcija>> listi) {
        LineChartModel model = new LineChartModel();
        
        
        for(int i=0; i<listi.size(); i++){
			List<Transakcija> list=listi.get(i);
			ChartSeries znes = new ChartSeries();
	        znes.setLabel("TRR "+i);
	        	for(int j=0; j<list.size(); j++){
	        		BigDecimal bd= list.get(j).getZnesek(); // the value you get
	        		double d = bd.doubleValue();
	        		
	        		SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
	    			String preoblikovan = oblika.format(list.get(j).getDatum().getTime());
	        		
	        		znes.set(preoblikovan,d);
	        	}
	        	
	        model.addSeries(znes);  
		}
         
        return model;
    }

	//UPRAVLJANJE KOMITENTA 
	
	public String komitentPodrobno(Komitent k){
		izbrani=k;
		return "pregledKomitenta";
	}

	public String getDatumU() {
		SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
		datumU = oblika.format(izbrani.getDatum().getTime());
		return datumU;
	}

	public void setDatumU(String datumU) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		try {
			cal.setTime(sdf.parse(datumU));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		izbrani.setDatum(cal);
	}

	public String registrirajKomitenta(){
		
		//pretvorba iz Date v Calendar

		Calendar cal = Calendar.getInstance();
		cal.setTime(datumR);
		komitent.setDatum(cal);
		// Komitenta dodamo kot userja
		komitent.setVloga("user");
		// klicana metoda za vnos
		kom.shrani(komitent);
		izbrani = kom.najdi(komitent);
		// ustvari nova insatnca
		komitent = izbrani;
		komitent = new Komitent();
		datumR = null;

		return "listaKomitentov";
	}

	// TRRJI IN KARTICE

	// racun
	public String pregledRacunov(TransakcijskiRacun trr){
		izbraniTrr = trr;
		return "pregledNavadnihRacunov";
	}
	
	public String placajRacun(Racun racun) {
		if(!racun.isPlacan()) {
			racun.setPlacan(true);
			racun.setDatumPlacila(Calendar.getInstance());
			r.edit(racun);
			/*
			TransakcijskiRacun transakcijskiRacun = trr.najdi(izbraniTrr.getId());
			transakcija.setDatum(Calendar.getInstance());
			transakcija.setNaziv(racun.getNamen());
			transakcija.setTrenutnoStanje(transakcijskiRacun.getStanje().add(transakcija.getZnesek()));
			BigDecimal novoStanje = transakcijskiRacun.getStanje().add(transakcija.getZnesek());
			transakcijskiRacun.setStanje(novoStanje);
			transakcija.setIdTran(transakcijskiRacun);
	
			tr.shrani(transakcija);
			transakcija = new Transakcija();
			*/
			System.out.println("Racun placan!");
		}
		return "pregledKomitenta";
	}

	public void racunIzbris(Racun racun) {
		r.izbrisi(racun);
		System.out.println("Racun izbrisan.");
	}

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

	public String dodajKartico() {
		BancnaKartica novakartica = new BancnaKartica();
		return "vseKartice";
	}

	public List<TipKartice> vrniTipeKartic() {
		return tipkar.vrniVse();
	}

	
	public String urediKomitenta (){
		

		kom.shrani(izbrani);
		return "pregledKomitenta";
	}

	public List<TransakcijskiRacun> vrniTRR(Komitent k) {
		List<TransakcijskiRacun> tr = new ArrayList<TransakcijskiRacun>();
		tr = kom.vrniTRRje(k);
		return tr;
	}
	/*
	 * 
	 * TRANSAKCIJE
	 * 
	 */


	
	//OSTALE FUNKCIJE 
	public String pretvori(Calendar c){
		if(c!=null){
			SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
			String preoblikovan = oblika.format(c.getTime());
			return preoblikovan;
		} else {
			return null;
		}
	}

	// GETTI SETTI

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
		komitenti = kom.vrniVse();
		return komitenti;
	}

	public Komitent getIzbrani() {
		return izbrani;
	}

	public void setIzbrani(Komitent izbrani) {
		this.izbrani = izbrani;
	}

	public String izbrani(Komitent k) {
		izbrani = k;
		if (glavni != null)
			return "/Banka/pregledKomitenta";
		else
			return "/Komitent/pregledKomitenta";
	}

	public String izbraniKomitent(Komitent k) {
		izbrani = k;
		glavni = null;
		return k.getIme() + " " + k.getPriimek();
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
	
	public List<Racun> getRacuni() {
		racuni = trr.vrniRacuneTrrja(izbraniTrr);
		return racuni;
	}

	public void setRacuni(List<Racun> racuni) {
		this.racuni = racuni;
	}

	public List<Komitent> dopolni(String query) {
		List<Komitent> vsiKomitenti = komitenti = kom.vrniVse();
		List<Komitent> izbraniKomitenti = new ArrayList<Komitent>();

		for (int i = 0; i < vsiKomitenti.size(); i++) {
			Komitent kom = vsiKomitenti.get(i);
			if (kom.getIme().toLowerCase().startsWith(query)) {
				izbraniKomitenti.add(kom);
			}
		}

		return izbraniKomitenti;
	}

	public String nastaviPrejmnika(Komitent k) {
		if (k != null) {
			prejemnik = k;
			return k.getIme() + " " + k.getPriimek();
		} else
			return null;

	}

	public String razveljavi() {
		prejemnik = new Komitent();
		if (glavni != null)
			return "/Banka/ustvariPostavke.xhtml";
		else
			return "/Komitent/ustvariPostavke.xhtml";
	}

	public String nazaj() {
		if (glavni != null) {
			return "/Banka/ustvariERacun.xhtml";
		} else
			return "/Komitent/ustvariERacun.xhtml";
	}

	public String razveljavi1() {
		prejemnik = new Komitent();
		return "/Banka/ustvariPostavke.xhtml";
	}

	public String vnesi(Komitent koma) {
		String[] kode = { "OTHR", "ADMG", "ADVA", "AGRT", "ALMY", "ANNI", "BECH", "BENE", "BEXP", "BONU", "CBFF",
				"CBTV", "CCRD", "CCHD", "CDCD", "CFEE", "CHAR", "CMDT", "COMM", "COST", "CSDB", "DBTC", "DEPT", "DIVD",
				"ECPG", "ELEC", "ESTX", "GASB", "GOVI", "HLRP", "HLTI", "HREC", "ICRF", "INSM", "INSU", "INTE", "LBRI",
				"LIFI", "LOAN", "NWCH", "PENS", "PHON", "RENT", "SALA", "SCVE", "SECU", "SUBS", "TAXS", "VATX" };
		for (int i = 0; i < kode.length; i++) {
			KodaNamena k = new KodaNamena();
			k.setKoda(kode[i]);
			kn.vnesi(k);
		}
		if (glavni != null) {
			return "/Banka/ustvariERacun";
		} else {
			return "/Komitent/ustvariERacun";
		}
	}

	public static Komitent getGlavni() {
		return glavni;
	}

public String setGlavni(Komitent glavni) {
	this.glavni = glavni;
	return glavni.getIme()+" "+glavni.getPriimek();
}
public String getCurrentTime() {
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
}

public String setCurrentTime(String currentTime) {
	return this.currentTime = currentTime;
}


public void narisiGraf(){
	Komitent k=kom.najdi(izbrani);
	List<TransakcijskiRacun> tran=trr.vrniTRR(k.getId());
	listi=new ArrayList<List<Transakcija>>();
	for(int i=0; i<tran.size(); i++){
		List<Transakcija> list=tr.vrniVse(tran.get(i)); 
		listi.add(list);		
	}
}

}
