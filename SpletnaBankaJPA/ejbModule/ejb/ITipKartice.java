package ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import entitete.TipKartice;

@Local
public interface ITipKartice {
	

	void shrani(TipKartice tk);
	void izbrisi(TipKartice tk);
	void edit(TipKartice tk);
	TipKartice najdi(TipKartice tk);
	
	ArrayList<TipKartice> vrniVse();
	ArrayList<TipKartice> vrniVseDebetne();
	ArrayList<TipKartice> vrniVseKreditne();
}
