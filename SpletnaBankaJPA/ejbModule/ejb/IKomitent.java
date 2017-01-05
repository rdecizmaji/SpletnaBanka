package ejb;

import java.util.List;

import javax.ejb.Local;

import entitete.Komitent;
import entitete.TransakcijskiRacun;

@Local
public interface IKomitent {
	void shrani(Komitent k);
	void izbrisi(Komitent k);
	Komitent najdi(int id);
	Komitent najdi(String trr);
	
	List<Komitent> vrniVse();
	List<Komitent> vrniVse(boolean loadTrrs);
	List<TransakcijskiRacun> vrniTRRje(int izbraniId);
	List<String> vrniEmaile();
	
	Komitent prijaviKomitenta(String username, String password);
}
