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
import gen.racuni.ERacuniWSDL;
import gen.racuni.ERacuniWSDLService;
import gen.racuni.Postavka;
import gen.racuni.Racun;

public class RacuniWsdlTest {

//	izdajERacun
//	placajERacun
//	vrniVseIzdaneRacune
//	vrniVsePrejeteRacune
//	vrniVseprejeteNeplacaneRacune
//	vrniVseprejetePlacaneRacune
	
	public static void main(String[] args) throws Exception{
		
//		for (Komitent kom:vrniVseKomitente()) {
//			System.out.println("KOM -------------------");
//			KomitentiWsdlTest.izpis(kom);
//		}
		//SI56 5687 3248 9151 54
		//SI56 9702 5595 2810 319

//		izpis(izdajERacun());
//		izpis(izdajPrazenERacun());

//		vrniVseIzdaneRacune("SI56 5687 3248 9151 54");
		vrniVsePrejeteRacune("SI56 9702 5595 2810 319");
		vrniVseprejeteNeplacaneRacune("SI56 9702 5595 2810 319");
		vrniVseprejetePlacaneRacune("SI56 9702 5595 2810 319");
		
		placajRacun(105);
		
		vrniVsePrejeteRacune("SI56 9702 5595 2810 319");
	}
	
	public static void placajRacun(int idr) throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		rac.placajERacun(idr);
		
		
	}
	
	public static void vrniVseprejetePlacaneRacune(String trr) throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		for (Racun r:rac.vrniVseprejetePlacaneRacune(trr)) {
			System.out.println("R P -------------------");
			izpis(r);
		}
	}
	
	public static void vrniVseprejeteNeplacaneRacune(String trr) throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		for (Racun r:rac.vrniVseprejeteNeplacaneRacune(trr)) {
			System.out.println("R NP -------------------");
			izpis(r);
		}
	}
	
	public static void vrniVsePrejeteRacune(String trr) throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		for (Racun r:rac.vrniVsePrejeteRacune(trr)) {
			System.out.println("R -------------------");
			izpis(r);
		}
	}
	
	public static void vrniVseIzdaneRacune(String trr) throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		for (Racun r:rac.vrniVseIzdaneRacune(trr)) {
			System.out.println("R -------------------");
			izpis(r);
		}
	}
	
	public static Racun izdajPrazenERacun() throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		Racun r=new Racun();
		
		r.setKrajIzdaje("MB");
		r.setReferenca("00001");
		r.setTrrIzdajatelja("SI56 5687 3248 9151 54");
		r.setTrrPrejemnika("SI56 9702 5595 2810 319");
		r.setVrednost(new BigDecimal(10.00));
		r.setVrednostZddv(new BigDecimal(12.20));
		
		return rac.izdajERacun(r);
	}
	
	public static Racun izdajERacun() throws Exception {
		ERacuniWSDL rac=connectRacuni();
		
		Racun r=new Racun();
		
		r.setKrajIzdaje("MB");
		r.setReferenca("0000");
		r.setTrrIzdajatelja("SI56 5687 3248 9151 54");
		r.setTrrPrejemnika("SI56 9702 5595 2810 319");
		r.setVrednost(new BigDecimal(1.0));
		r.setVrednostZddv(new BigDecimal(1.22));
		
		Postavka p=new Postavka();
		p.setNaziv("Opcija 1");
		p.setKolicina(1);
		p.setEnotaMere("enota");
		p.setCenaNaEnoto(new BigDecimal(0.5));
		p.setVrednostZddv(new BigDecimal(0.61));
		
		Postavka p2=new Postavka();
		p2.setNaziv("Opcija 2");
		p2.setKolicina(2);
		p2.setEnotaMere("enota");
		p2.setCenaNaEnoto(new BigDecimal(0.25));
		p2.setVrednostZddv(new BigDecimal(0.61));
		
		r.getPostavke().add(p);
		r.getPostavke().add(p2);
		
		return rac.izdajERacun(r);
	}
	
	
	public static List<Komitent> vrniVseKomitente() throws Exception {
		KomitentiWSDL kom=connectKomitenti();
		return kom.vrniVseKomitente();
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
	
	public static void izpis(Racun r) {
		if (r==null) return;
		System.out.println(r.getId());
		System.out.println(r.getStevilkaRacuna());
		System.out.println(r.getKrajIzdaje());
		System.out.println(r.getReferenca());
		System.out.println(r.getTrrIzdajatelja());
		System.out.println(r.getTrrPrejemnika());
		System.out.println(r.getDatumIzdaje());
		System.out.println(r.getDatumZapadlosti());
		System.out.println(r.getPostavke());
		System.out.println(r.getVrednost());
		System.out.println(r.getVrednostZddv());
		System.out.println(r.isPlacan()?"PLAÈAN":"NEPLAÈAN");
	}
	
}
