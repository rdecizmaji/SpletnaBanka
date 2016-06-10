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
		System.out.println("Raèun shranjen!");
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
	@Override
	public List<ERacun> vrniVse(long id) {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er WHERE er.idTr=?");
		query.setParameter(1, id);
		list = (ArrayList<ERacun>)query.getResultList();
		return list;
	}
	public List<ERacun> vrniVseString(String TRR) {
		ArrayList<ERacun> nova = new ArrayList<ERacun>();
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er");
		list = (ArrayList<ERacun>)query.getResultList();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getTRRprejmnika().equals(TRR)) {
				nova.add(list.get(i));
			}
		}
		return nova;
	}
	@Override
	public List<ERacun> vrniVsePlacane(long id) {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er WHERE er.placan=? AND er.idTr=?");
		query.setParameter(1, true);
		query.setParameter(2, id);
		list = (ArrayList<ERacun>)query.getResultList();
		return list;
	}
	@Override
	public List<ERacun> vrniVseNeplacane(long id) {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er WHERE er.placan=? AND er.idTr=?");
		query.setParameter(1, false);
		query.setParameter(2, id);
		list = (ArrayList<ERacun>)query.getResultList();
		return list;
	}

	@Override
	public List<ERacun> vrniVsePlacane(String trr) {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er WHERE er.placan=? AND er.TRRprejmnika=?");
		query.setParameter(1, true);
		query.setParameter(2, trr);
		list = (ArrayList<ERacun>)query.getResultList();
		return list;
	}

	@Override
	public List<ERacun> vrniVseNeplacane(String trr) {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er WHERE er.placan=? AND er.TRRprejmnika=?");
		query.setParameter(1, false);
		query.setParameter(2, trr);
		list = (ArrayList<ERacun>)query.getResultList();
		return list;
	}

}
