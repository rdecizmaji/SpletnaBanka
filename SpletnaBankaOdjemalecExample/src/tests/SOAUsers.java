package tests;

import java.net.URL;
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
import gen.racuni.ERacuniWSDL;
import gen.racuni.ERacuniWSDLService;

public class SOAUsers {

	public static void main(String[] args) throws Exception{
		KomitentiWSDL kom=connectKomitenti();
		ERacuniWSDL rac=connectRacuni();
		
		String [] users={
			"obu1","obu2","obu3","register1",
			"register2","register3","dars1","dars2",
			"dars3","center1","center2","center3",
			"kmp1","kmp2","kmp3","taksi1",
			"taksi2","taksi3","servis1","servis2",
			"servis3","share1","share2","share3",
			"parking1","parking2","parking3"};

		for (String u:users){
			
			Komitent k1=new Komitent();
			k1.setEmail(u+"@um.si");
			k1.setIme(u);
			k1.setPriimek(" ");
			k1.setGeslo(u);
			Komitent komitent1=kom.dodajKomitenta(k1);
			TransakcijskiRacun trr1=kom.vrniTRR(komitent1.getTransakcijskiRacuni().get(0));
			System.out.println(u+"@um.si\t"+u+"\t"+trr1.getStevilkaTRR());
			
		}

	}
	
	public static KomitentiWSDL connectKomitenti() throws Exception {
//		URL wsdl=new URL("");
		KomitentiWSDL ret=new KomitentiWSDLService(/*wsdl*/).getKomitentiWSDLPort();
        Map<String, Object> req_ctx = ((BindingProvider)ret).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("admin"));
        headers.put("Password", Collections.singletonList("Smart.Road"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        return ret;
	}
	
	public static ERacuniWSDL connectRacuni() throws Exception {
//		URL wsdl=new URL("");
		ERacuniWSDL ret=new ERacuniWSDLService(/*wsdl*/).getERacuniWSDLPort();
        Map<String, Object> req_ctx = ((BindingProvider)ret).getRequestContext();
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("admin"));
        headers.put("Password", Collections.singletonList("Smart.Road"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        return ret;
	}
	
}
