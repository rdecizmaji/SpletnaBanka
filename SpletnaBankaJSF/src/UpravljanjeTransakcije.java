
import java.math.BigDecimal;
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
	private Transakcija transakcijaPrejemnika = new Transakcija();
	private Komitent komitent = new Komitent();
	private String TRRP;
	private int TRR;
	private BigDecimal znesek;
	private Date datumT;

	public void fatal(int vrstaNapake) {
		if(vrstaNapake == 0) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Transakcija ni možna!", "IBAN raèun se ne ujema z nobenim drugim raï¿½unom v NMB Banki."));
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
		if(vrstaNapake == 4) {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Polog ni možen!", "Transakcijski raèun je zaprt/blokiran."));
			}
	}
	public String shraniTransakcijo(){
		//iskanje transakcijsih raï¿½unov, plaï¿½nik po id-ju, prejemnik po TRR-ju
		TransakcijskiRacun transakcijskiRacunPlacnika = trr.najdi(TRR);
		TransakcijskiRacun transakcijskiRacunPrejemnika = trr.najdi(TRRP);
		if(transakcijskiRacunPlacnika == transakcijskiRacunPrejemnika) {
			fatal(0);
			System.out.println("IBAN NI PRAVI!");
			return "nakazi";
		}
		if(transakcijskiRacunPlacnika.isZaprt() != false || transakcijskiRacunPlacnika.isZaprt() !=false ) {
			fatal(1);
			System.out.println("NEKDO IMA ZAPRT RACUN!");
			return "nakazi";
		}
		if(transakcijskiRacunPlacnika.getStanje().doubleValue() <= -100) {
			fatal(2);
			System.out.println("NA RAï¿½UNU NI DOVOLJ DENARJA");
			return "nakazi";
		}
		if(transakcijskiRacunPlacnika.getStanje().subtract(transakcija.getZnesek()).doubleValue() <= -100) {
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
		transakcijaPrejemnika.setDatum(cal);
		transakcijaPrejemnika.setTRRprejemnika(transakcijskiRacunPrejemnika);
		transakcija.setIdTran(transakcijskiRacunPlacnika);
		transakcijaPrejemnika.setZnesek(transakcija.getZnesek());
		transakcijaPrejemnika.setNaziv(transakcija.getNaziv());
		//nastavljanje novega stanja
		BigDecimal novoStanje = transakcijskiRacunPlacnika.getStanje().subtract(transakcija.getZnesek());
		transakcija.setZnesek(transakcija.getZnesek().negate());
		transakcija.setTrenutnoStanje(novoStanje);
		transakcijskiRacunPlacnika.setStanje(novoStanje);
		novoStanje = transakcijskiRacunPrejemnika.getStanje().add(transakcijaPrejemnika.getZnesek());
		transakcijskiRacunPrejemnika.setStanje(novoStanje);
		transakcijaPrejemnika.setTrenutnoStanje(novoStanje);
		tran.shrani(transakcijaPrejemnika);
		tran.shrani(transakcija);
		trr.edit(transakcijskiRacunPrejemnika);
		trr.edit(transakcijskiRacunPlacnika);
		znesek = null;
		TRRP = null;
		transakcija = new Transakcija();
		transakcijaPrejemnika = new Transakcija();
		setKomitent(new Komitent());
			if(UpravljanjeKomitenta.glavni!=null){
				return "/Banka/pregledTransakcijskihRacunov.xhtml";
			}
			else{
				return "/Komitent/pregledTransakcijskihRacunov.xhtml";
			}
		}catch (Exception e) {
			fatal(3);
			return "nakazi";
		}
	}

	public String pologDenarja() {
		TransakcijskiRacun transakcijskiRacun = trr.najdi(TRR);
		if(transakcijskiRacun.isZaprt() == true) {
			fatal(4);
			return "polog";
		}
		datumT = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumT);
		transakcija.setDatum(cal);
		transakcija.setNaziv("Polog denarja");
		transakcija.setTrenutnoStanje(transakcijskiRacun.getStanje().add(transakcija.getZnesek()));
		BigDecimal novoStanje = transakcijskiRacun.getStanje().add(transakcija.getZnesek());
		transakcijskiRacun.setStanje(novoStanje);
		transakcija.setIdTran(transakcijskiRacun);
		
		tran.shrani(transakcija);
		trr.edit(transakcijskiRacun);
		transakcija = new Transakcija();
		return "pregledTransakcijskihRacunov";
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
 