import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb.IERacun;
import ejb.IKodaNamena;
import ejb.IKomitent;
import ejb.IPostavka;
import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.ERacun;
import entitete.KodaNamena;
import entitete.Komitent;
import entitete.Postavka;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

import org.primefaces.model.chart.LineChartModel;

@ManagedBean(name = "upravljanjeERacuna")
@SessionScoped
public class UpravljanjeERacuna {

	@EJB
	IKodaNamena koda;
	
	@EJB
	IERacun eRac;
	
	@EJB
	IPostavka post;
	
	@EJB
	ITransakcijskiRacun tr;
	
	@EJB
	IKomitent komitent;
	
	@EJB
	ITransakcija transakcija;
	
	private int idKn;
	private ERacun eRacun=new ERacun();
	List<KodaNamena> kn=new ArrayList<KodaNamena>();
	List<Postavka> postavke=new ArrayList<Postavka>();
	private Date datumI;
	private Date datumOd;
	private Date datumDo;
	private Date datumZap;
	private int idTRR;
	private String trrPRJ;
	private long idRac;
	private int dolocitelj=0;
	private int stER;
	private BigDecimal skupenZnesekBrez=new BigDecimal("0");
	private BigDecimal skupenZnesek=new BigDecimal("0");
	private BigDecimal popusti=new BigDecimal("0");
	private BigDecimal DDV=new BigDecimal("0");


	public int getDolocitelj() {
		return dolocitelj;
	}

	public void setDolocitelj(int dlocitelj) {
		this.dolocitelj = dlocitelj;
	}

	public long getIdRac() {
		return idRac;
	}

	public void setIdRac(long idRac) {
		this.idRac = idRac;
	}

	public List<KodaNamena> getKn() {
		kn=koda.vrniVse();
		return kn;
	}

	public void setKn(List<KodaNamena> kn) {
		this.kn = kn;
	}

	public ERacun geteRacun() {
		return eRacun;
	}

	public void seteRacun(ERacun eRacun) {
		this.eRacun = eRacun;
	}
	
