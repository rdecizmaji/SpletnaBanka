package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entitete.Komitent;
import entitete.TransakcijskiRacun;

public class KomitentEJB implements IKomitent{
@PersistenceContext
EntityManager manager;
	
	@Override
	public void shrani(Komitent k) {
		
		Komitent kom = manager.find(Komitent.class, k.getId());
		if (kom != null) {
			kom.setIme(k.getIme());
			kom.setPriimek(k.getPriimek());
			kom.setNaslov(k.getNaslov());
			kom.setPosta(k.getPosta());
			kom.setEmail(k.getEmail());
			kom.setDatum(k.getDatum());
			kom.setUporabniskoIme(k.getUporabniskoIme());
			kom.setGeslo(k.getGeslo());
			kom.setTransakcijskiRacuni(k.getTransakcijskiRacuni());
			manager.merge(kom);
			} else {
				//kreiranje trr
				List<TransakcijskiRacun> tr=new ArrayList<TransakcijskiRacun>();
				TransakcijskiRacun t=new TransakcijskiRacun();
				tr.add(t);
				k.setTransakcijskiRacuni(tr);
				//kreiraj geslo
				
			    manager.persist(k);
			}
	}

	@Override
	public void izbrisi(Komitent k) {
		Komitent komitent=manager.find(Komitent.class, k.getId());
		if(komitent!=null){
			manager.remove(komitent);
		}
	}

	@Override
	public Komitent najdi(Komitent k) {
		Komitent komitent=manager.find(Komitent.class, k.getId());
		return komitent;
	}

}
