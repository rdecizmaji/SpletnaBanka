package nmb.transakcije;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import ejb.IERacun;
import ejb.IKomitent;
import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.ERacun;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;
import nmb.transakcije.vao.Racun;

@WebService
public class eRacuniWSDL {
	
	@Resource
	private WebServiceContext wsctx;
	
	@EJB
	private ITransakcijskiRacun itrr;
	
	@EJB
	private ITransakcija itran;
	
	@EJB
	private IERacun ier;
	
	@EJB
	private IKomitent ikom;
	
	private entitete.Komitent login() throws Exception {
		Map http_headers = (Map) wsctx.getMessageContext().get(MessageContext.HTTP_REQUEST_HEADERS);
		List userList = (List) http_headers.get("Username");
		List passList = (List) http_headers.get("Password");
	
		String username = userList.get(0).toString();
		String password = passList.get(0).toString();
		
		entitete.Komitent ret=ikom.prijaviKomitenta(username, password);
		if (ret==null) throw new Exception("Authentication exception");
		return ret;
	}
	
	public Racun izdajERacun(Racun r) throws Exception {
		login();
		TransakcijskiRacun trr=itrr.najdi(r.getTrrIzdajatelja());
		if (trr==null) return null;
		
		int idTrrIzdajatelj=trr.getId();
		ERacun er=r.toEjbRacun(idTrrIzdajatelj);
		er.setDatumIzdaje(new GregorianCalendar());
		ier.izdajERacun(er);
		
		return new Racun(er,r.getTrrIzdajatelja());
	}
	
	public String placajERacun(int idRacuna) throws Exception {
		login();
		
		ier.placajERacunCelotno(idRacuna);
		
//		ERacun er=ier.najdi(idRacuna);
//		TransakcijskiRacun transakcijskiRacunPlacnika = itrr.najdi(er.getTRRprejmnika());
//		TransakcijskiRacun transakcijskiRacunPrejemnika = itrr.najdi((int)er.getIdTr());
//		
//		Racun r=new Racun(er, transakcijskiRacunPrejemnika.getStevilkaTRR());
//				
//		Transakcija t1=new Transakcija();
//		t1.setNaziv("Racun "+er.getStevilkaRacuna());
//		t1.setDatum(new GregorianCalendar());
//		t1.setZnesek(r.getVrednostZddv().multiply(new BigDecimal(-1)));
//		t1.setIdTran(transakcijskiRacunPlacnika);
//		
//		itran.shrani(t1);
//		
////		transakcijskiRacunPlacnika.getTransakcije().add(t1);
//		
//		Transakcija t2 = new Transakcija();
//		t2.setNaziv("Racun "+er.getStevilkaRacuna());
//		t2.setDatum(new GregorianCalendar());
//		t2.setZnesek(r.getVrednostZddv());
//		t2.setTRRprejemnika(transakcijskiRacunPrejemnika);
//		
//		itran.shrani(t2);
//
//		System.out.println("PLAÈANO T2");
//		
		return "OK";
	}
	
	public List<Racun> vrniVseIzdaneRacune(String trr) throws Exception {
		login();
		List<Racun> ret=new ArrayList<>();
		
		TransakcijskiRacun tr=itrr.najdi(trr);
		if (tr==null) return ret;
		
		long id=tr.getId();
		for (ERacun e:ier.vrniVse(id)) {
			ret.add(new Racun(e, trr));
		}
		return ret;
	}
	
	public List <Racun> vrniVsePrejeteRacune(String trr) throws Exception {
		login();
		List<Racun> ret=new ArrayList<>();
		for (ERacun e:ier.vrniVsePrejete(trr)) {
			ret.add(new Racun(e, trr));
		}
		return ret;
	}
	
	public List <Racun> vrniVseprejeteNeplacaneRacune(String trr) throws Exception {
		login();
		List<Racun> ret=new ArrayList<>();
		for (ERacun e:ier.vrniVsePrejete(trr)) {
			if (!e.isPlacan()) ret.add(new Racun(e, trr));
		}
		return ret;
	}
	
	public List <Racun> vrniVseprejetePlacaneRacune(String trr) throws Exception {
		login();
		List<Racun> ret=new ArrayList<>();
		for (ERacun e:ier.vrniVsePrejete(trr)) {
			if (e.isPlacan()) ret.add(new Racun(e, trr));
		}
		return ret;
	}

}
