package ejb;
import java.util.List;

import javax.ejb.Local;

import entitete.ERacun;
@Local
public interface IERacun {
	void izdajERacun(ERacun r);
	void izbrisi(ERacun r);
	void placajRacun(ERacun r);
	ERacun najdi(ERacun r);
	
	List<ERacun> vrniVse();
	List<ERacun> vrniVsePlacane(long id);
	List<ERacun> vrniVseNeplacane(long id);
	List<ERacun> vrniVsePlacane(String trr);
	List<ERacun> vrniVseNeplacane(String trr);
	List<ERacun> vrniVse(long id);
	List<ERacun> vrniVseString(String trr);
}
