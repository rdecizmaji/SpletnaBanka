package ejb;

import java.util.ArrayList;
import java.util.Calendar;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.Transakcija;

@Stateless
public class TransakcijaEJB implements ITransakcija {

	@PersistenceContext
	EntityManager em;
	
	Transakcija transakcija;
	ArrayList<Transakcija> transakcije = new ArrayList<Transakcija>();
	
	@Override
	public void shrani(Transakcija t) {
		t.setDatum(Calendar.getInstance());
		em.persist(t);
		System.out.println("Transakcija shranjena.");
	}

	@Override
	public void izbrisi(Transakcija t) {
		em.remove(t);
		System.out.println("Transakcija izbrisana-");
	}

	@Override
	public void edit(Transakcija t) {
		em.merge(t);
		System.out.println("Transakcija spremenjena.");
	}

	@Override
	public Transakcija najdi(Transakcija t) {
		transakcija = em.find(Transakcija.class , t.getId());
		return transakcija;
	}

	@Override
	public ArrayList<Transakcija> vrniVse() {
		Query query = em.createQuery("SELECT t FROM Transakcija t");
		transakcije = (ArrayList<Transakcija>) query.getResultList();
		return transakcije;
	}

}
