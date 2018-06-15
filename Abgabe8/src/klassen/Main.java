package klassen;

public class Main {
	public static void resizeAll(float r, ResizeableGO rgo[]) {
		for (ResizeableGO g : rgo) g.resize(r);
	}
	
	public static void moveAll(float dx, float dy, MoveableGO mgo[]) {
		for (MoveableGO m : mgo) m.move(dx, dy);
	}

	public static void main(String[] args) {
		Rectangle[] rects = new Rectangle[4];// siehe 2te Aufgabe array Erstellung
		//Objecte in Array initialisieren 
		for (int i=0; i<4; i++)
		{
			rects[i] = new Rectangle(4,3,3,1);
		}
		resizeAll(r, rgo);
		moveAll(dx, dy, mgo);)
		

	}

}
