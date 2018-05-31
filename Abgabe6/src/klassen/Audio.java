package klassen;

public class Audio extends Artikel {
	public Audio(int aktAnzahl, int minAnzahl, double nettoPreis, String name, double mwst) {
		super(aktAnzahl, minAnzahl, nettoPreis, name, mwst);
		this.mwst=19;
	}

	public String format;
	//Methods
	public void print() {
		System.out.println("Artikel type: Audio Eigenschaften: Format: "+format+" "+name+"_"+aktAnzahl+"_"+minAnzahl+"_"+"Netto-Preis:"+nettoPreis);
	}
}
