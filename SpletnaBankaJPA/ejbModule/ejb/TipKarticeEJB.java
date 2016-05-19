package ejb;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.TipKartice;

@Stateless
public class TipKarticeEJB implements ITipKartice {

	@PersistenceContext
	EntityManager em;
	
	TipKartice tipKartice;
	ArrayList<TipKartice> tipi = new ArrayList<TipKartice>();
	
	@Override
	public void shrani(TipKartice tk) {
		em.persist(tk);
		System.out.println("Tip kartice shranjen.");
	}

	@Override
	public void izbrisi(TipKartice tk) {
		em.remove(tk);
		System.out.println("Tip kartice izbrisan.");
	}

	@Override
	public void edit(TipKartice tk) {
		em.merge(tk);
		System.out.println("Tip kartice spremenjen");
	}

	@Override
	public TipKartice najdi(TipKartice tk) {
		tipKartice = em.find(TipKartice.class , tk.getId());
		return tipKartice;
	}

	@Override
	public ArrayList<TipKartice> vrniVse() {
		Query query = em.createQuery("SELECT tk FROM TipKartice tk");
		tipi = (ArrayList<TipKartice>) query.getResultList();
		return tipi;
	}

	@Override
	public ArrayList<TipKartice> vrniVseDebetne() {
		Query query = em.createQuery("SELECT tk FROM TipKartice tk WHERE debetna=?");
		query.setParameter(1, true);
		tipi = (ArrayList<TipKartice>) query.getResultList();
		return tipi;
	}

	@Override
	public ArrayList<TipKartice> vrniVseKreditne() {
		Query query = em.createQuery("SELECT tk FROM TipKartice tk WHERE kreditna=?");
		query.setParameter(1, true);
		tipi = (ArrayList<TipKartice>) query.getResultList();
		return tipi;
	}

}
