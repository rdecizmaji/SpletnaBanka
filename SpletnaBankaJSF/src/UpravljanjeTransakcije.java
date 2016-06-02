
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ejb.IKomitent;
import ejb.ITipKartice;
import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.Komitent;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

@ManagedBean(name = "upravljanjeTransakcije")
@SessionScoped
public class UpravljanjeTransakcije {

	@EJB
	IKomitent kom;
	@EJB
	ITipKartice tipkar;
	@EJB
	ITransakcijskiRacun trr;
	@EJB
	ITransakcija tran;
	
	private int idKn;
	private Transakcija transakcija = new Transakcija();
	private Komitent komitent = new Komitent();
	private String TRRP;
	private int TRR;
	private BigDecimal znesek;
	private Date datumT;

	public void fatal(int vrstaNapake) {
		if(vrstaNapake == 0) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "IBAN raèun se ne ujema z nobenim drugim raèunom v NMB Banki."));
		}
		if(vrstaNapake == 1) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "Prosimo poskusite ponovno kasneje."));
			}
		if(vrstaNapake == 2) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "Na raèunu ni dovolj denarja."));
			}
		if(vrstaNapake == 3) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "Preglejte vpisane podatke in poskusite ponovno."));
			}
	}
	public String shraniTransakcijo(){
		TransakcijskiRacun transakcijskiRacunPlacnika = trr.najdi(TRR);
		TransakcijskiRacun transakcijskiRacunPrejemnika = trr.najdi(TRRP);
		
		if(transakcijskiRacunPlacnika == transakcijskiRacunPrejemnika) {
			fatal(0);
			System.out.println("IBAN NI PRAVI!");
			return "nakazi";
		}
		if(transakcijskiRacunPlacnika.isZaprt() != true || transakcijskiRacunPlacnika.isZaprt() !=true ) {
			fatal(1);
			System.out.println("NEKDO IMA ZAPRT RACUN!");
			return "nakazi";
		}
		if(transakcijskiRacunPlacnika.getStanje().doubleValue() <= -100) {
			fatal(2);
			System.out.println("NA RAÈUNU NI DOVOLJ DENARJA");
			return "nakazi";
		}
		if(transakcijskiRacunPlacnika.getStanje().subtract(znesek).doubleValue() <= -100) {
			fatal(2);
			System.out.println("NA RAÈUNU NI DOVOLJ DENARJA");
			return "nakazi";
		}
		
		
		//datum transakcije
		try {
		datumT = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumT);
		transakcija.setDatum(cal);
		//iskanje transakcijsih raèunov, plaènik po id-ju, prejemnik po TRR-ju
		transakcija.setTRRprejemnika(transakcijskiRacunPrejemnika);
		transakcija.setIdTran(transakcijskiRacunPlacnika);
		
		//nastavljanje novega stanja
		BigDecimal novoStanje = transakcijskiRacunPlacnika.getStanje().subtract(transakcija.getZnesek());
		transakcijskiRacunPlacnika.setStanje(novoStanje);
		novoStanje = transakcijskiRacunPrejemnika.getStanje().add(transakcija.getZnesek());
		transakcijskiRacunPrejemnika.setStanje(novoStanje);
		
		tran.shrani(transakcija);
		trr.edit(transakcijskiRacunPrejemnika);
		trr.edit(transakcijskiRacunPlacnika);

		System.out.println("Prejemnik: " + transakcijskiRacunPrejemnika.getStevilkaTRR());
		System.out.println("Placnik: " + transakcijskiRacunPlacnika.getStevilkaTRR());
		
		znesek = null;
		TRRP = null;
		transakcija = new Transakcija();
		setKomitent(new Komitent());
		return "/Banka/pregledTransakcijskihRacunov.xhtml";
		}
		catch (Exception e) {
			fatal(3);
			return "nakazi";
		}
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
	public BigDecimal getZnesek() {
		return znesek;
	}
	public void setZnesek(BigDecimal znesek) {
		this.znesek = znesek;
	}
	public Transakcija getTransakcija() {
		return transakcija;
	}
	public void setTransakcija(Transakcija transakcija) {
		this.transakcija = transakcija;
	}
	public String getTRRP() {
		return TRRP;
	}
	public void setTRRP(String TRRP) {
		this.TRRP = TRRP;
	}
	public Date getDatumT() {
		return datumT;
	}
	public void setDatumT(Date datumT) {
		this.datumT = datumT;
	}

	public int getTRR() {
		return TRR;
	}

	public void setTRR(int tRR) {
		TRR = tRR;
	}
	public Komitent getKomitent() {
		return komitent;
	}
	public void setKomitent(Komitent komitent) {
		this.komitent = komitent;
	}
	
}
 