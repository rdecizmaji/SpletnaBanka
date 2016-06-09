package nmb.transakcije;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.jboss.security.annotation.SecurityDomain;

import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx.Binding;

import ejb.ITransakcija;
import ejb.ITransakcijskiRacun;
import entitete.Racun;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;


@WebService
public class TransakcijeWSDL {
	@Resource
	WebServiceContext wsctx;
	@EJB
	ITransakcija itran;
	@EJB
	ITransakcijskiRacun itrr;
	
	public String izvrsiNalog(String trr, String trrp, String namen,BigDecimal znesek ){
		if (doAuthentication()==false)
			return null;
		
		TransakcijskiRacun transakcijskiRacunPlacnika = itrr.najdi(trr);
		TransakcijskiRacun transakcijskiRacunPrejemnika = itrr.najdi(trrp);
		
		//Datum
		Date TrenutniDatum = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(TrenutniDatum);
		//
		
		Transakcija t1=new Transakcija();
		t1.setNaziv(namen);
		t1.setDatum(cal);
		t1.setZnesek(znesek);
		t1.setIdTran(transakcijskiRacunPlacnika);
		
		itran.shrani(t1);
		
		Transakcija t2 = new Transakcija();
		t2.setNaziv(namen);
		t2.setDatum(cal);
		t2.setZnesek(znesek);
		t2.setTRRprejemnika(transakcijskiRacunPrejemnika);
		
		itran.shrani(t2);
		
		return "Uspešno hranjeno";
	}
	
	public List <Transakcija> vrniTransakcije(String trr){
		if (doAuthentication()==false)
			return null;
		
		TransakcijskiRacun transakcijskiRacun = itrr.najdi(trr);
		
		return itrr.vrniTransakcije(transakcijskiRacun);
	}
	
	public String testirajPovezavo(){
		if (doAuthentication()==false)
			return "Napaka v avtorizaciji!";
		
		return "Povezava je uspešna!";
		
	}
	
	private boolean doAuthentication(){
		
		MessageContext mctx = wsctx.getMessageContext();
		
		//get detail from request headers
	        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
	        List userList = (List) http_headers.get("Username");
	        List passList = (List) http_headers.get("Password");

	        String username = "";
	        String password = "";
	        
	        if(userList!=null){
	        	//get username
	        	username = userList.get(0).toString();
	        }
	        	
	        if(passList!=null){
	        	//get password
	        	password = passList.get(0).toString();
	        }
	        	
	        //Should validate username and password with database
	        if (username.equals("floro") && password.equals("flores")){
	        	return true;
	        	
	        }else{
	        	return false;
	        }    
	}

}
