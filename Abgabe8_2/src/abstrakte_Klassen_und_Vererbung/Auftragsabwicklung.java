package abstrakte_Klassen_und_Vererbung;

public class Auftragsabwicklung {
	
public static void main(String args[]) {
	final double produktion = 200; // Wochenproduktion
		// f¨ulle die Bestellung mit Fl¨ussigkeitsbeh¨altnissen
		Behaeltnis[] bestellung = {
			new Tetrapack(2.3, 0.9, 0.7), new Dose(0.59 , 1.15),
			new Dose(0.59 , 1.15), new Tetrapack(1.1, 0.7, 0.7) // ...
		};
		// gebe Liste aller bestellten Fl¨ussigkeitsbeh¨altnisse aus
		for (int i = 0; i < bestellung.length; i++) {
			bestellung[i].println();
		}
		// berechne das Gesamtvolumen der Bestellung
		double gesamtvolumen = 0.0;
		for (int i = 0; i < bestellung.length; i++) {
			gesamtvolumen = gesamtvolumen + bestellung[i].volumen();
		}
		System.out.println(gesamtvolumen);
		// und die Restmenge der Wochenproduktion
		double restmengewoche = produktion - gesamtvolumen;
		if (produktion == restmengewoche)
		{
			System.out.println(restmengewoche);
		}
	
	}
}