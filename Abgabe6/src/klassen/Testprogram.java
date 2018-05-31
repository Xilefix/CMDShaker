package klassen;

public class Testprogram {
	public static void printArtikel(Artikel arts[]) {
    	System.out.println("Artikelliste:");
    	for (int i = 0; i < arts.length; i++) {
    	arts[i].print(); System.out.println();
    	}
    	System.out.println("\nBestellung:");
    	for (int i = 0; i < arts.length; i++) {
    	arts[i].printBestellung(i); System.out.println();
    	}
    	}

	public static void main(String[] args) {
		
		Artikel test [] = new Artikel [6];
        test[0] = new Buch(2,2,15,"Bucheins",350);
        test[1] = new Buch(4,10,22,"Buchzwei",1000);
        test[2] = new Kamera(5,5,500,"Kameraeins", 123);
        test[3] = new Kamera(3,7,300,"Kamerazwei", 156);
        test[4] = new Audio(7,7,20,"Audioeins",3);
        test[5] = new Audio(4,5,20,"Audiozwei",1);
        printArtikel(test); 
        
        

		
		/*Artikel adf = new Artikel(1, 2, 3, "zdsd", 19);
		adf.printBestellung(2);
		adf.print();
		Buch addf = new Buch(1, 2, 3, "zdsd", 19);
		addf.printBestellung(2);
		addf.print();*/
	}

}
