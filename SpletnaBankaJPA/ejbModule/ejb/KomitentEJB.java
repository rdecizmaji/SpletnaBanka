package ejb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dodatniRazredi.Email;
import dodatniRazredi.TrrGenerator;
import entitete.BancnaKartica;
import entitete.Komitent;
import entitete.Racun;
import entitete.TipKartice;
import entitete.TransakcijskiRacun;

@Stateless
public class KomitentEJB implements IKomitent{
@PersistenceContext
EntityManager manager;

@EJB
ITransakcijskiRacun tranR;

@EJB
ITipKartice tip;

@EJB
IBancnaKartica banKar;
	
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
			//kom.setTransakcijskiRacuni(k.getTransakcijskiRacuni());
			manager.merge(kom);
			} else {
				k.setIzbrisan(false);
				k.setVloga("user");
				//datum vnosa komitenta
				Calendar danasnjiDat = Calendar.getInstance();
				k.setDatumVnosa(danasnjiDat);
				
				//kreiraj geslo
				k.setUporabniskoIme(k.getEmail());
				String geslo=k.getIme()+k.getPriimek()+"!";
				String kodiranoGeslo=kodiraj(geslo);
				k.setGeslo(kodiranoGeslo);
				
				//kreiranje trr
				List<TransakcijskiRacun> tr=new ArrayList<TransakcijskiRacun>();
				TransakcijskiRacun t=new TransakcijskiRacun();
				TrrGenerator tg=new TrrGenerator();
				String trr=tg.generirajIBAN(k.getDrzava());
				t.setStevilkaTRR(trr);
				t.setZaprt(false);
				t.setStanje(new BigDecimal(0));
				t.setKomitent(k);
				t.setDatumOdprtja(Calendar.getInstance());
				
					//kreiranje kartice
					List<BancnaKartica> bancneKartice=new ArrayList<BancnaKartica>();
						BancnaKartica bk=new BancnaKartica();
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
					
						//Tip kartice
						TipKartice tk=new TipKartice();
						tk.setKartice(bancneKartice);
						tk.setKreditna(true);
						tk.setDebetna(false);
						tk.setNazivTipa("Mastercard");
						tip.shrani(tk);
						
					bk.setIdTk(tk);
					banKar.shrani(bk);
					
				
				t.setBancneKartice(bancneKartice);
				tranR.shrani(t);
				
				tr.add(t);
				k.setTransakcijskiRacuni(tr);
			    manager.persist(k);
			    Email em=new Email();
			    em.setEmail(k.getEmail());
			    em.setGeslo(geslo);
			    em.setStTRR(t.getStevilkaTRR());
			    em.setUporabnisko_ime(k.getUporabniskoIme());
			    em.akcija();
			}
	}
	//zakodiraj geslo
	public String kodiraj(String md5) {
		   try {
		        java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		    }
		    return null;
		}

	@Override
	public void izbrisi(Komitent k) {
		Komitent komitent=manager.find(Komitent.class, k.getId());
		if(komitent!=null){
			komitent.setIzbrisan(true);
			manager.merge(komitent);
		}
	}

	@Override
	public Komitent najdi(Komitent k) {
		if(k!=null){
			Komitent komitent=manager.find(Komitent.class, k.getId());
			return komitent;
		}
		else{
			return null;
		}
	}
	
	@Override
	public Komitent getSession(String username, String password) {
		if(username!=null){
			Query query = manager.createQuery("SELECT k FROM Komitent k WHERE uporabniskoime='"+username+"'");
			Komitent k = (Komitent)query.getSingleResult();
			return k;
		}
		else{
			return null;
		}
	}
	
	@Override
	public List<Komitent> vrniVse() {
		List<Komitent> list=new ArrayList<Komitent>();
		Query query = manager.createQuery("SELECT k FROM Komitent k WHERE k.vloga=?");
		query.setParameter(1, "user");
		list = (ArrayList<Komitent>)query.getResultList();
		return list;
	}
	@Override
	public List<TransakcijskiRacun> vrniTRRje(Komitent izbrani) {
		Komitent izb=najdi(izbrani);
		List<TransakcijskiRacun> tra=new ArrayList<TransakcijskiRacun>();
		Query query = manager.createQuery("SELECT t FROM TransakcijskiRacun t WHERE komitent=?");
		query.setParameter(1, izb);
		tra = (ArrayList<TransakcijskiRacun>) query.getResultList();
		return tra;
	}
	@Override
	 public List<String> vrniEmaile(){
		 List<String> list=new ArrayList<String>();
			Query query = manager.createQuery("SELECT k.email FROM Komitent k");
			list = (ArrayList<String>)query.getResultList();
			return list;
	 }
}
