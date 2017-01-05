package ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.ERacun;
import entitete.Postavka;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

@Stateless
public class ERacunEJB implements IERacun{
	@PersistenceContext
	EntityManager manager;
	
	@EJB
	private ITransakcijskiRacun itrr;
	
	
	@EJB
	private ITransakcija itran;
	
	@Override
	public void izdajERacun(ERacun r) {
		ERacun rac= manager.find(ERacun.class, r.getId());
		if (rac != null) {
			manager.merge(rac);
		} else {
			
			for (Postavka p:r.getPostavke())
				manager.persist(p);
			
			manager.persist(r);
			
			for (Postavka p:r.getPostavke()){
				p.setIdER(r.getId());
				manager.persist(p);
			}

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
	public void placajRacun(int idRacuna) {
		ERacun eRacun=manager.find(ERacun.class, idRacuna);
		if(eRacun!=null){
			eRacun.setPlacan(true);
			manager.merge(eRacun);
		}
	}
	
	@Override
	public void placajRacun(ERacun r) {
		placajRacun(r.getId());
	}

	@Override
	public void placajERacunCelotno(int idRacuna) {
		ERacun er=najdi(idRacuna);
		if(er==null) return;

		er.setPlacan(true);
		manager.merge(er);
		
		TransakcijskiRacun transakcijskiRacunPlacnika = itrr.najdi(er.getTRRprejmnika());
		TransakcijskiRacun transakcijskiRacunPrejemnika = itrr.najdi((int)er.getIdTr());
		
//		double vrednost=0.0;
		double vrednostddv=0.0;
		for (entitete.Postavka p : er.getPostavke()) {
//			vrednost+=p.getCena_na_enoto().doubleValue() * p.getKolicina();
			vrednostddv+=p.getVrednostZddv().doubleValue();
		}
		
		Transakcija t1=new Transakcija();
		t1.setNaziv("Racun "+er.getStevilkaRacuna());
		t1.setDatum(new GregorianCalendar());
		t1.setZnesek(new BigDecimal(vrednostddv*(-1)));
		t1.setIdTran(transakcijskiRacunPlacnika);
		
		itran.shrani(t1);
		
		transakcijskiRacunPlacnika.getTransakcije().add(t1);
		BigDecimal vrddv=new BigDecimal(0.0);
		for (Transakcija t:transakcijskiRacunPlacnika.getTransakcije()) {
			vrddv=vrddv.add(t.getZnesek());
		}
		transakcijskiRacunPlacnika.setStanje(vrddv);
		manager.persist(transakcijskiRacunPlacnika);
		
		Transakcija t2 = new Transakcija();
		t2.setNaziv("Racun "+er.getStevilkaRacuna());
		t2.setDatum(new GregorianCalendar());
		t2.setZnesek(new BigDecimal(vrednostddv));
		t2.setIdTran(transakcijskiRacunPrejemnika);
		
		itran.shrani(t2);
		
		transakcijskiRacunPrejemnika.getTransakcije().add(t2);
		vrddv=new BigDecimal(0.0);
		for (Transakcija t:transakcijskiRacunPrejemnika.getTransakcije()) {
			vrddv=vrddv.add(t.getZnesek());
		}
		transakcijskiRacunPrejemnika.setStanje(vrddv);
		manager.persist(transakcijskiRacunPrejemnika);
	}
	
	@Override
	public ERacun najdi(int id) {
		ERacun eracun=manager.find(ERacun.class, id);
		
		//postavke
		for (Postavka p:eracun.getPostavke())
			p.getId();
				
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
		
		//postavke
		for (ERacun e:list)
			for (Postavka p:e.getPostavke())
				p.getId();
		
		return list;
	}
	
	@Override
	public List<ERacun> vrniVsePrejete(String trr) {
		List<ERacun> list=new ArrayList<ERacun>();
		Query query = manager.createQuery("SELECT er FROM ERacun er WHERE er.TRRprejmnika=?");
		query.setParameter(1, trr);
		list = (ArrayList<ERacun>)query.getResultList();
		
		//postavke
		for (ERacun e:list)
			for (Postavka p:e.getPostavke())
				p.getId();
		
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
