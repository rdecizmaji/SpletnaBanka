package ejb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.ERacun;
import entitete.Komitent;
import entitete.Racun;
import entitete.TransakcijskiRacun;

@Stateless
public class ERacunEJB implements IERacun{
	@PersistenceContext
	EntityManager manager;
	
	
	@Override
	public void izdajERacun(ERacun r) {
		ERacun rac= manager.find(ERacun.class, r.getId());
		if (rac != null) {
			manager.merge(rac);
			} else {
				manager.persist(r);
			}
	}

	@Override
	public void izbrisi(ERacun r) {
		ERacun eRacun=manager.find(ERacun.class, r.getId());
		if(eRacun!=null){
			eRacun.setIzbrisan(true);
			manager.merge(eRacun);
		}
	}

	@Override
	public void placajRacun(ERacun r) {
		ERacun eRacun=manager.find(ERacun.class, r.getId());
		if(eRacun!=null){
			eRacun.setPlacan(true);
			manager.merge(eRacun);
		}
		
	}

	@Override
	public ERacun najdi(ERacun r) {
		ERacun eracun=manager.find(ERacun.class, r.getId());
		return eracun;
	}

	@Override
	public List<ERacun> vrniVse() {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er");
		list = (ArrayList<ERacun>)query.getResultList();
		return list;
	}

}
