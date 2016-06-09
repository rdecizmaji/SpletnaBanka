package nmb.transakcije;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

@WebService
public class eRacuniWSDL {
	@Resource
	WebServiceContext wsctx;

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
		if (username.equals("mkyong") && password.equals("password")) {
			return true;

		} else {
			return false;
		}
	}
}
