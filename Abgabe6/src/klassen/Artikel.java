package klassen;

public class Artikel {
	//Variables
	protected int aktAnzahl;
	protected int minAnzahl;
	protected double nettoPreis;
	protected String name;
	protected double mwst;

	//Constructor
	public Artikel(int aktAnzahl, int minAnzahl, double nettoPreis, String name, double mwst) {
		this.aktAnzahl=aktAnzahl;
		this.minAnzahl=minAnzahl;
		this.nettoPreis=nettoPreis;
		this.name=name;
		this.mwst=mwst;
	}
	
	//Methods
	public void print() {
		System.out.println("Artikel: "+name+"_"+aktAnzahl+"_"+minAnzahl+"_"+"Netto-Preis:"+nettoPreis);
	}
	public void printBestellung(int bestellAnz) {
		System.out.println(name+"_ zu bestellende Anzahl: "+bestellAnz+"*"+nettoPreis+"="+);
		
	}
	
	
	
	
}
