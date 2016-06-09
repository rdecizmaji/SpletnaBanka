import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import nmb.transakcije.TransakcijeWSDL;
import nmb.transakcije.TransakcijeWSDLService;

public class Odjemalec {
	
	private static final String WS_URL = "http://localhost:8080/SpletnaBankaWSDL/TransakcijeWSDL?wsdl";

	public static void main(String[] args) throws MalformedURLException {

		//Kalkulator kalk=new KalkulatorService().getKalkulatorPort();
		
        TransakcijeWSDL hello = new TransakcijeWSDLService().getTransakcijeWSDLPort();
        
        /*******************UserName & Password ******************************/
        Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList("floro"));
        headers.put("Password", Collections.singletonList("flores"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
        /**********************************************************************/
		System.out.println(hello.testirajPovezavo());;
        
        //System.out.println(hello.izvrsiNalog(null, null, null));
	}

}
