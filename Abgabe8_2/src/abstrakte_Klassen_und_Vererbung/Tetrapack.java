package abstrakte_Klassen_und_Vererbung;

public class Tetrapack extends Behaeltnis {
	public Tetrapack(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.volumen = x*y*z;
		
		
	}

	@Override
	public void println() {
		System.out.println("Parameter: " + this.x +", " + this.y +", "+ this.z);
		
	}

	@Override
	public double volumen() {
		return this.volumen;
	}

}
