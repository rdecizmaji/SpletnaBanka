package ejb;

import java.util.List;

import javax.ejb.Local;

import entitete.Komitent;

@Local
public interface IKomitent {
	void shrani(Komitent k);
	void izbrisi(Komitent k);
	Komitent najdi(Komitent k);
	List<Komitent> vrniVse();
}