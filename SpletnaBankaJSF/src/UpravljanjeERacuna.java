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
		return datumZap;
	}

	public void setDatumZap(Date datumZap) {
		this.datumZap = datumZap;
	}
	public String shraniERacun(){
		
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
			
			//POSTAVKA
			for(int i=0; i<postavke.size(); i++){
				Postavka p=postavke.get(i);
				p.setIdEr(eRacun);
				post.shrani(p);
			}
			
		eRacun.setPostavke(postavke);	
			
		TransakcijskiRacun tRac=tr.najdi(idTRR);	
		KodaNamena kodaNam=koda.najdi(idKn);
		eRacun.setTRRprejmnika(trrPRJ);
		eRacun.setIdTr(tRac);
		eRacun.setIdKn(kodaNam);	
		//KODA NAMENA
			List<ERacun> er= kodaNam.getEracuni();
			er.add(eRacun);
			koda.edit(kodaNam);
			
			//TRR
			List<ERacun> list=tRac.getEracuni();
			list.add(eRacun);
			tRac.setEracuni(list);
			tr.edit(tRac);
		
		System.out.println("PRED");
		eRac.izdajERacun(eRacun);
		
		System.out.println("PO");
	
			
			
		postavke=new ArrayList<Postavka>();
		kn=new ArrayList<KodaNamena>();
		eRacun=new ERacun();
		datumI=null;
		datumOd=null;
		datumDo=null;
		datumZap=null;
		trrPRJ=null;

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
	
	
}
 