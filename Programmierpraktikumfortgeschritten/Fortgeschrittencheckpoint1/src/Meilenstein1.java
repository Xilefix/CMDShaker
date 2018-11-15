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
		System.out.println("Geben Sie bitte jetzt den Port ein:");
		int port = Integer.valueOf(sc.nextLine()); // string in Zahl umwandeln
		System.out.println("Wir verbinden uns nun mit dem Server. " + url + ":"
				+ port + ". Bitte warten Sie solange.");
		try {
			Socket server = new Socket(url, port);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					server.getInputStream())); // lesen nachricht vom server
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					server.getOutputStream())); // schreiben nachricht an server

			ArrayList<Email> email = new ArrayList<>();
			String antwort = reader.readLine();
			if (antwort.startsWith("+OK")) {
				System.out.println("Geben Sie Ihren Ihre Emailadresse ein:");
				String user = sc.nextLine();
				writer.write("USER " + user + "\n");
				writer.flush();

				antwort = reader.readLine();
				if (antwort.startsWith("+OK")) {
					System.out.println("Geben Sie bitte Ihr Passwort ein:");
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

							for (int i = 1; i <= anzahlEmails; i++) { // Wir gehen alle Emails im Postfach zu und lesen ein							
								writer.write("RETR " + i + "\n");
								writer.flush();

								ArrayList<String> zeilen = new ArrayList<>(); // wir erstellen liste

								while (true) { // Email zeilenweise durchlesen bis Punkt, dann abbrechen
									antwort = reader.readLine(); // speichern zeilen in liste
									if (antwort.equals("."))
										break;
									zeilen.add(antwort);
								}
								email.add(new Email(i, zeilen));
								// Email email = new Email(i, zeilen);

							}
							System.out
									.println("Ihre Email(s) sind fertig geladen.\n");
							while (true) { // optionentafel erstellen
								System.out.println("Das sind Ihre Optionen: ");
								System.out.println("-1 : Beenden.");
								System.out.println("0 : empfangene Emails als Liste anzeigen.");
								System.out.println("n : eine bestimmte (n-te) Email anzeigen.");

								int eingabe = Integer.valueOf(sc.nextLine());
								if (eingabe == -1) {
									break;
								} else if (eingabe == 0) {
									System.out.println("Hier finden Sie Ihre Email(s):");
									for (int i = 1; i <= anzahlEmails; i++) { // Emails durchgehen und auflisten
										Email mail = email.get(i - 1);
										System.out.println(mail.nummer + ": " + mail.from + " " + mail.subject);
									}
									System.out.println("");
								} else if (eingabe > 0) {
									System.out.println("\nDas ist die " + eingabe + ". Email:");
									Email mail = email.get(eingabe - 1);
									for (int i = 0; i < mail.zeilen.size(); i++) {
										System.out.println(mail.zeilen.get(i));
									}
								}
							}

						} else {
							System.out
									.println("Wir haben einen Fehler beim Einlesen der Emails.");
						}

					} else {
						System.out
								.println("Wir haben ein Problem mit Ihrem Benutzernamen oder Ihrem Passwort. Ändern Sie das Bitte!");
					}

				} else {
					System.out
							.println("Wir haben ein Problem mit Ihrem Benutzernamen. Ändern Sie das Bitte!");
				}
			} else {
				System.out
						.println("Die Verbindung ist fehlgeschlagen. Das tut uns Leid.");
			}
			
			writer.write("QUIT\n");
			writer.flush();
			antwort = reader.readLine();
			if (antwort.startsWith("+OK")){
				System.out.println("Das Programm wird beendet. Bis demnächst!");
			}
			
			server.close();
			
		} catch (IOException e) { // Fehler fangen, falls falsche Eingabe oder server unerreichbar
			e.printStackTrace();
			System.out
					.println("Sorry, Sie haben sich da wohl vertippt oder der Server schläft. Bitte versuchen Sie es erneut:");
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
				subject = zeile.substring(9, zeile.length());
			}
			if (zeile.startsWith("From: ")) {
				from = zeile.substring(6, zeile.length());
			}
		}
	}
}
