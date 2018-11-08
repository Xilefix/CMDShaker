
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Meilenstein1 {

	public static void main(String args[]) {
		System.out.println("Geben Sie die Serveradresse POP3 ein:");
		Scanner sc = new Scanner(System.in); // eingabe wird gescannt und in sc
												// gespeichert
		String url = sc.nextLine(); // einlesen der adresse POP3
		System.out.println("Geben Sie am besten direkt den Port ein:");
		int port = Integer.valueOf(sc.nextLine()); // string in Zahl umwandeln
		System.out.println("Wir verbinden uns nun mit dem Server " + url + ":"+ port + ". Bitte warten. :)");
		try {
			Socket server = new Socket(url, port);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					server.getInputStream())); // lesen nachricht vom server
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					server.getOutputStream())); // schreiben nachricht an server

			String antwort = reader.readLine();
			if (antwort.startsWith("+OK")) {
				System.out.println("Geben Sie Ihren User Namen ein:");
				String user = sc.nextLine();
				writer.write("USER " + user + "\n");
				writer.flush();

				antwort = reader.readLine();
				if (antwort.startsWith("+OK")) {
					System.out.println("Geben Sie Ihr Passwort ein:");
					String pass = sc.nextLine();
					writer.write("PASS " + pass + "\n");
					writer.flush();

					antwort = reader.readLine();
					if (antwort.startsWith("+OK")) {
						writer.write("STAT\n");
						writer.flush();

						antwort = reader.readLine();
						if (antwort.startsWith("+OK")) {
							String[] split = antwort.split(" ");

							int anzahlEmails = Integer.valueOf(split[1]);
							System.out.println("Sie haben " + anzahlEmails
									+ " Email(s) erhalten.\n");

							for (int i = 1; i <= anzahlEmails; i++) {		//Wir gehen alle emails im Postfach durch und lesen ein
								writer.write("RETR " + i + "\n");
								writer.flush();

								ArrayList<String> zeilen = new ArrayList<>(); 	//wir erstellen liste

								while (true) {						//Email zeilenweise durchlesen bis zum  Punkt, dann abrechnen
									antwort = reader.readLine();	//speichern zeilen in liste
									if (antwort.equals("."))
										break;
									zeilen.add(antwort);
								}

								Email email = new Email(i, zeilen);	//speichern Liste an Zeilen in neue Email

							}

						} else {
							System.out.println("Wir haben einen Fehler beim Einlesen der Emails.");
						}

					} else {
						System.out.println("Wir haben ein Problem mit Ihrem Benutzernamen oder Ihrem Passwort. Ändern Sie das Bitte!");
					}

				} else {
					System.out.println("Wir haben ein Problem mit Ihrem Benutzernamen. Ändern Sie das Bitte!");
				}
			} else {
				System.out.println("Die Verbindung ist fehlgeschlagen. Das tut uns Leid.");
			}
			server.close();
		} catch (IOException e) { // Fehler fangen, falls falsche Eingabe oder
									// Server unereichbar
			e.printStackTrace();
			System.out.println("Sorry, Sie haben sich da wohl vertippt oder der Server schläft. Bitte versuchen Sie es erneut:");
		}

		sc.close(); // Scanner schließen
	}
}

class Email {
	int nummer;
	ArrayList<String> zeilen;
	String subject, from;

	public Email(int nummer, ArrayList<String> zeilen) {
		this.nummer = nummer;
		this.zeilen = zeilen;

		for (int i = 0; i < zeilen.size(); i++) {
			String zeile = zeilen.get(i);
			if (zeile.startsWith("Subject: ")) {
				subject = zeile.substring(9);
			}
			if (zeile.startsWith("From: ")) {
				from = zeile.substring(6);
			}
		}
	}
}


