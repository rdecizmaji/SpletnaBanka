package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitete.BancnaKartica;

@Stateless
public class BancnaKarticaEJB implements IBancnaKartica{

	@PersistenceContext
	EntityManager manager;	
	
	@Override
	public void shrani(BancnaKartica bk) {
		manager.persist(bk);
		
	}

}
