package dodatniRazredi;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

	private static final String username = "spletnabankanmb@gmail.com";
	private static final String password = "geslogeslo";

	private static Properties props;
	static {
		props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
	}

	public static void posljiRegistracijskiEmail(String email, String stTRR, String uporabnisko_ime, String geslo) throws Exception {

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("spletnabankanmb@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Obvestilo o registraciji");
			message.setText("Spoštovani," + "\n\n Podatki o vaši registraciji:" + "\n\n Številka TRR raèuna: " + stTRR
					+ "\n\n Uporabniško ime: " + uporabnisko_ime + "\n\n Geslo: " + geslo + "\n\n" + "\n\n Lep pozdrav"
					+ "\n\n Vaša spletna banka NMB");

			Transport.send(message);
			
		} catch (MessagingException e) {
			throw e;
		}
	}

}
