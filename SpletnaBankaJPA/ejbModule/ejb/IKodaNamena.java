package ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import entitete.KodaNamena;
import entitete.Racun;

@Local
public interface IKodaNamena {

	void shrani(KodaNamena kn);
	void izbrisi(KodaNamena kn);
	void edit(KodaNamena kn);
	KodaNamena najdi(KodaNamena kn);
	
	ArrayList<KodaNamena> vrniVse();
	ArrayList<Racun> vrniVseRacune();
}
