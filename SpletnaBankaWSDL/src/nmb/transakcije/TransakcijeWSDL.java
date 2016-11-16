package nmb.transakcije;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.Komitent;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;


@WebService
public class TransakcijeWSDL {
	
	@Resource
	private WebServiceContext wsctx;
	
	@EJB
	private ITransakcija itran;
	
	@EJB
	private ITransakcijskiRacun itrr;
	
	public String izvrsiNalog(String trr, String trrp, String namen,BigDecimal znesek ){
		Komitent komitent=itrr.vrniKomitenta(trr);
		if (new Avtentikator().doAuthentication(wsctx, komitent,trr)==false)
			return null;
		
		TransakcijskiRacun transakcijskiRacunPlacnika = itrr.najdi(trr);
		TransakcijskiRacun transakcijskiRacunPrejemnika = itrr.najdi(trrp);
		
		//Datum
		Date TrenutniDatum = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(TrenutniDatum);
		//
		
		Transakcija t1=new Transakcija();
		t1.setNaziv(namen);
		t1.setDatum(cal);
		t1.setZnesek(znesek);
		t1.setIdTran(transakcijskiRacunPlacnika);
		
		itran.shrani(t1);
		
		Transakcija t2 = new Transakcija();
		t2.setNaziv(namen);
		t2.setDatum(cal);
		t2.setZnesek(znesek);
		t2.setTRRprejemnika(transakcijskiRacunPrejemnika);
		
		itran.shrani(t2);
		
		return "Uspešno hranjeno";
	}
	
	public List <Transakcija> vrniTransakcije(String trr){
		Komitent komitent=itrr.vrniKomitenta(trr);
		if (new Avtentikator().doAuthentication(wsctx, komitent,trr)==false)
			return null;
		
		TransakcijskiRacun transakcijskiRacun = itrr.najdi(trr);
		
		return itrr.vrniTransakcije(transakcijskiRacun);
	}
	
	public String testirajPovezavo(String trr) {
		Komitent komitent=itrr.vrniKomitenta(trr);
		if (new Avtentikator().doAuthentication(wsctx, komitent,trr)==false)
			return "Napaka v avtorizaciji!";

		return "Napaka v avtentikaciji";
	}

}
