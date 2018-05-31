package klassen;

public class Kamera extends Artikel {
	public int megaPixel;
	
	public Kamera(int aktAnzahl, int minAnzahl, double nettoPreis, String name, double mwst) {
		super(aktAnzahl, minAnzahl, nettoPreis, name, mwst);
		this.mwst=19;
		this.megaPixel=16;
		
	}
	
	
	//Methods
	public void print() {
		System.out.println("Artikel type: Kamera Eigenschaften: MegaPixel: "+megaPixel+" "+name+"_"+aktAnzahl+"_"+minAnzahl+"_"+"Netto-Preis:"+nettoPreis);
	}
}
