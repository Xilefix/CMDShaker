package abstrakte_Klassen_und_Vererbung;

public abstract class Behaeltnis {
	/*public Behaeltnis() {
		
	}*/
	public double volumen;
	//Dose
	public double flaeche;
	public double hoehe;
	//Tetrapack Kanten
	public double x;
	public double y;
	public double z;
	
	//Methods
	public abstract void println();
	public abstract int volumen();

}
