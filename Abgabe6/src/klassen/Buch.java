package klassen;

public class Buch extends Artikel {
	public Buch(int aktAnzahl, int minAnzahl, double nettoPreis, String name, double mwst) {
		super(aktAnzahl, minAnzahl, nettoPreis, name, mwst);
		
	}

	public int seitenAnz;
}
