import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import dodatniRazredi.TrrGenerator;
import ejb.IERacun;
import ejb.IKodaNamena;
import ejb.IKomitent;
import ejb.IPostavka;
import ejb.IRacun;
import ejb.ITipKartice;
import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.ERacun;
import entitete.KodaNamena;
import entitete.Komitent;
import entitete.Postavka;
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
	IERacun rac;
	@EJB
	ITransakcija tr;
	@EJB
	IPostavka p;

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
	private Transakcija transakcijaPrejemnika = new Transakcija();
	private TransakcijskiRacun transakcijskiRacun = new TransakcijskiRacun();
	private List<TransakcijskiRacun> trrji = new ArrayList<TransakcijskiRacun>();
	private List<Transakcija> transakcije = new ArrayList<Transakcija>();
	private List<Racun> racuni = new ArrayList<Racun>();
	List<List<Transakcija>> listi=new ArrayList<List<Transakcija>>();
	List<List<String>> vsiDatumi=new ArrayList<List<String>>();
	List<List<Double>> vseTransakcije=new ArrayList<List<Double>>();
	List<String> datum=new ArrayList<String>();
	List<Double> stevilo=new ArrayList<Double>();
	private LineChartModel lineModel;
	private String potrdigeslo;
	private String novogeslo;
	private String starogeslo;
	private LineChartModel lineModel2;
	
	//GRAF

	// GRAF
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

		for (int i = 0; i < listi.size(); i++) {
			List<Transakcija> list = listi.get(i);
			ChartSeries znes = new ChartSeries();
			znes.setLabel("TRR " + i);
			for (int j = 0; j < list.size(); j++) {
				BigDecimal bd = list.get(j).getZnesek(); // the value you get
				double d = bd.doubleValue();

				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
				String preoblikovan = oblika.format(list.get(j).getDatum().getTime());

				znes.set(preoblikovan, d);
			}

			model.addSeries(znes);
		}

		return model;
	}

	private LineChartModel initCategoryModel2() {
		LineChartModel model = new LineChartModel();

		ChartSeries kom = new ChartSeries();
		kom.setLabel("Št. komitentov");
		for (int i = 0; i < datum.size(); i++) {
			kom.set(datum.get(i), stevilo.get(i));
		}

		model.addSeries(kom);
		return model;
	}
	// UPRAVLJANJE KOMITENTA

	public String komitentPodrobno(Komitent k) {
		izbrani = k;
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
		boolean vnesi=true;
		List<String>emaili=kom.vrniEmaile();
		for(int i=0; i<emaili.size(); i++){
			if(komitent.getEmail().equals(emaili.get(i))){
				FacesContext.getCurrentInstance().addMessage("email1", new FacesMessage("Ta e-naslov že obstaja!"));
				vnesi=false;
			}
		}
		if(vnesi){	
			//pretvorba iz Date v Calendar
			Calendar cal = Calendar.getInstance();
			cal.setTime(datumR);
			komitent.setDatum(cal);
			// Komitenta dodamo kot userja
			komitent.setVloga("user");
			// klicana metoda za vnos
			kom.shrani(komitent);
			izbrani = kom.najdi(komitent.getId());
			// ustvari nova insatnca
			komitent = izbrani;
			komitent = new Komitent();
			datumR = null;
			return "listaKomitentov";
		}
		else{
			komitent.setEmail("");
			return null;
		}
	}

	// TRRJI IN KARTICE

	// racun
	
	public String switchStatus(TransakcijskiRacun t) {
		if (t.isZaprt())
			t.setZaprt(false);
		else
			t.setZaprt(true);
		trr.edit(t);
		return "pregledTransakcijskihRacunov";
	}
	public String pregledIzdanihRacunov(TransakcijskiRacun trr){
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

	public String racunPlacaj(ERacun racun) {
		TransakcijskiRacun prejemnikERacun = trr.najdi(racun.getTRRprejmnika());
		TransakcijskiRacun posiljateljERacun = trr.najdi((int)racun.getIdTr());
		ArrayList<Postavka> postavke = (ArrayList<Postavka>) p.vrniZneske(racun.getId());
		BigDecimal znesek = new BigDecimal(0);
		for(int i = 0; i < postavke.size();i++) {
			System.out.println(znesek);
			znesek = znesek.add(postavke.get(i).getVrednostZddv());
			System.out.println(znesek);
		}
		if(racun.isPlacan()) {
			fatal(7);
			return "prejetiRacuni";
		}
		if(posiljateljERacun.isZaprt() != false || prejemnikERacun.isZaprt() !=false ) {
			fatal(4);
			System.out.println("NEKDO IMA ZAPRT RACUN!");
			return "prejetiRacuni";
		}
		if(prejemnikERacun.getStanje().doubleValue() <= -100) {
			fatal(3);
			System.out.println("NA RAÈUNU NI DOVOLJ DENARJA");
			return "prejetiRacuni";
		}
		if(prejemnikERacun.getStanje().subtract(znesek).doubleValue() <= -100) {
			fatal(3);
			System.out.println("NA RAÈUNU NI DOVOLJ DENARJA");
			return "prejetiRacuni";
		}
		
		if (!racun.isPlacan()) {
			rac.placajRacun(racun);
			rac.izdajERacun(racun);
			
			transakcija.setZnesek(znesek.negate());
			transakcijaPrejemnika.setZnesek(znesek);
			transakcija.setDatum(Calendar.getInstance());
			transakcijaPrejemnika.setDatum(Calendar.getInstance());
			transakcija.setNaziv((String.valueOf(racun.getStevilkaRacuna())));
			transakcijaPrejemnika.setNaziv((String.valueOf(racun.getStevilkaRacuna())));
			transakcija.setTrenutnoStanje(prejemnikERacun.getStanje());
			transakcijaPrejemnika.setTrenutnoStanje(posiljateljERacun.getStanje());
			BigDecimal novoStanje = prejemnikERacun.getStanje().subtract(znesek);
			prejemnikERacun.setStanje(novoStanje);
			transakcija.setIdTran(prejemnikERacun);
			//transakcija.seteRacun(racun);
			//transakcijaPrejemnika.seteRacun(racun);
			transakcijaPrejemnika.setTRRprejemnika(posiljateljERacun);
			BigDecimal stanje = posiljateljERacun.getStanje().add(znesek);
			posiljateljERacun.setStanje(stanje);
			transakcijaPrejemnika.setTrenutnoStanje(stanje);
			transakcija.setTrenutnoStanje(novoStanje);
			System.out.println("Prejemnik stanje: " + prejemnikERacun.getStanje());
			System.out.println("Posiljatelj stanje: " + posiljateljERacun.getStanje());

			trr.edit(posiljateljERacun);
			trr.edit(prejemnikERacun);
			tr.shrani(transakcijaPrejemnika);
			tr.shrani(transakcija);
			transakcija = new Transakcija();
			transakcijaPrejemnika = new Transakcija();
			System.out.println("Racun placan!");
			success(1);
		}	
		return "prejetiRacuni";
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
		transakcijskiRacun.setStevilkaTRR(tg.generirajIBAN(/*izbrani.getDrzava()*/));
		transakcijskiRacun.setDatumOdprtja(Calendar.getInstance());
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 10);
		transakcijskiRacun.setDatumZaprtja(cal);
		transakcijskiRacun.setZaprt(false);
		BigDecimal bd = new BigDecimal(0);
		transakcijskiRacun.setStanje(bd);
		trr.shrani(transakcijskiRacun);
		Komitent k1 = kom.najdi(izbrani.getId());
		transakcijskiRacun.setKomitent(k1);
		trr.edit(transakcijskiRacun);
		return "pregledTransakcijskihRacunov";
	}

	public String urediKomitenta() {
		kom.shrani(izbrani);
		return "pregledKomitenta";
	}

	public void fatal(int vrstaNapake) {
		if (vrstaNapake == 0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Sprememba gesla ni možna!", "Geslo se ne ujema z geslom v bazi."));
		}
		if (vrstaNapake == 1) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Sprememba gesla ni možna!", "Novo geslo in potrditveno geslo se ne ujemata."));
		}
		if(vrstaNapake == 2) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "Prosimo poskusite ponovno kasneje."));
				}
		if(vrstaNapake == 3) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "Na raèunu ni dovolj denarja."));
				}
		if(vrstaNapake == 5) {
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Polog ni možen!", "Transakcijski raèun je zaprt/blokiran."));
		}
		if (vrstaNapake == 6) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Transakcija ni možna!", "Limita presežena"));
		}
		if (vrstaNapake == 4) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Transakcija ni možna!", "Raèun zaprt/blokiran"));
		}
		if (vrstaNapake == 7) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
					"Plaèilo ni mogoèe!", "Raèun je že bil plaèan"));
		}

	}

	public void success(int st) {
		if(st == 0)
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Geslo uspešno spremenjeno!", "Novo geslo je " + novogeslo));
		if(st == 1)
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Raèun uspešno plaèan!", "Preverite plaèilo pod transakcijami"));
	}

	public String spremeniGeslo() {
		String oldpass;
		String newpass;
		if (novogeslo.equals(potrdigeslo)) {
			oldpass = kodiraj(starogeslo);
			if (izbrani.getGeslo().equals(oldpass)) {
				newpass = kodiraj(novogeslo);
				izbrani.setGeslo(newpass);
				kom.shrani(izbrani);
				success(0);
				novogeslo = "";
				starogeslo = "";
				potrdigeslo = "";
				return "Komitent/nastavitve";
			} else {
				fatal(0);
				return "Komitent/nastavitve";
			}
		} else {
			fatal(1);
			return "Komitent/nastavitve";
		}
	}

	public List<TransakcijskiRacun> vrniTRR(Komitent k) {
		List<TransakcijskiRacun> tr = new ArrayList<TransakcijskiRacun>();
		tr = kom.vrniTRRje(k.getId());
		return tr;
	}
	/*
	 * 
	 * TRANSAKCIJE
	 * 
	 */

	// OSTALE FUNKCIJE
	public String pretvori(Calendar c) {
		if (c != null) {
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
		trrji = kom.vrniTRRje(izbrani.getId());
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
	UpravljanjeKomitenta.glavni = glavni;
	return glavni.getIme()+" "+glavni.getPriimek();
}

public void narisiGraf(){
	if(izbrani!=null){
		vsiDatumi=new ArrayList<List<String>>();
		vseTransakcije=new ArrayList<List<Double>>();
		Komitent k=kom.najdi(izbrani.getId());
		List<TransakcijskiRacun> tran=trr.vrniTRR(k.getId());
		listi=new ArrayList<List<Transakcija>>();
		for(int i=0; i<tran.size(); i++){
			List<Transakcija> list=tr.vrniVse(tran.get(i)); 
			listi.add(list);		
		}
		
		
		for(int i=0; i<listi.size(); i++){
			List<Transakcija> list=listi.get(i);
			List<String> dat=new ArrayList<String>();
	        	for(int j=0; j<list.size(); j++){
	        		if(j<1){
	        			SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
	        			String preoblikovan = oblika.format(list.get(j).getDatum().getTime());
	        			dat.add(preoblikovan);
	        		}
	        		else{
	        			boolean zeNot=false;
	        			for(int l=0; l<j; l++){
	        				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
	        				String preoblikovan = oblika.format(list.get(l).getDatum().getTime());
	        				String preoblikovan1 = oblika.format(list.get(j).getDatum().getTime());
	        				
	        				if(preoblikovan.equals(preoblikovan1)){
	        						zeNot=true;
	        				}
	        			}
	        			if(!zeNot){
	        				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
	        				String preoblikovan = oblika.format(list.get(j).getDatum().getTime());
	        				dat.add(preoblikovan);
	        			}
	        		}
	        	}
	        vsiDatumi.add(dat);
		}
		
		for(int i=0; i<vsiDatumi.size(); i++){
			List<String> d=vsiDatumi.get(i);
			List<Double> stev=new ArrayList<Double>();
			for(int o=0; o<d.size(); o++){
				double st=0;
				for(int j=0; j<listi.get(i).size(); j++){
					SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
					String preoblikovan = oblika.format(listi.get(i).get(j).getDatum().getTime());
					if((d.get(o)).equals(preoblikovan)){
						double s = listi.get(i).get(j).getZnesek().doubleValue();
						st=st+s;
					}
				}
				stev.add(st);
			}
			vseTransakcije.add(stev);
		}
	}
	
}

	public void narisiGraf2() {
		List<Komitent> komitenti = kom.vrniVse();
		datum = new ArrayList<String>();
		stevilo = new ArrayList<Double>();
		for (int i = 0; i < komitenti.size(); i++) {
			if (i < 1) {
				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
				String preoblikovan = oblika.format(komitenti.get(i).getDatumVnosa().getTime());
				datum.add(preoblikovan);
			} else {
				boolean zeNot = false;
				for (int j = 0; j < i; j++) {
					SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
					String preoblikovan = oblika.format(komitenti.get(j).getDatumVnosa().getTime());
					String preoblikovan1 = oblika.format(komitenti.get(i).getDatumVnosa().getTime());

					if (preoblikovan.equals(preoblikovan1)) {
						zeNot = true;
					}
				}
				if (!zeNot) {
					SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
					String preoblikovan = oblika.format(komitenti.get(i).getDatumVnosa().getTime());
					datum.add(preoblikovan);
				}
			}
		}
		for (int i = 0; i < datum.size(); i++) {
			double st = 0;
			for (int j = 0; j < komitenti.size(); j++) {
				SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
				String preoblikovan = oblika.format(komitenti.get(j).getDatumVnosa().getTime());
				if ((datum.get(i)).equals(preoblikovan)) {
					st++;
				}
			}
			stevilo.add(st);
		}
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
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	public Transakcija getTransakcijaPrejemnika() {
		return transakcijaPrejemnika;
	}

	public void setTransakcijaPrejemnika(Transakcija transakcijaPrejemnika) {
		this.transakcijaPrejemnika = transakcijaPrejemnika;
	}
	private BarChartModel barModel;
 
    public BarChartModel getBarModel() {
    	createBarModel();
        return barModel;
    }
 
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Transakcije");
        int st = 1;
        for(int i = 0; i < transakcije.size(); i++) {
        	boys.set(st, transakcije.get(i).getTrenutnoStanje());
        	st++;
        }  
        model.addSeries(boys);
         
        return model;
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("Transakcije");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Spremembe stanja");
         
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Znesek");
    }
}
