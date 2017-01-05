package ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dodatniRazredi.Email;
import dodatniRazredi.MD5;
import dodatniRazredi.TrrGenerator;
import entitete.BancnaKartica;
import entitete.Komitent;
import entitete.TipKartice;
import entitete.TransakcijskiRacun;

@Stateless
public class KomitentEJB implements IKomitent /*, IKomitentRemote*/ {
	@PersistenceContext
	EntityManager manager;

	@EJB
	ITransakcijskiRacun tranR;

	@EJB
	ITipKartice tip;

	// @EJB
	// IBancnaKartica banKar;

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
			kom.setDavcnaSt(k.getDavcnaSt());
			kom.setEmso(k.getEmso());
			// kom.setTransakcijskiRacuni(k.getTransakcijskiRacuni());
			manager.merge(kom);
		} else {
			k.setIzbrisan(false);
			k.setVloga("user");
			// datum vnosa komitenta
			Calendar danasnjiDat = Calendar.getInstance();
			k.setDatumVnosa(danasnjiDat);

			// kreiraj geslo
			k.setUporabniskoIme(k.getEmail());
			String geslo = k.getGeslo();
			if (geslo==null) geslo= k.getIme() + k.getPriimek() + "!";
			String kodiranoGeslo = MD5.kodirajMD5(geslo);
			k.setGeslo(kodiranoGeslo);

			// kreiranje trr
			List<TransakcijskiRacun> tr = new ArrayList<TransakcijskiRacun>();
			TransakcijskiRacun t = new TransakcijskiRacun();
			TrrGenerator tg = new TrrGenerator();
			String trr = tg.generirajIBAN(/* k.getDrzava() */);
			t.setStevilkaTRR(trr);
			t.setZaprt(false);
			t.setStanje(new BigDecimal(0));
			t.setKomitent(k);
			t.setDatumOdprtja(Calendar.getInstance());

			// kreiranje kartice
			Set<BancnaKartica> bancneKartice = new HashSet<BancnaKartica>();
			BancnaKartica bk = new BancnaKartica();
			bk.setStKartice(123456);
			bk.setPinKoda(2707);
			bk.setVeljavana(true);
			Calendar datumPoteka = Calendar.getInstance();
			datumPoteka.set(2016, 6, 15);
			bk.setDatumObracuna(datumPoteka);
			Calendar datumVeljavnosti = Calendar.getInstance();
			datumVeljavnosti.set(2018, 6, 15);
			bk.setDatumVeljavnosti(datumVeljavnosti);
			bk.setIdTr(t);
			bancneKartice.add(bk);

			// Tip kartice
			TipKartice tk = new TipKartice();
			tk.setKartice(bancneKartice);
			tk.setKreditna(true);
			tk.setDebetna(false);
			tk.setNazivTipa("Mastercard");
			tip.shrani(tk);

			bk.setIdTk(tk);

			manager.persist(bk);
			// banKar.shrani(bk);

			t.setBancneKartice(bancneKartice);
			tranR.shrani(t);

			tr.add(t);
			k.setTransakcijskiRacuni(tr);
			manager.persist(k);
			try {
				Email.posljiRegistracijskiEmail(k.getEmail(), t.getStevilkaTRR(), k.getUporabniskoIme(), geslo);
			} catch (Exception e) {
				System.out.println("Mail ni bil poslan: " + e.getMessage());
				System.out.println("Email: " + k.getEmail());
				System.out.println("Uporabniško ime: " + k.getUporabniskoIme());
				System.out.println("Geslo: " + geslo);
				System.out.println("trr: " + t.getStevilkaTRR());
			}

		}
	}

	@Override
	public void izbrisi(Komitent k) {
		Komitent komitent = manager.find(Komitent.class, k.getId());
		if (komitent != null) {
			komitent.setIzbrisan(true);
			manager.merge(komitent);
		}
	}

	@Override
	public Komitent najdi(int id) {
		Komitent komitent = manager.find(Komitent.class, id);
		if (komitent==null) return null;
		//load trrs
		for (TransakcijskiRacun trr:komitent.getTransakcijskiRacuni())
			trr.getStevilkaTRR();
		return komitent;
	}

	@Override
	public Komitent prijaviKomitenta(String username, String password) {
		if (username != null) {
			Query query = manager.createQuery("SELECT k FROM Komitent k WHERE uporabniskoime='" + username + "' AND geslo='"+MD5.kodirajMD5(password)+"'");
			
			Komitent k = null;
			for (Komitent kom :(List<Komitent>)query.getResultList()) {
				k=kom;
			}
//			(Komitent) query.getSingleResult();
			return k;
		} else {
			return null;
		}
	}

	@Override
	public List<Komitent> vrniVse() {
		return vrniVse(false);
	}
	
	@Override
	public List<Komitent> vrniVse(boolean loadTrrs) {
		Query query = manager.createQuery("SELECT k FROM Komitent k WHERE k.vloga=?");
		query.setParameter(1, "user");
		ArrayList<Komitent> ret=(ArrayList<Komitent>)query.getResultList();
		
		//lazy load trrs...
		if (loadTrrs) {
			for (Komitent k: ret) {
				for (TransakcijskiRacun trr:k.getTransakcijskiRacuni())
					trr.getStevilkaTRR();
			}
		}
		
		return ret;
	}

	@Override
	public List<TransakcijskiRacun> vrniTRRje(int izbraniId) {
		Komitent izb = najdi(izbraniId);
		List<TransakcijskiRacun> tra = new ArrayList<TransakcijskiRacun>();
		Query query = manager.createQuery("SELECT t FROM TransakcijskiRacun t WHERE komitent=?");
		query.setParameter(1, izb);
		tra = (ArrayList<TransakcijskiRacun>) query.getResultList();
		return tra;
	}
	
	@Override
	public Komitent najdi(String trr) {
		TransakcijskiRacun tr=tranR.najdi(trr);
		if (tr==null) return null;
		
		Komitent ret=tr.getKomitent();
		
		if (ret==null) return null;
		
		//load trrs
		for (TransakcijskiRacun trr2:ret.getTransakcijskiRacuni())
			trr2.getStevilkaTRR();
		
		return ret;
	}

	@Override
	public List<String> vrniEmaile() {
		List<String> list = new ArrayList<String>();
		Query query = manager.createQuery("SELECT k.email FROM Komitent k");
		list = (ArrayList<String>) query.getResultList();
		return list;
	}
}
