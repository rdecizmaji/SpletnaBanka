package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

import entitete.BancnaKartica;
import entitete.Komitent;
import entitete.Racun;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

@Local
public interface ITransakcijskiRacun {
	
	void shrani(TransakcijskiRacun trr);
	void zapri(TransakcijskiRacun trr);
	void edit(TransakcijskiRacun trr);
	TransakcijskiRacun najdi(TransakcijskiRacun trr);
	TransakcijskiRacun najdi(int id);
	TransakcijskiRacun najdi(String stevilkaTRR);
	
	ArrayList<TransakcijskiRacun> vrniVse();
	ArrayList<Racun> vrniRacuneTrrja();
	ArrayList<BancnaKartica> vrniBancneKarticeTrrja();
	List<Transakcija> vrniTransakcije(TransakcijskiRacun izbrani);
	List<TransakcijskiRacun> vrniTRR(int kom);
	ArrayList<Racun> vrniIzdaneRacuneTrrja(TransakcijskiRacun trr);
	ArrayList<Racun> vrniPrejeteRacuneTrrja(TransakcijskiRacun trr);
	Komitent vrniKomitenta(String trr);
}
