import java.math.BigDecimal;

import java.text.DateFormat;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import dodatniRazredi.TrrGenerator;
import ejb.IKodaNamena;
import ejb.IKomitent;
import ejb.IRacun;
import ejb.ITipKartice;
import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import ejb.KomitentEJB;
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
	private TransakcijskiRacun transakcijskiRacun = new TransakcijskiRacun();
	private List<TransakcijskiRacun> trrji = new ArrayList<TransakcijskiRacun>();
	private List<Transakcija> transakcije = new ArrayList<Transakcija>();
	private List<Racun> racuni = new ArrayList<Racun>();
	List<List<Transakcija>> listi=new ArrayList<List<Transakcija>>();
	List<String> datum=new ArrayList<String>();
	List<Double> stevilo=new ArrayList<Double>();
	private LineChartModel lineModel;
	private String potrdigeslo;
	private String novogeslo;
	private String starogeslo;
	private LineChartModel lineModel2;


	
	//GRAF
	public LineChartModel getLineModel() {
			narisiGraf();
			createLineModels(listi);
		return lineModel;  
	}
	
	public LineChartModel getLineModel2() {
		narisiGraf2();
		createLineModels2();
		return lineModel2;
	}

    private void createLineModels(List<List<Transakcija>> listi) {
         
    	lineModel = initCategoryModel(listi);
        lineModel.setTitle("Transakcije");
        lineModel.setLegendPosition("e");
        lineModel.setShowPointLabels(true);
        lineModel.getAxes().put(AxisType.X, new CategoryAxis("Datum"));
    }
    
    private void createLineModels2() {
        
    	lineModel2 = initCategoryModel2();
        lineModel2.setTitle("Število komitentov");
        lineModel2.setLegendPosition("e");
        lineModel2.setShowPointLabels(true);
        lineModel2.getAxes().put(AxisType.X, new CategoryAxis("Datum"));
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

    private LineChartModel initCategoryModel2() {
        LineChartModel model = new LineChartModel();
       
        ChartSeries kom = new ChartSeries();
	    kom.setLabel("Št. komitentov");
        	for(int i=0; i<datum.size(); i++){
        		kom.set(datum.get(i),stevilo.get(i));
        	}
	       	
	    model.addSeries(kom);   
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

	// RACUN
	public String pregledIzdanihRacunov(TransakcijskiRacun trr) {
		izbraniTrr = trr;
		return "pregledIzdanihRacunov";
	}
	
	public String pregledPrejetihRacunov(TransakcijskiRacun trr) {
		izbraniTrr = trr;
		return "pregledPrejetihRacunov";
	}
	
	public List<Racun> izdaniRacuni() {
		racuni = trr.vrniIzdaneRacuneTrrja(izbraniTrr);
		return racuni;
	}
	
	public List<Racun> prejetiRacuni() {
		racuni = trr.vrniPrejeteRacuneTrrja(izbraniTrr);
		return racuni;
	}

	public String racunPlacaj(Racun racun) {
		if (!racun.isPlacan()) {
			racun.setPlacan(true);
			racun.setDatumPlacila(Calendar.getInstance());
			//r.edit(racun);
			
			TransakcijskiRacun prejemnikRacun = trr.najdi(racun.getTRRprejmnika());
			TransakcijskiRacun posiljateljRacun = trr.najdi(racun.getIdTr());

			transakcija.setDatum(Calendar.getInstance());
			transakcija.setNaziv(racun.getNamen());
			transakcija.setTrenutnoStanje(prejemnikRacun.getStanje());
			BigDecimal novoStanje = prejemnikRacun.getStanje().subtract(racun.getZnesek());
			prejemnikRacun.setStanje(novoStanje);
			transakcija.setIdTran(prejemnikRacun);
	
			BigDecimal stanje = posiljateljRacun.getStanje();
			posiljateljRacun.setStanje(stanje.add(racun.getZnesek()));
			
			System.out.println(prejemnikRacun.getStanje());
			System.out.println(posiljateljRacun.getStanje());
			
			//trr.edit(posiljateljRacun);
			//trr.edit(prejemnikRacun);
			
			tr.shrani(transakcija);
			transakcija = new Transakcija();
			
			System.out.println("Racun placan!");
		}
		return "pregledPrejetihRacunov";
	}

	public void racunIzbris(Racun racun) {
		if (!racun.isIzbrisan()) {
			racun.setIzbrisan(true);
			r.edit(racun);
		}
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
	public void fatal(int vrstaNapake) {
		if(vrstaNapake == 0) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sprememba gesla ni možna!", "Geslo se ne ujema z geslom v bazi."));
		}
		if(vrstaNapake == 1) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sprememba gesla ni možna!", "Novo geslo in potrditveno geslo se ne ujemata."));
			}
		
	}
	public void success() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Geslo uspešno spremenjeno!", "Novo geslo je " + novogeslo));
	}
	public String spremeniGeslo(){
		String oldpass;
		String newpass;
		if(novogeslo.equals(potrdigeslo)) {
		oldpass = kodiraj(starogeslo);
		if(izbrani.getGeslo().equals(oldpass)) {
			newpass = kodiraj(novogeslo);	
			izbrani.setGeslo(newpass);
			kom.shrani(izbrani);
			success();
			novogeslo = "";
			starogeslo = "";
			potrdigeslo = "";
			return "Komitent/nastavitve";
		}
		else {
			fatal(0);
			return "Komitent/nastavitve";
		}
		}
		else {
			fatal(1);
			return "Komitent/nastavitve";
		}
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
		System.out.print(c);
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
		racuni = r.vrniVse();
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


public void narisiGraf(){
	if(izbrani!=null){
		Komitent k=kom.najdi(izbrani);
		List<TransakcijskiRacun> tran=trr.vrniTRR(k.getId());
		listi=new ArrayList<List<Transakcija>>();
		for(int i=0; i<tran.size(); i++){
			List<Transakcija> list=tr.vrniVse(tran.get(i)); 
			listi.add(list);		
		}
	}
}

public void narisiGraf2(){
	List<Komitent> komitenti=kom.vrniVse();
	datum=new ArrayList<String>();
	stevilo=new ArrayList<Double>();
	for(int i=0; i<komitenti.size(); i++){
		if(i<1){
			SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
			String preoblikovan = oblika.format(komitenti.get(i).getDatumVnosa().getTime());
			datum.add(preoblikovan);
		}
		else{
			boolean zeNot=false;
			for(int j=0; j<i; j++){
				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
				String preoblikovan = oblika.format(komitenti.get(j).getDatumVnosa().getTime());
				String preoblikovan1 = oblika.format(komitenti.get(i).getDatumVnosa().getTime());
				
				if(preoblikovan.equals(preoblikovan1)){
						zeNot=true;
				}
			}
			if(!zeNot){
				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
				String preoblikovan = oblika.format(komitenti.get(i).getDatumVnosa().getTime());
				datum.add(preoblikovan);
			}
		}
	}
	for(int i=0; i<datum.size(); i++){
		double st=0;
		for(int j=0; j<komitenti.size(); j++){
			SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
			String preoblikovan = oblika.format(komitenti.get(j).getDatumVnosa().getTime());
			if((datum.get(i)).equals(preoblikovan)){
				st++;
			}
		}
		stevilo.add(st);
	}
	System.out.println(datum);
	System.out.println(stevilo);
}

public String getPotrdigeslo() {
	return potrdigeslo;
}

public void setPotrdigeslo(String potrdigeslo) {
	this.potrdigeslo = potrdigeslo;
}

public String getNovogeslo() {
	return novogeslo;
}

public void setNovogeslo(String novogeslo) {
	this.novogeslo = novogeslo;
}

public String getStarogeslo() {
	return starogeslo;
}

public void setStarogeslo(String starogeslo) {
	this.starogeslo = starogeslo;
}
public String kodiraj(String md5) {
	   try {
	        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
	        byte[] array = md.digest(md5.getBytes());
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < array.length; ++i) {
	          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
	       }
	        return sb.toString();
	    } catch (java.security.NoSuchAlgorithmException e) {
	    }
	    return null;
	}

}
