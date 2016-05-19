package ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import entitete.TransakcijskiRacun;
import entitete.Racun;

@Local
public interface IRacun {
	
	void izdajRacun(Racun r);
	void izbrisi(Racun r);
	void edit(Racun r);
	void placajRacun(Racun r);
	Racun najdi(Racun r);
	
	ArrayList<Racun> vrniVse();
	ArrayList<Racun> vrniZgodovinoRacunov(TransakcijskiRacun trr);
	ArrayList<Racun> vrniPlacaneRacune(TransakcijskiRacun trr);
	ArrayList<Racun> vrniNeplacaneRacune(TransakcijskiRacun trr);
}
