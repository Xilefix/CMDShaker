package klassen;

public class Buch extends Artikel {
	public int seitenAnz;
	
	public Buch(int aktAnzahl, int minAnzahl, double nettoPreis, String name, double mwst) {
		super(aktAnzahl, minAnzahl, nettoPreis, name, mwst);
		this.mwst=7;
		this.seitenAnz=400; 
		
	}

	
	//Methods
	public void print() {
		System.out.println("Artikel type: Buch Eigenschaften: seitenAnz: "+seitenAnz+" "+ name+"_"+aktAnzahl+"_"+minAnzahl+"_"+"Netto-Preis:"+nettoPreis);
	}
}
