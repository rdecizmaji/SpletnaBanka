package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.ERacun;
import entitete.Postavka;

@Stateless
public class PostavkaEJB implements IPostavka{
	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	public void shrani(Postavka p) {
		manager.persist(p);
		System.out.println("Postavka shranjena");
	}

	@Override
	public void izbrisi(Postavka p) {
		Postavka postavka=manager.find(Postavka.class, p.getId());
		if(postavka!=null){
			postavka.setIzbrisan(true);
			manager.merge(postavka);
		}
		
	}

	@Override
	public Postavka najdi(Postavka p) {
		Postavka postavka=manager.find(Postavka.class, p.getId());
		return postavka;
	}

	@Override
	public List<Postavka> vrniVse() {
		List<Postavka> list=new ArrayList<Postavka>();
		Query query = manager.createQuery("SELECT p FROM Postavka p");
		list = (ArrayList<Postavka>)query.getResultList();
		return list;
	}

	@Override
	public List<Postavka> vrniZneske(long id) {
		List<Postavka> list=new ArrayList<Postavka>();
		Query query = manager.createQuery("SELECT p FROM Postavka p WHERE p.idER=?");
		query.setParameter(1, id);
		list = (ArrayList<Postavka>)query.getResultList();
		return list;
	}

}
