package klassen;

public class Rectangle implements ResizeableGO, MoveableGO {
	//Varibles
	Rectangle rects[] = new Rectangle[10];
	
	//Methods
	@Override
	public void move(float x, float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(int x) {
		System.out.println("Rechteckstatus: Color set"); 

	}

	@Override
	public void show() {
		System.out.println("Rechteckstatus: show");		

	}

	@Override
	public void hide() {
		System.out.println("Rechteckstatus: hide");

	}

	@Override
	public void resize(float x) {
		// TODO Auto-generated method stub

	}
	
	public static void resizeAll(float r, ResizeableGO rgo[]) {
		for (ResizeableGO g : rgo) g.resize(r);
	}
	public static void moveAll(float dx, float dy, MoveableGO mgo[]) {
		for (MoveableGO m : mgo) m.move(dx, dy);
	}
	
}
