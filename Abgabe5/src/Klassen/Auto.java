package Klassen;

public class Auto {
	String kennzeichen;
	int kilometerstand;
	int anzahlSitzplaetze;
	boolean antenne;
	
	//default constructor
	public Auto() {
		this.kennzeichen = "J-AA 01";
		this.kilometerstand = 0;
		this.anzahlSitzplaetze = 5;
		this.antenne = false; //eingefahren
	}
	
	//constructor
	public Auto(String kennzeichen, int sitzplaetze) {
		this.kennzeichen = kennzeichen;
		if (sitzplaetze == 2)
		{
			this.anzahlSitzplaetze = sitzplaetze;
		}
	}
		public Auto(int sitzplaetze) {
			if (sitzplaetze == 2)
			{
				this.anzahlSitzplaetze = sitzplaetze;
			}
		}
			public Auto(String kennzeichen) {
				this.kennzeichen = kennzeichen;
	}
	
	//Methoden
	public String getKennzeichen() {
		return kennzeichen;				
	}
	public int getKilometerstand() {
		return kilometerstand;		
	}
	public int getSitzplaetze() {
		return anzahlSitzplaetze;
	}
	public void fahre(int kilometer) {
		System.out.println("Auto hat Strecke zurückgelegt: "+ kilometer);
		kilometerstand = kilometerstand + kilometer;
	}
	public void fahreAntenneAus() {
		System.out.println("Antenne wird ausgefahren");
		antenne = true;		
	}
	public void fahreAntenneEin() {
		System.out.println("Antenne wird eingefahren");
		antenne = false;
	}
	public void bereiteWaschenVor() {
		antenne = false;
	}
	public void wasche() {
		antenne = false;
		System.out.println("Auto wird gewaschen");
	}
	public String toString() {
		return ("Auto_" + kennzeichen + "_" + kilometerstand + "_" + anzahlSitzplaetze + "_Antenne:" + antenne);
	}
}
