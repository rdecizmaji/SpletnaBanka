
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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


	public String shraniTransakcijo(){
		//datum transakcije
		datumT = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(datumT);
		transakcija.setDatum(cal);
		transakcija.setZnesek(znesek);
		//iskanje transakcijsih raèunov, plaènik po id-ju, prejemnik po TRR-ju
		TransakcijskiRacun transakcijskiRacunPlacnika = trr.najdi(TRR);
		TransakcijskiRacun transakcijskiRacunPrejemnika = trr.najdi(TRRP);
		transakcija.setTRRplacnika(transakcijskiRacunPlacnika.getStevilkaTRR());
		//nastavljanje novega stanja
		BigDecimal novoStanje = transakcijskiRacunPlacnika.getStanje().subtract(znesek);
		transakcijskiRacunPlacnika.setStanje(novoStanje);
		novoStanje = transakcijskiRacunPrejemnika.getStanje().add(znesek);
		transakcijskiRacunPrejemnika.setStanje(novoStanje);
		
		trr.edit(transakcijskiRacunPrejemnika);
		trr.edit(transakcijskiRacunPlacnika);

		if(transakcijskiRacunPlacnika == transakcijskiRacunPrejemnika) {
			System.out.println("Transakcija ni možna");
		}
		
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
 