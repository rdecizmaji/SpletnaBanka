
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
	private String TRRP;
	private int TRR;
	private BigDecimal znesek;
	private Date datumT;

	public void fatal() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Fatal!", "System Error"));
    }
	public String shraniTransakcijo(){
		
		TransakcijskiRacun transakcijskiRacunPlacnika = trr.najdi(TRR);
		TransakcijskiRacun transakcijskiRacunPrejemnika = trr.najdi(TRRP);
		if(transakcijskiRacunPlacnika == transakcijskiRacunPrejemnika) {
			fatal();
			System.out.println("Transakcija ni možna");
		}
		//datum transakcije
		datumT = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumT);
		transakcija.setDatum(cal);
		transakcija.setZnesek(znesek);
		//iskanje transakcijsih raèunov, plaènik po id-ju, prejemnik po TRR-ju
		transakcija.setTRRprejemnika(transakcijskiRacunPrejemnika);
		transakcija.setIdTran(transakcijskiRacunPlacnika);
		
		//nastavljanje novega stanja
		BigDecimal novoStanje = transakcijskiRacunPlacnika.getStanje().subtract(znesek);
		transakcijskiRacunPlacnika.setStanje(novoStanje);
		novoStanje = transakcijskiRacunPrejemnika.getStanje().add(znesek);
		transakcijskiRacunPrejemnika.setStanje(novoStanje);
		
		tran.shrani(transakcija);
		trr.edit(transakcijskiRacunPrejemnika);
		trr.edit(transakcijskiRacunPlacnika);

		
	
		
		System.out.println("Prejemnik: " + transakcijskiRacunPrejemnika.getStevilkaTRR());
		System.out.println("Placnik: " + transakcijskiRacunPlacnika.getStevilkaTRR());
		
		
		return "/Banka/pregledTransakcijskihRacunov.xhtml";
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
	
}
 