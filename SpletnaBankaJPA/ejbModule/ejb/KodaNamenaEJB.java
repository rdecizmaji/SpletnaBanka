package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entitete.KodaNamena;
import entitete.Postavka;
import entitete.Racun;
import entitete.TransakcijskiRacun;

@Stateless
public class KodaNamenaEJB implements IKodaNamena {

	@PersistenceContext
	EntityManager em;
	
	KodaNamena kodaNamena;
	ArrayList<KodaNamena> kode = new ArrayList<KodaNamena>();
	ArrayList<Racun> racuni = new ArrayList<Racun>();
	
	@Override
	public void shrani(KodaNamena kn) {
		KodaNamena k= em.find(KodaNamena.class, kn.getId());
		if (k != null) {
			em.merge(k);
			} else {
				em.persist(kn);
			}
		System.out.println("Koda namena shranjena.");
	}

	@Override
	public void izbrisi(KodaNamena kn) {
		em.remove(kn);
		System.out.println("Koda namena izbrisana.");
	}

	@Override
	public void edit(KodaNamena kn) {
		em.merge(kn);
		System.out.println("Koda namena spremenjena.");
	}

	@Override
	public KodaNamena najdi(KodaNamena kn) {
		kodaNamena = em.find(KodaNamena.class , kn.getId());
		return kodaNamena;
	}
	@Override
	public KodaNamena najdi(int id) {
		kodaNamena = em.find(KodaNamena.class , id);
		return kodaNamena;
	}

	@Override
	public ArrayList<KodaNamena> vrniVse() {
		Query query = em.createQuery("SELECT kn FROM KodaNamena kn");
		kode = (ArrayList<KodaNamena>) query.getResultList();
		return kode;
	}

	@Override
	public ArrayList<Racun> vrniVseRacune() {
		Query query = em.createQuery("SELECT kn.racuni FROM KodaNamena kn");
		racuni = (ArrayList<Racun>) query.getResultList();
		return racuni;
	}

	@Override
	public void vnesi(KodaNamena kn) {
		List<KodaNamena> kode=new ArrayList<KodaNamena>();
		Query query = em.createQuery("SELECT k FROM KodaNamena k WHERE k.koda=?");
		query.setParameter(1, kn.getKoda());
		kode = (ArrayList<KodaNamena>) query.getResultList();
		if(kode.size()<1){
			em.persist(kn);
		}
		
	}

}
