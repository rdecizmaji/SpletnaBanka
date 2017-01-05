package nmb.transakcije.vao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entitete.ERacun;

public class Racun implements Serializable {

	private static final long serialVersionUID = 5420393832712929345L;

	private int id;
	private long stevilkaRacuna;
	private String referenca;
	private String krajIzdaje;
	private Calendar datumIzdaje;
	private Calendar datumZapadlosti;
	private String trrIzdajatelja;
	private String trrPrejemnika;
	private List<Postavka> postavke=new ArrayList<>();
	private boolean placan=false;
	private BigDecimal vrednost;
	private BigDecimal vrednostZddv;
	
	public Racun() {
	}
	
	public Racun(ERacun r , String trrIzdajatelja) {
		if (r==null) return;
		setId(r.getId());
		setStevilkaRacuna(r.getStevilkaRacuna());
		setReferenca(r.getReferenca());
		setKrajIzdaje(r.getKrajIzdaje());
		setDatumIzdaje(r.getDatumIzdaje());
		setDatumZapadlosti(r.getDatumZapadlosti());
		setTrrPrejemnika(r.getTRRprejmnika());
		setTrrIzdajatelja(trrIzdajatelja);
		setPlacan(r.isPlacan());
		double vrednost=0.0;
		double vrednostddv=0.0;
		for (entitete.Postavka p : r.getPostavke()) {
			getPostavke().add(new Postavka(p));
			vrednost+=p.getCena_na_enoto().doubleValue() * p.getKolicina();
			vrednostddv+=p.getVrednostZddv().doubleValue();
		}
		setVrednost(new BigDecimal(vrednost));
		setVrednostZddv(new BigDecimal(vrednostddv));
	}
	
	
	public ERacun toEjbRacun(int idTrrIzdajatelj) {
		ERacun ret=new ERacun();
		
		ret.setStevilkaRacuna(stevilkaRacuna);
		ret.setId(id);
		ret.setReferenca(referenca);
		ret.setKrajIzdaje(krajIzdaje);
		ret.setDatumIzdaje(datumIzdaje);
		ret.setDatumZapadlosti(datumZapadlosti);
		ret.setTRRprejmnika(trrPrejemnika);
		ret.setIdTr(idTrrIzdajatelj);
		
		if (postavke.size()==0) {
			Postavka p=new Postavka();
			p.setNaziv("Racun");
			p.setKolicina(1);
			p.setEnota_mere("e");
			p.setCena_na_enoto(vrednost);
			p.setVrednostZddv(vrednostZddv);
			postavke.add(p);
		}
		
		for (Postavka p: postavke){
			ret.getPostavke().add(p.toEJBPostavka());
		}
		ret.setPlacan(placan);
		
		return ret;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getStevilkaRacuna() {
		return stevilkaRacuna;
	}
	public void setStevilkaRacuna(long stevilkaRacuna) {
		this.stevilkaRacuna = stevilkaRacuna;
	}
	public String getKrajIzdaje() {
		return krajIzdaje;
	}
	public void setKrajIzdaje(String krajIzdaje) {
		this.krajIzdaje = krajIzdaje;
	}
	public String getReferenca() {
		return referenca;
	}
	public void setReferenca(String referenca) {
		this.referenca = referenca;
	}
	public Calendar getDatumIzdaje() {
		return datumIzdaje;
	}
	public void setDatumIzdaje(Calendar datumIzdaje) {
		this.datumIzdaje = datumIzdaje;
	}
	public Calendar getDatumZapadlosti() {
		return datumZapadlosti;
	}
	public void setDatumZapadlosti(Calendar datumZapadlosti) {
		this.datumZapadlosti = datumZapadlosti;
	}
	public String getTrrIzdajatelja() {
		return trrIzdajatelja;
	}
	public void setTrrIzdajatelja(String trrIzdajatelja) {
		this.trrIzdajatelja = trrIzdajatelja;
	}
	public String getTrrPrejemnika() {
		return trrPrejemnika;
	}
	public void setTrrPrejemnika(String trrPrejemnika) {
		this.trrPrejemnika = trrPrejemnika;
	}
	public List<Postavka> getPostavke() {
		return postavke;
	}
	public void setPostavke(List<Postavka> postavke) {
		this.postavke = postavke;
	}
	public boolean isPlacan() {
		return placan;
	}
	public void setPlacan(boolean placan) {
		this.placan = placan;
	}
	public BigDecimal getVrednost() {
		return vrednost;
	}
	public void setVrednost(BigDecimal vrednost) {
		this.vrednost = vrednost;
	}
	public BigDecimal getVrednostZddv() {
		return vrednostZddv;
	}
	public void setVrednostZddv(BigDecimal vrednostZddv) {
		this.vrednostZddv = vrednostZddv;
	}

}
