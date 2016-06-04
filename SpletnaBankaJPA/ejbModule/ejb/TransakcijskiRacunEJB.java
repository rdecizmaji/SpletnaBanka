package ejb;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.BancnaKartica;
import entitete.Komitent;

import entitete.Postavka;

import entitete.Racun;
import entitete.Transakcija;
import entitete.TransakcijskiRacun;

@Stateless
public class TransakcijskiRacunEJB implements ITransakcijskiRacun {
	
	@PersistenceContext
	EntityManager em;
	
	TransakcijskiRacun trr;
	ArrayList<TransakcijskiRacun> transakcijskiRacuni = new ArrayList<TransakcijskiRacun>();
	ArrayList<Racun> racuni = new ArrayList<Racun>();
	ArrayList<Transakcija> transakcije = new ArrayList<Transakcija>();
	ArrayList<BancnaKartica> bancneKartice = new ArrayList<BancnaKartica>();

	@Override
	public void shrani(TransakcijskiRacun trr) {
		TransakcijskiRacun t= em.find(TransakcijskiRacun.class, trr.getId());
		if (t != null) {
			em.merge(t);
			} else {
				em.persist(trr);
			}
		System.out.println("Transakcijski racun shranjen.");
	}

	@Override
	public void zapri(TransakcijskiRacun trr) {
		Query query = em.createQuery("UPDATE trr FROM TransakcijskiRacun trr SET zaprt=? WEHRE id=?");
		query.setParameter(1, true);
		query.setParameter(2, trr.getId());
		System.out.println("Transakcijski racun zaprt.");		
	}

	@Override
	public void edit(TransakcijskiRacun trr) {
		em.merge(trr);
		System.out.println("Transakcijski racun spremenjen.");
	}

	@Override
	public TransakcijskiRacun najdi(TransakcijskiRacun trr) {
		trr = em.find(TransakcijskiRacun.class , trr.getId());
		return trr;
	}

	@Override
	public ArrayList<TransakcijskiRacun> vrniVse() {
		Query query = em.createQuery("SELECT trr FROM TransakcijskiRacun trr");
		transakcijskiRacuni = (ArrayList<TransakcijskiRacun>) query.getResultList();
		return transakcijskiRacuni;
	}

	@Override
	public ArrayList<Racun> vrniRacuneTrrja() {
		Query query = em.createQuery("SELECT trr.racuni FROM TransakcijskiRacun trr");
		racuni = (ArrayList<Racun>) query.getResultList();
		return racuni;
	}

	@Override
	public List<Transakcija> vrniTransakcije(TransakcijskiRacun izbraniTrr) {
		TransakcijskiRacun izb = najdi(izbraniTrr);
		Query query = em.createQuery("SELECT tr FROM Transakcija tr WHERE idTran_id=?");
		query.setParameter(1, izb.getId());
		transakcije = (ArrayList<Transakcija>) query.getResultList();
		return transakcije;
	}
	
	@Override
	public ArrayList<BancnaKartica> vrniBancneKarticeTrrja() {
		Query query = em.createQuery("SELECT trr.bancneKartice FROM TransakcijskiRacun trr");
		bancneKartice = (ArrayList<BancnaKartica>) query.getResultList();
		return bancneKartice;
	}

	@Override
	public TransakcijskiRacun najdi(int id) {
		trr = em.find(TransakcijskiRacun.class , id);
		return trr;
	}

	@Override
	public TransakcijskiRacun najdi(String TRR) {
	Query query = em.createQuery("SELECT trr FROM TransakcijskiRacun trr");
	@SuppressWarnings("unchecked")
	ArrayList<TransakcijskiRacun> trrList = (ArrayList<TransakcijskiRacun>) query.getResultList();
	for(int i = 0; i < trrList.size(); i++) {
		if(trrList.get(i).getStevilkaTRR().equals(TRR)) {
			trr = trrList.get(i);
		}
	}
		return trr;
	}	
}