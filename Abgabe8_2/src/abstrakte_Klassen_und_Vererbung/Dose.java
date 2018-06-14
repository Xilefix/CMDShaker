package abstrakte_Klassen_und_Vererbung;

public class Dose extends Behaeltnis {
	public Dose(double x, double y){
		this.flaeche = x;
		this.hoehe = y;
		this.volumen = x * y;
		
	}

	@Override
	public void println() {
		// TODO Auto-generated method stub
		
	}

}
