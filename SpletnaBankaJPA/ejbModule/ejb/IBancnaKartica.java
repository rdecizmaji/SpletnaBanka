package ejb;

import javax.ejb.Local;
import entitete.BancnaKartica;

@Local
public interface IBancnaKartica {
	void shrani(BancnaKartica bk);
}
