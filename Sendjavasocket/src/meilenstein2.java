
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Scanner;

public class meilenstein2 {

	public static void main(String args[]) {

		System.out.println("Geben Sie die Internetadresse ein:");//firemail.de
		Scanner sc = new Scanner(System.in); // eingabe wird gescannt und in sc
												// gespeichert
		String url = sc.nextLine(); // einlesen der SMTP adresse
		System.out.println("Geben Sie bitte jetzt den Port ein:");//587

		int port = Integer.valueOf(sc.nextLine()); // string in Zahl umwandeln

		System.out.println("Geben Sie Ihren Ihre Emailadresse ein:");//unijena123@firemail.de
		String user = sc.nextLine();

		System.out.println("Geben Sie bitte Ihr Passwort ein:");//Felix#jena1
		String pass = sc.nextLine();

		while (true) {

			System.out.println("Das sind Ihre Optionen: ");
			System.out.println("0 : Neue Email verfassen.");// wieder hoch zum
															// email schreiben
			System.out.println("-1 : Beenden");
			try {
				int auswahl = Integer.valueOf(sc.nextLine());
				if (auswahl == -1) {
					break;
				} else if (auswahl == 0) {

					ArrayList<String> empfaenger = new ArrayList<>(); // Empfangerliste
																		// erstellen
					ArrayList<String> email = new ArrayList<>(); // Email zeilen
																	// erstellen

					System.out.println("Wie viele Empfänger soll es geben?");
					int anzahlempfaenger = Integer.valueOf(sc.nextLine());
					for (int i = 0; i < anzahlempfaenger; i++) {
						System.out.println("Geben Sie eine Empfängeradresse ein:");
						empfaenger.add(sc.nextLine());
					}

					System.out.println("Schreiben Sie Ihren Betreff hier:");
					String subject = sc.nextLine();

					System.out.println("Schreiben Sie Ihre Email hier rein:");
					while (true) {
						String content = sc.nextLine();
						email.add(content);
						if (content.equals(".")) {
							break;
						}
					}

					try {
						Socket server = new Socket(url, port);
						BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));
						// lesen nachricht vom server
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
						// schreiben nachricht an server

						String antwort = reader.readLine();
						if (antwort.startsWith("220")) {
							String hostname = InetAddress.getLocalHost().getHostAddress();
							// IP adresse mit localhost nehmen
							writer.write("EHLO " + hostname + "\n");
							writer.flush();

							antwort = reader.readLine();
							while (true) {
								if (reader.readLine().startsWith("250 ")) {
									break;
								}
							}
							writer.write("AUTH LOGIN\n");
							writer.flush();

							antwort = reader.readLine();
							if (antwort.startsWith("334")) {

								writer.write(new String(Base64.getEncoder().encode(user.getBytes())) + "\n");
								// Verschlüsselm und ändern den user in bytes
								// um,
								// weil es nicht mit strings klappt
								writer.flush();

								antwort = reader.readLine();
								if (antwort.startsWith("334")) {
									writer.write(new String(Base64.getEncoder().encode(pass.getBytes())) + "\n");
									writer.flush();

									antwort = reader.readLine();
									if (antwort.startsWith("235")) {
										writer.write("MAIL FROM:<" + user + ">\n");
										writer.flush();

										antwort = reader.readLine();
										if (antwort.startsWith("250")) {
											for (int i = 0; i < anzahlempfaenger; i++) {
												System.out.println(empfaenger.get(i));
												writer.write("RCPT TO:<" + empfaenger.get(i) + ">\n");
												writer.flush();
												antwort = reader.readLine();
												if (!antwort.startsWith("250")) {
													System.out.println("Fehler mit einer eingegebenen Empfaengeradresse.");
												}
											}
											writer.write("DATA\n");
											writer.flush();
											antwort = reader.readLine();
											if (antwort.startsWith("354")) {
												writer.write("From: <" + user + ">\n");
												writer.flush();

												String empfaengertemp = "";
												for (int i = 0; i < anzahlempfaenger; i++) {
													// alle empfaenger
													// durchgehen, um sie in to
													// zu schreiben
													empfaengertemp += "\"" + empfaenger.get(i) + "\" <" + empfaenger.get(i) + ">, ";
												}
												empfaengertemp = empfaengertemp.substring(0, empfaengertemp.length() - 2);

												writer.write("To: <" + empfaengertemp + ">\n");
												writer.flush();

												writer.write("Subject: " + subject + "\n");
												writer.flush();

												writer.write("\n");
												writer.flush();

												for (int i = 0; i < email.size(); i++) {
													writer.write(email.get(i) + "\n");
													writer.flush();
												}

												antwort = reader.readLine();
												if (antwort.startsWith("250")) {
													writer.write("QUIT\n");
													writer.flush();
													server.close();

												} else {
													System.out.println("Fehler mit der Email.");
												}
											} else {
												System.out.println("Fehler mit DATA.");
											}

										} else {
											System.out.println("Fehler mit Ihrer Empfaengeradresse.");
										}

									} else {
										System.out.println("Fehler mit Ihrem Passwort");
									}

								} else {
									System.out.println("Fehler mit Ihrem Benutzernamen.");
								}

							} else {
								System.out.println("Authentifizierung nicht unterstützt.");

							}

						} else {
							System.out.println("Die Verbindung ist fehlgeschlagen. Das tut uns Leid.");
						}

					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("Sorry, Sie haben sich da wohl vertippt oder der Server schläft. Bitte versuchen Sie es erneut:");
					}
				} else {
					System.out.println("Falsche Eingabe!");
				}
			} catch (Exception e) {
				System.out.println("Gib eine Zahl ein!");
			}

		}

		sc.close(); // Scanner schließen
	}
}


