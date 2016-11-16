package dodatniRazredi;
import java.util.Random;

public class TrrGenerator {
	
	static Random r=new Random();
	
	public String generirajIBAN(String drzava) {
		//SI56 6022 6533 1007 129
		//SI56 1520 8294 6423 596
		long i=System.nanoTime();

		String a=(i % 1000L)+"";
		String b=(i % 10000000L / 1000L)+"";
		String c=(i % 100000000000L / 10000000L)+"";
		String d=(r.nextInt(9000)+1000)+"";
		  
		String iban="SI56 "+b+" "+c+" "+d+" "+a;
		       
		//TODO preveri, da še ni duplikata v bazi!
		
		
//		String iban = new String();
//		//Generira st. drzave
//		switch (drzava) {
//		case "Slovenija": iban = "SI56"; break;
//		default: iban = "SI56"; break;
//		}
//		//Generira st. trr.
//		Random rnd = new Random();
//		for (int i = 0; iban.length() < 23; i++) {
//			if (i % 4 == 0)
//				iban += " ";
//			int n = rnd.nextInt() % 10;
//			if (n < 0) {
//				n *= -1;
//			}
//			iban += n;
//		}
//
		return iban;
	}
}
