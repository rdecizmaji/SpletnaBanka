package tests;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

import gen.komitenti.Komitent;
import gen.komitenti.KomitentiWSDL;
import gen.komitenti.KomitentiWSDLService;
import gen.komitenti.Transakcija;
import gen.komitenti.TransakcijskiRacun;
import gen.racuni.ERacuniWSDL;
import gen.racuni.ERacuniWSDLService;
import gen.racuni.Racun;

public class ScenarijWsdlTest {

	public static void main(String[] args) throws Exception{
		KomitentiWSDL kom=connectKomitenti();
		ERacuniWSDL rac=connectRacuni();
		
		Komitent k1=new Komitent();
		k1.setEmail("komitent1@um.si");
		k1.setIme("Komitent");
		k1.setPriimek("Ena");
		k1.setGeslo("mojeGeslo");
		Komitent komitent1=kom.dodajKomitenta(k1);
		TransakcijskiRacun trr1=kom.vrniTRR(komitent1.getTransakcijskiRacuni().get(0));
		System.out.println("Kreiran komitent "+komitent1.getId()+"; trr "+trr1.getStevilkaTRR());

		Komitent k2=new Komitent();
		k2.setEmail("komitent2@um.si");
		k2.setIme("Komitent");
		k2.setPriimek("Dva");
		k2.setGeslo("mojeGeslo");
		Komitent komitent2=kom.dodajKomitenta(k2);
		TransakcijskiRacun trr2=kom.vrniTRR(komitent2.getTransakcijskiRacuni().get(0));
		System.out.println("Kreiran komitent "+komitent2.getId()+"; TRR: "+trr2.getStevilkaTRR());

		Racun r=new Racun();
		r.setKrajIzdaje("MB");
		r.setReferenca("00001");
		r.setTrrIzdajatelja(trr1.getStevilkaTRR());
		r.setTrrPrejemnika(trr2.getStevilkaTRR());
		r.setVrednost(new BigDecimal(10.00));
		r.setVrednostZddv(new BigDecimal(12.20));
		Racun racun=rac.izdajERacun(r);
		System.out.println("Izdan raèun "+racun.getId()+"; "+racun.getVrednostZddv()+"eur; izdajatelj: "+racun.getTrrIzdajatelja()+"; prejemnik: "+racun.getTrrPrejemnika());

		r=new Racun();
		r.setKrajIzdaje("MB");
		r.setReferenca("00002");
		r.setTrrIzdajatelja(trr2.getStevilkaTRR());
		r.setTrrPrejemnika(trr1.getStevilkaTRR());
		r.setVrednost(new BigDecimal(100.00));
		r.setVrednostZddv(new BigDecimal(122.00));
		Racun racun2=rac.izdajERacun(r);
		System.out.println("Izdan raèun "+racun2.getId()+"; "+racun2.getVrednostZddv()+"eur; izdajatelj: "+racun2.getTrrIzdajatelja()+"; prejemnik: "+racun2.getTrrPrejemnika());
		
		rac.placajERacun(racun.getId());
		System.out.println("Raèun je plaèan.");
		
		rac.placajERacun(racun2.getId());
		System.out.println("Raèun 2 je plaèan.");
		
		trr1=kom.vrniTRR(trr1.getStevilkaTRR());
		trr2=kom.vrniTRR(trr2.getStevilkaTRR());
		
		System.out.println(trr1.getStanje());

		
		for (Transakcija t:trr1.getTransakcije())
			System.out.println("trans: "+t.getZnesek());
		
		System.out.println(trr2.getStanje());
		for (Transakcija t:trr2.getTransakcije())
			System.out.println("trans: "+t.getZnesek());

	}
	
	public static KomitentiWSDL connectKomitenti() {
		KomitentiWSDL ret=new KomitentiWSDLService().getKomitentiWSDLPort();
        Map<String, Object> req_ctx = ((BindingProvider)ret).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("admin"));
        headers.put("Password", Collections.singletonList("Smart.Road"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        return ret;
	}
	
	public static ERacuniWSDL connectRacuni() {
		ERacuniWSDL ret=new ERacuniWSDLService().getERacuniWSDLPort();
        Map<String, Object> req_ctx = ((BindingProvider)ret).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("admin"));
        headers.put("Password", Collections.singletonList("Smart.Road"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        return ret;
	}
	
}
