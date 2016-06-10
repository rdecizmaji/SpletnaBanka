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
	WebServiceContext wsctx;
	
	@EJB
	ITransakcijskiRacun itrr;
	
	@EJB
	IERacun ier;
	
	@EJB
	IPostavka ipo;
	
	@EJB
	IKomitent ikom;
	
	public String izdajERacun(String izd,String pre,int stRacuna,String krajizdaje,String nacinplacila,int kodanamena, String referenca,Calendar datumod,Calendar datumdo,Calendar datumzap, List<Postavka> postavke){
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
	
//	prejeti-placani
//	prejeti-neplacani
	
	
	public List <ERacun> vrniIzdanePlacane(String trr){
				long id=itrr.najdi(trr).getId();
				
				return ier.vrniVsePlacane(id);
	}
	
	public List <ERacun> vrniIzdaneNeplacane(String trr){
		long id=itrr.najdi(trr).getId();
		
		return ier.vrniVseNeplacane(id);
}

	public String testirajPovezavo() {
		if (doAuthentication() == false)
			return "Napaka v avtorizaciji!";

		return "Povezava je uspešna!";

	}

	private boolean doAuthentication() {

		MessageContext mctx = wsctx.getMessageContext();

		// get detail from request headers
		Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");

		String username = "";
		String password = "";

		if (userList != null) {
			// get username
			username = userList.get(0).toString();
		}

		if (passList != null) {
			// get password
			password = passList.get(0).toString();
		}

		// Should validate username and password with database
		if (username.equals("floro") && password.equals("flores")) {
			return true;

		} else {
			return false;
		}
	}
	
}
