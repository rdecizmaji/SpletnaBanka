package ejb;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.BancnaKartica;
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
		trr.setDatumOdprja(Calendar.getInstance());
		em.persist(trr);
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
	public ArrayList<Transakcija> vrniTransakcijeTrrja() {
		Query query = em.createQuery("SELECT trr.transakcije FROM TransakcijskiRacun trr");
		transakcije = (ArrayList<Transakcija>) query.getResultList();
		return transakcije;
	}

	@Override
	public ArrayList<BancnaKartica> vrniBancneKarticeTrrja() {
		Query query = em.createQuery("SELECT trr.bancneKartice FROM TransakcijskiRacun trr");
		bancneKartice = (ArrayList<BancnaKartica>) query.getResultList();
		return bancneKartice;
	}
	
}