package javamailsend;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;



public class sendmails {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//Empfaenger

		int anzahlempfaenger = 2;
		String[] to ={"Felix.liesendahl@web.de", "Felix.liesendahl@uni-jena.de"};

		//Sender
		String from ="unijena123@firemail.de";

		final String user = "unijena123@firemail.de";
		final String pass = "Felix#jena1";

		String host = "smtp.firemail.de";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication (user, pass);
			}
		});

		while(true){
			System.out.println("0 : Email senden.");
			System.out.println("-1 : Beenden");

		try{
			int auswahl = Integer.valueOf(sc.nextLine());
			if (auswahl == -1) {
				break;
			} else if (auswahl == 0) {
			//Nachricht

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			for(int i=0; i < anzahlempfaenger; i++){
				message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to[i]));
				message.setSubject("Test!");

				message.setText("Test erfolgt.");

				//Email senden
				Transport.send(message);

			}
		}


			System.out.println("Die Email wurde erfolgreich versendet!");

		}catch (MessagingException e){
			throw new RuntimeException(e);

		}

		}

		sc.close();
	}

}


