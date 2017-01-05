package nmb.transakcije;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import ejb.IKomitent;
import ejb.ITransakcijskiRacun;
import nmb.transakcije.vao.Komitent;
import nmb.transakcije.vao.TransakcijskiRacun;

@WebService
public class KomitentiWSDL {

	@EJB
	private IKomitent ikom;
	
	@EJB
	private ITransakcijskiRacun itrr;

	@Resource
	private WebServiceContext wsctx;

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
	
	public Komitent dodajKomitenta(Komitent k) throws Exception {
		login();
		entitete.Komitent kom=k.toEjbKomitent();
		ikom.shrani(kom);
		return new Komitent(kom);
	}

	public Komitent najdiKomitentaPoId(int id) throws Exception {
		login();
		entitete.Komitent ret=ikom.najdi(id);
		if (ret==null) return null;
		return new Komitent(ret);
	}

	public Komitent najdiKomitentaPoTrr(String trr) throws Exception {
		login();
		entitete.Komitent ret=ikom.najdi(trr);
		if (ret==null) return null;
		return new Komitent(ret);
	}

	public List<Komitent> vrniVseKomitente() throws Exception {
		login();
		List<Komitent> ret=new ArrayList<>();
		for (entitete.Komitent k:ikom.vrniVse(true)) {
			ret.add(new Komitent(k));
		}
		return ret;
	}

	public List<TransakcijskiRacun> vrniTRRjeKomitenta(int idKomitenta) throws Exception {
		login();
		List<TransakcijskiRacun> ret=new ArrayList<>();
		for (entitete.TransakcijskiRacun t:ikom.vrniTRRje(idKomitenta)) {
			ret.add(new TransakcijskiRacun(t));
		}
		return ret;
	}
	
	public TransakcijskiRacun vrniTRR(String trr) throws Exception {
		login();
		entitete.TransakcijskiRacun ret=itrr.najdi(trr);
		if (ret==null) return null;
		return new TransakcijskiRacun(ret);
	}

}
