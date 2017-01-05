package test;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ejb.IKomitent;
import ejb.ITransakcijskiRacun;
import entitete.Komitent;
import entitete.TransakcijskiRacun;

@Stateless
public class LocalTestsBean implements LocalTests {

	@EJB
	IKomitent kom;
	
	@EJB
	ITransakcijskiRacun trrEjb;
	
	private void izpisVseh(){
		System.out.println("------ VSI KOMITENTI ----------");
		for (Komitent k:kom.vrniVse()) {
			System.out.println(k);
		}
	}
	
	private int dodajKom() {
		Komitent novKomitent=new Komitent();
		novKomitent.setEmail("luka.pavlic@um.si");
		novKomitent.setIme("Luka");
		novKomitent.setPriimek("Pavlic");
		novKomitent.setGeslo("mojeGeslo");

		kom.shrani(novKomitent);
		
		return novKomitent.getId();
	}
	
	@Override
	public void komitentTest() {

		int novId=dodajKom();
		
		System.out.println("Najden komitent: "+kom.najdi(novId));
		
		System.out.println("----------------");
		for (TransakcijskiRacun trr:kom.vrniTRRje(novId)) {
			System.out.println(trr);
		}
		
		System.out.println("----------------");
		for (String s:kom.vrniEmaile()) {
			System.out.println(s);
		}
		
		System.out.println("----------------");
		System.out.println("Prijavljen komitent: "+kom.prijaviKomitenta("napacna", "prijava"));
		
		System.out.println("----------------");
		System.out.println("Prijavljen komitent: "+kom.prijaviKomitenta("luka.pavlic@um.si", "napacnoGeslo"));
		
		System.out.println("----------------");
		System.out.println("Prijavljen komitent: "+kom.prijaviKomitenta("luka.pavlic@um.si", "mojeGeslo"));
	}
	
	@Override
	public void trrTest() {
		System.out.println(trrEjb.najdi("SI56 8637 5924 6544 976"));
		System.out.println("----------------");
		System.out.println(trrEjb.najdi("SI56 8637 5924 6544 976").getKomitent());
	}
	
}
