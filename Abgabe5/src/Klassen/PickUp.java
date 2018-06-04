package Klassen;

public class PickUp extends Auto {
	int ladeflaeche;
	int f;
		
	//constructer
	public PickUp(String kennzeichen, int f) {
		super(kennzeichen);
		this.ladeflaeche = 0;
		this.anzahlSitzplaetze = 2;
		this.f = f;
			}
	public PickUp(int f) {
		this.ladeflaeche = 0;
		this.anzahlSitzplaetze = 2;
		this.f = f;
	}
	
	//Methoden
	public int getLadung() {
		return ladeflaeche;
	}
	public boolean beladen(int ladung) {
		if(f >= ladeflaeche + ladung) {
			System.out.println("Ladeflaeche wurde geladen um: " + ladung);
			ladeflaeche = ladeflaeche + ladung;
			return true;
		}
		else {
			return false;
		}
		
	}
	public void entladen(int ladung) {
		System.out.println("Ladeflaeche verringert um : " + ladung);
		ladeflaeche = ladeflaeche - ladung;
		
	}
	public void entladen() {
		entladen(getLadung());	
	}
	public void bereiteWaschenVor() {
		super.bereiteWaschenVor();
		entladen();		
	}
	public void wasche() {
		antenne = false;
		System.out.println("PickUp wird gewaschen");
	}
	public void fahre(int kilometer) {
		System.out.println("PickUp hat Strecke zurückgelegt: "+ kilometer);
		kilometerstand = kilometerstand + kilometer;
	}
	public String toString() {
		return ("PickUp_" + kennzeichen + "_" + kilometerstand + "_" + anzahlSitzplaetze + "_Antenne:" + antenne + "_" + ladeflaeche);
		
	}
}
