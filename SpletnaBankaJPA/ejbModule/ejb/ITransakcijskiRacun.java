package ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import entitete.BancnaKartica;
import entitete.Racun;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

@Local
public interface ITransakcijskiRacun {
	
	void shrani(TransakcijskiRacun trr);
	void zapri(TransakcijskiRacun trr);
	void edit(TransakcijskiRacun trr);
	TransakcijskiRacun najdi(TransakcijskiRacun trr);
	
	ArrayList<TransakcijskiRacun> vrniVse();
	ArrayList<Racun> vrniRacuneTrrja();
	ArrayList<Transakcija> vrniTransakcijeTrrja();
	ArrayList<BancnaKartica> vrniBancneKarticeTrrja();
}
