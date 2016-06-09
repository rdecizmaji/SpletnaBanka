package ejb;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.Komitent;
import entitete.Racun;
import entitete.TransakcijskiRacun;

@Stateless
public class RacunEJB implements IRacun {

	@PersistenceContext
	EntityManager em;
	
	ArrayList<Racun> racuni = new ArrayList<Racun>();
	Racun racun;
	
	@Override
	public void izdajRacun(Racun r) {
		r.setDatumIzdaje(Calendar.getInstance());
		r.setIzbrisan(false);
		em.persist(r);
		System.out.println("Racun izdan.");
	}
	
	@Override
	public void izbrisi(Racun r) {
		em.remove(najdi(r));
		System.out.println("Racun izbrisan.");
	}
	
	@Override
	public void edit(Racun r) {
		em.merge(r);
		System.out.println("Racun spremenjen.");
	}
	
	@Override
	public Racun najdi(Racun r) {
		racun = em.find(Racun.class , r.getId());
		return racun;
	}

	@Override
	public ArrayList<Racun> vrniVse() {
		Query query = em.createQuery("SELECT r FROM Racun r AND izbrisan=false");
		racuni = (ArrayList<Racun>) query.getResultList();
		return racuni;
	}

	@Override
	public void placajRacun(Racun r) {
		Query query = em.createQuery("UPDATE r FROM Racun r SET placan=? WEHRE id=?");
		query.setParameter(1, true);
		query.setParameter(2, r.getId());
		System.out.println("Racun je placan.");
	}

	@Override
	public ArrayList<Racun> vrniZgodovinoRacunov(TransakcijskiRacun trr) {
		Query query = em.createQuery("SELECT r FROM Racun r WHERE TransakcijskiRacun=?");
		query.setParameter(1, trr.getId());
		racuni = (ArrayList<Racun>) query.getResultList();
		return racuni;
	}
	
	@Override
	public ArrayList<Racun> vrniPlacaneRacune(TransakcijskiRacun trr) {
		Query query = em.createQuery("SELECT r FROM Racun r WHERE TransakcijskiRacun=? AND placan=true AND izbrisan=false");
		query.setParameter(1, trr.getId());
		racuni = (ArrayList<Racun>) query.getResultList();
		return racuni;
	}
	
	@Override
	public ArrayList<Racun> vrniNeplacaneRacune(TransakcijskiRacun trr) {
		Query query = em.createQuery("SELECT r FROM Racun r WHERE TransakcijskiRacun=? AND placan=false and izbrisan=false");
		query.setParameter(1, trr.getId());
		racuni = (ArrayList<Racun>) query.getResultList();
		return racuni;
	}
}
