package abstrakte_Klassen_und_Vererbung;

public class Dose extends Behaeltnis {
	public Dose(double x, double y){
		this.flaeche = x;
		this.hoehe = y;
		this.volumen = x * y;
		
	}

	@Override
	public void println() {
		System.out.println("Parameter: " + this.flaeche +", " + this.hoehe);
		
	}

	@Override
	public int volumen() {
		// TODO Auto-generated method stub
		return 0;
	}

}
