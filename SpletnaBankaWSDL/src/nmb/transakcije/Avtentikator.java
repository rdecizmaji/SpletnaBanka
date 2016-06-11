package nmb.transakcije;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import ejb.IKomitent;
import ejb.ITransakcijskiRacun;
import entitete.Komitent;

public class Avtentikator {
	
	@EJB
	private IKomitent ikom;
	@EJB
	private ITransakcijskiRacun itrr;
	
	boolean doAuthentication(WebServiceContext wsctx, Komitent k,String trr) {

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
		
		
		String passwordmd5=new MD5koder().kodiraj(password);
		// Should validate username and password with database
		
		if (username.equals(k.getUporabniskoIme()) && passwordmd5.equals(k.getGeslo())) {
			return true;

		} else {
			return false;
		}
	}
}
