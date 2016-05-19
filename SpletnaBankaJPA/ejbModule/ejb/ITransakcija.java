package ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import entitete.Transakcija;

@Local
public interface ITransakcija {

	void shrani(Transakcija t);
	void izbrisi(Transakcija t);
	void edit(Transakcija t);
	Transakcija najdi(Transakcija t);
	
	ArrayList<Transakcija> vrniVse();
}
