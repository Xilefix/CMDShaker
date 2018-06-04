package Klassen;

public class AutoTest {

	public static void main(String[] args) {
		Auto a = new Auto();
		Auto b = new Auto(2);
		Auto c = new Auto("Abba",2);
		PickUp d = new PickUp(10);
		PickUp e = new PickUp("abda",12);
		PickUp g = new PickUp("abadg",14);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(d.toString());
		System.out.println(e.toString());
		System.out.println(g.toString());
		
		a.fahre(20);
		b.wasche();
		d.fahre(20);
		e.wasche();
		g.beladen(50);
		g.entladen(50);
			
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		
		
	}

}
