package tests;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import gen.komitenti.Komitent;
import gen.komitenti.KomitentiWSDL;
import gen.komitenti.KomitentiWSDLService;
import gen.komitenti.TransakcijskiRacun;

public class KomitentiWsdlTest {

	//dodajKomitenta
	//najdiKomitentaPoId
	//najdiKomitentaPoTrr
	//vrniVseKomitente
	//vrniTRRjeKomitenta
	//vrniTRR
	
	public static void main(String[] args) throws Exception{
		Komitent k=dodajKomitenta();
		Komitent najden=najdiKomitentaPoId(k.getId());
		izpis(najden);
		Komitent najden2=najdiKomitentaPoTrr((String)k.getTransakcijskiRacuni().get(0));
		izpis(najden2);
		
		for (TransakcijskiRacun trr: vrniTRRjeKomitenta(najden2.getId())) {
			System.out.println("TRR -------------------");
			izpis(trr);
		}
		
		izpis(vrniTRR((String)k.getTransakcijskiRacuni().get(0)));
		
		for (Komitent kom:vrniVseKomitente()) {
			System.out.println("KOM -------------------");
			izpis(kom);
		}
		
//		System.out.println("--------");
//		izpis(vrniTRR("trr"));
//		izpis(najdiKomitentaPoId(-9));
//		izpis(najdiKomitentaPoTrr("trr"));
		
	}
	
	public static TransakcijskiRacun vrniTRR(String stevilka) throws Exception {
		KomitentiWSDL kom=connect();
		return kom.vrniTRR(stevilka);
	}
	
	public static List<TransakcijskiRacun> vrniTRRjeKomitenta(int idKomitenta) throws Exception {
		KomitentiWSDL kom=connect();
		return kom.vrniTRRjeKomitenta(idKomitenta);
	}
	
	public static List<Komitent> vrniVseKomitente() throws Exception {
		KomitentiWSDL kom=connect();
		return kom.vrniVseKomitente();
	}
	
	public static Komitent najdiKomitentaPoId(int id) throws Exception {
		KomitentiWSDL kom=connect();
		return kom.najdiKomitentaPoId(id);
	}
	
	public static Komitent najdiKomitentaPoTrr(String trr) throws Exception {
		KomitentiWSDL kom=connect();
		return kom.najdiKomitentaPoTrr(trr);
	}
	
	public static Komitent dodajKomitenta() throws Exception {
		KomitentiWSDL kom=connect();
		
		Komitent k=new Komitent();
		k.setEmail("luka.pavlic@um.si");
		k.setIme("Luka");
		k.setPriimek("Pavlic");
		k.setGeslo("mojeGeslo");
		
		return kom.dodajKomitenta(k);
	}
	
	public static KomitentiWSDL connect() {
		KomitentiWSDL ret=new KomitentiWSDLService().getKomitentiWSDLPort();
        Map<String, Object> req_ctx = ((BindingProvider)ret).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("admin"));
        headers.put("Password", Collections.singletonList("Smart.Road"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        return ret;
	}
	
	public static void izpis(TransakcijskiRacun trr) {
		if (trr==null) return;
		System.out.println(trr.getStevilkaTRR());
		System.out.println(trr.getKomitent());
		System.out.println(trr.getDatumOdprtja());
		System.out.println(trr.getStanje());
		System.out.println(trr.getTransakcije());
	}
	
	public static void izpis(Komitent kom) {
		if (kom==null) return;
		System.out.println(kom.getId());
		System.out.println(kom.getIme());
		System.out.println(kom.getPriimek());
		System.out.println(kom.getEmail());
		System.out.println(kom.getUporabniskoIme());
		System.out.println(kom.getGeslo());
		System.out.println(kom.getDavcnaSt());
		System.out.println(kom.getDrzava());
		System.out.println(kom.getNaslov());
		System.out.println(kom.getEmso());
		System.out.println(kom.getPosta());
		System.out.println(kom.getPostnaSt());
		System.out.println(kom.getTransakcijskiRacuni());
	}

}
