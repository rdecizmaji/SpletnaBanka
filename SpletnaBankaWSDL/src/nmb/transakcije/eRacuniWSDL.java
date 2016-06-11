package nmb.transakcije;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import ejb.IERacun;
import ejb.IKomitent;
import ejb.IPostavka;
import ejb.ITransakcijskiRacun;
import entitete.ERacun;
import entitete.Komitent;
import entitete.Postavka;

@WebService
public class eRacuniWSDL {
	@Resource
	private WebServiceContext wsctx;
	
	@EJB
	private ITransakcijskiRacun itrr;
	
	@EJB
	private IERacun ier;
	
	@EJB
	private IPostavka ipo;
	
	@EJB
	private IKomitent ikom;
	
	public String izdajERacun(String izd,String pre,int stRacuna,String krajizdaje,String nacinplacila,int kodanamena, String referenca,Calendar datumod,Calendar datumdo,Calendar datumzap, List<Postavka> postavke){
		Komitent komitent=itrr.vrniKomitenta(izd);
		if (new Avtentikator().doAuthentication(wsctx, komitent,izd)==false)
			return null;
		
		ERacun er=new ERacun();
		
		//Datum
		er.setDatumDo(datumdo);
		er.setDatumOd(datumod);
		
		Date TrenutniDatum = new Date();
		Calendar datumIzdaje = Calendar.getInstance();
		datumIzdaje.setTime(TrenutniDatum);

		er.setDatumIzdaje(datumIzdaje);
		er.setDatumZapadlosti(datumzap);
		er.setIdKn(kodanamena);
		//
		
		Komitent k1=itrr.vrniKomitenta(izd);
		Komitent k2=itrr.vrniKomitenta(pre);
		er.setIdTr(k1.getId());
		
		
		er.setKrajIzdaje(krajizdaje);
		er.setNacinPlacila(nacinplacila);
		er.setIdKn(kodanamena);
		
		ier.izdajERacun(er);
		
		long ider=er.getId();
		for (Postavka p:postavke){
			p.setIdER(ider);
			ipo.shrani(p);
		}		
		
		return "Racun izdan";
	}
	
	public List <ERacun> vrniRacune(String trr, int option){
		Komitent komitent=itrr.vrniKomitenta(trr);
		if (new Avtentikator().doAuthentication(wsctx, komitent,trr)==false)
			return null;
		
		long id=itrr.najdi(trr).getId();
		
		if (option==1){
			return ier.vrniVsePlacane(id);
		}
		if (option==2){
			return ier.vrniVseNeplacane(id);
		}
		if (option==3){
			return ier.vrniVse(id);
		}
		
		return null;
		
	}

	public String testirajPovezavo(String trr) {
		Komitent komitent=itrr.vrniKomitenta(trr);
		if (new Avtentikator().doAuthentication(wsctx, komitent,trr)==false)
			return "Napaka v avtorizaciji!";

		return "Povezava je uspešna!";

	}
	
}
