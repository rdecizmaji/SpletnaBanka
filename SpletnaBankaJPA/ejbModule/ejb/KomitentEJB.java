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
			kom.setTransakcijskiRacuni(k.getTransakcijskiRacuni());
			manager.merge(kom);
			} else {
				
				k.setIzbrisan(false);
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
				BigDecimal bd=new BigDecimal(0);
				t.setStanje(bd);
				t.setKomitent(k);
				
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
		Komitent komitent=manager.find(Komitent.class, k.getId());
		return komitent;
	}
	@Override
	public List<Komitent> vrniVse() {
		List<Komitent> list=new ArrayList<Komitent>();
		Query query = manager.createQuery("SELECT k FROM Komitent k");
		list = (ArrayList<Komitent>)query.getResultList();
		return list;
	}
	@Override
	public List<TransakcijskiRacun> vrniTRRje(Komitent izbrani) {
		List<TransakcijskiRacun> tra=new ArrayList<TransakcijskiRacun>();
		Query query = manager.createQuery("SELECT t FROM TransakcijskiRacun t WHERE komitent=?");
		query.setParameter(1, izbrani);
		tra = (ArrayList<TransakcijskiRacun>) query.getResultList();
		return tra;
	}

}