	public Date getDatumI() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		  datumI = new Date();
		  dateFormat.format(datumI);
		return datumI;
	}

	public void setDatumI(Date datumI) {
		this.datumI = datumI;
	}

	public Date getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public Date getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public Date getDatumZap() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		 datumZap = new Date();
		 datumZap.setMonth(datumZap.getMonth()+1);
		 dateFormat.format(datumZap);
		
		
		return datumZap;
	}

	public void setDatumZap(Date datumZap) {
		this.datumZap = datumZap;
	}
	public String shraniERacun(){
		try{
			//eRaèun
			Calendar cal = Calendar.getInstance();
			cal.setTime(datumI);
			eRacun.setDatumIzdaje(cal);
			
			Calendar cal1 = Calendar.getInstance();
			cal1.setTime(datumOd);
			eRacun.setDatumOd(cal1);
			
			if(datumDo!=null){
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(datumDo);
				eRacun.setDatumDo(cal2);
			}
			
			Calendar cal3 = Calendar.getInstance();
			cal3.setTime(datumZap);
			eRacun.setDatumZapadlosti(cal3);
			
			if(eRacun.getNacinPlacila().equals("Raèun je že plaèan.")){
				eRacun.setPlacan(true);
			}
			eRacun.setTRRprejmnika(trrPRJ);
			
			TransakcijskiRacun tRac=tr.najdi(idTRR);	
			KodaNamena kodaNam=koda.najdi(idKn);
			
			eRacun.setIdKn(kodaNam.getId());
			eRacun.setIdTr(tRac.getId());	
			eRac.izdajERacun(eRacun);
			
			ERacun e=eRac.najdi(eRacun);
			for(int i=0; i<postavke.size(); i++){
					Postavka p=postavke.get(i);
					p.setIdER(e.getId());
					post.shrani(p);	
			}		
			
			postavke=new ArrayList<Postavka>();
			kn=new ArrayList<KodaNamena>();
			eRacun=new ERacun();
			datumI=null;
			datumOd=null;
			datumDo=null;
			datumZap=null;
			trrPRJ=null;
		}catch(Exception e){
			postavke=new ArrayList<Postavka>();
			kn=new ArrayList<KodaNamena>();
			eRacun=new ERacun();
			datumI=null;
			datumOd=null;
			datumDo=null;
			datumZap=null;
			trrPRJ=null;
		}
		if(UpravljanjeKomitenta.glavni!=null){
			return "/Banka/pregledKomitenta.xhtml";
		}
		else
			return "/Komitent/pregledKomitenta.xhtml";
	}
	public String pretvori(Calendar c){
		SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
		String preoblikovan = oblika.format(c.getTime());
		return preoblikovan;
	}
	public String pretvoriString(boolean placan){
		if(placan==false){
			return "Ne";
		}
		else{
			return "Da";
		}
	}

	public int getIdKn() {
		return idKn;
	}

	public void setIdKn(int idKn) {
		this.idKn = idKn;
	}

	public List<Postavka> getPostavke() {
		return postavke;
	}

	public void setPostavke(List<Postavka> postavke) {
		this.postavke = postavke;
	}
	

	public void dodajVrstico(){
		Postavka p=new Postavka();
		System.out.println(postavke.size());
		postavke.add(p);
		
	}
	public void izbrisi(Postavka p){
		postavke.remove(p);
	}

	public String getTrrPRJ() {
		return trrPRJ;
	}

	public int getIdTRR() {
		return idTRR;
	}

	public void setIdTRR(int idTRR) {
		this.idTRR = idTRR;
	}

	public void setTrrPRJ(String trrPRJ) {
		this.trrPRJ = trrPRJ;
	}

	public BigDecimal getSkupenZnesekBrez() {
		return skupenZnesekBrez;
	}

	public void setSkupenZnesekBrez(BigDecimal skupenZnesekBrez) {
		this.skupenZnesekBrez = skupenZnesekBrez;
		
	}

	public BigDecimal getSkupenZnesek() {
		return skupenZnesek;
	}

	public void setSkupenZnesek(BigDecimal skupenZnesek) {
		this.skupenZnesek = skupenZnesek;
	}

	public BigDecimal getPopusti() {
		return popusti;
	}

	public void setPopusti(BigDecimal popusti) {
		this.popusti = popusti;
	}
	
	public BigDecimal getDDV() {
		return DDV;
	}

	public void setDDV(BigDecimal dDV) {
		DDV = dDV;
	}

	public void izracunaj(){
		if(postavke!=null){
			skupenZnesekBrez=new BigDecimal("0");
			skupenZnesek=new BigDecimal("0");
			popusti=new BigDecimal("0");
			DDV=new BigDecimal("0");
			
			for(int i=0; i<postavke.size();i++){
				System.out.println(popusti);
				popusti=popusti.add(postavke.get(i).getZnesek_popusta());
				skupenZnesekBrez=skupenZnesekBrez.add((postavke.get(i).getCena_na_enoto()).multiply(new BigDecimal((postavke.get(i).getKolicina()))));
				BigDecimal osnova=(postavke.get(i).getCena_na_enoto()).multiply(new BigDecimal((postavke.get(i).getKolicina()))).subtract(postavke.get(i).getZnesek_popusta());
				DDV=DDV.add((osnova.multiply(new BigDecimal(postavke.get(i).getDdv()))).divide(new BigDecimal("100")));
				skupenZnesek=skupenZnesek.add(postavke.get(i).getVrednostZddv());
				
			}
		}
		
	}
	public String dolociRacun(int id){
		idRac=id;
		if(UpravljanjeKomitenta.glavni!=null){
			return "/Banka/pregledPostavk.xhtml";
		}
		else{
			return "/Komitent/pregledPostavk.xhtml";
		}
	}
	
	public List<Postavka> vrniVsePostavke(){
		List<Postavka> list=post.vrniZneske(idRac);
		return list;
	}
	
	public List<ERacun> vrniVse(Komitent kom){
		if(dolocitelj==1){
			Komitent k=komitent.najdi(kom);
			List<TransakcijskiRacun> tran=tr.vrniTRR(k.getId());
			List<ERacun> list=new ArrayList<ERacun>();
			for(int i=0; i<tran.size(); i++){
				List<ERacun> list2=eRac.vrniVsePlacane(tran.get(i).getId());
				list.addAll(list2);
			}
			return list;
		}
		else if(dolocitelj==2){
			Komitent k=komitent.najdi(kom);
			List<TransakcijskiRacun> tran=tr.vrniTRR(k.getId());
			List<ERacun> list=new ArrayList<ERacun>();
			for(int i=0; i<tran.size(); i++){
				List<ERacun> list2=eRac.vrniVseNeplacane(tran.get(i).getId());
				list.addAll(list2);
			}
			return list;
		}
		Komitent k=komitent.najdi(kom);
		List<TransakcijskiRacun> tran=tr.vrniTRR(k.getId());
		List<ERacun> list=new ArrayList<ERacun>();
		for(int i=0; i<tran.size(); i++){
			List<ERacun> list2=eRac.vrniVse(tran.get(i).getId());
			list.addAll(list2);
		}
		return list;
	}
	
	public String vrniZnesek(int id){ 
		List<Postavka> list=post.vrniZneske(id);
		BigDecimal znesek=new BigDecimal("0");
		for(int i=0; i<list.size(); i++){
			znesek=znesek.add(list.get(i).getVrednostZddv());
		}
		return znesek.toString();
	}

	//armaturna komitent
	public int getStER(Komitent kom) {
		Komitent k=komitent.najdi(kom);
		List<TransakcijskiRacun> tran=tr.vrniTRR(k.getId());
		stER=0;
		for(int i=0; i<tran.size(); i++){
			List<ERacun> list=eRac.vrniVse(tran.get(i).getId());
			stER=stER+list.size();
		}
		return stER;
	}
	
	public int vseTransakcije(Komitent kom) {
		Komitent k=komitent.najdi(kom);
		List<TransakcijskiRacun> tran=tr.vrniTRR(k.getId());
		int stTransakcij=0;
		for(int i=0; i<tran.size(); i++){
			List<Transakcija> list=transakcija.vrniVse(tran.get(i)); 
			stTransakcij=stTransakcij+list.size();
		}
		return stTransakcij;
	}
	public BigDecimal vsiZneski(Komitent kom) {
		Komitent k=komitent.najdi(kom);
		List<TransakcijskiRacun> tran=tr.vrniTRR(k.getId());
		BigDecimal znesek=new BigDecimal("0");
		for(int i=0; i<tran.size(); i++){
			znesek=znesek.add(tran.get(i).getStanje()); 
		}
		return znesek;
	}
	
	//armaturna banka
	public int vseTransakcije(){
		List<Transakcija>t=transakcija.vrniVse();
		return t.size();
	}
	
	public int stKomitentov(){
		List<Komitent> k=komitent.vrniVse();
		return k.size();
	}
	
	public int stTRRracunov(){
		List<TransakcijskiRacun> t=tr.vrniVse();
		return t.size();
	}
	public int stEracunov(){
		List<ERacun> e=eRac.vrniVse();
		return e.size();
	}
}
 