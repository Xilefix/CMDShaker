package klassen;

public class Rectangle implements ResizeableGO, MoveableGO {
	//Varibles
	Rectangle rects[] = new [];
	
	
	@Override
	public void move(float x, float y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setColor(int x) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

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
