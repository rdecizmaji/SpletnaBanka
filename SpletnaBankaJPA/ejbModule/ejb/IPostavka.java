package ejb;

import java.util.List;

import javax.ejb.Local;

import entitete.Postavka;
@Local
public interface IPostavka {
	void shrani(Postavka p);
	void izbrisi(Postavka p);
	Postavka najdi(Postavka p);
	
	List<Postavka> vrniVse();
}
