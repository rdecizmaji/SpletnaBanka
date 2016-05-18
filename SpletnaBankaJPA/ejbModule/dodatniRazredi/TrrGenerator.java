package dodatniRazredi;
import java.util.Random;

public class TrrGenerator {
	public String generirajIBAN(String drzava) {
		String iban = new String();

		//Generira st. drzave
		switch (drzava) {
		case "Slovenija":
			iban = "SI56";
			break;
		}

		//Generira st. trr.
		Random rnd = new Random();
		for (int i = 0; iban.length() < 23; i++) {
			if (i % 4 == 0)
				iban += " ";

			int n = rnd.nextInt() % 10;
			if (n < 0) {
				n *= -1;
			}
			iban += n;
		}
		

		return iban;
	}
}
