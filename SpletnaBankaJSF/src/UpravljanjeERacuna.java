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
import ejb.IPostavka;
import ejb.ITransakcijskiRacun;
import entitete.ERacun;
import entitete.KodaNamena;
import entitete.Postavka;
import entitete.TransakcijskiRacun;

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
	
	private BigDecimal skupenZnesekBrez=new BigDecimal("0");
	private BigDecimal skupenZnesek=new BigDecimal("0");
	private BigDecimal popusti=new BigDecimal("0");
	private BigDecimal DDV=new BigDecimal("0");

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
			
			if(eRacun.getNacinPlacila().equals("Raèun je že plaèan")){
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

		return "/Banka/pregledKomitenta.xhtml";
	}
	public String pretvori(Calendar c){
		SimpleDateFormat oblika = new SimpleDateFormat("dd.MM.yyyy");
		String preoblikovan = oblika.format(c.getTime());
		return preoblikovan;
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
	public List<ERacun> vrniVse(){
		return eRac.vrniVse();
	}
	
	
}
 