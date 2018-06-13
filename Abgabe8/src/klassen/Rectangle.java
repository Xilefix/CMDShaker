package klassen;

public class Rectangle implements ResizeableGO, MoveableGO {
	
	
	
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
	public void resize(float width) {
		// TODO Auto-generated method stub

	}
	
	public static void resizeAll(float r, ResizeableGO rgo[]) {
		for (ResizeableGO g : rgo) g.resize(r);
	}
	
	public static void moveAll(float dx, float dy, MoveableGO mgo[]) {
		for (MoveableGO m : mgo) m.move(dx, dy);
	}
	
	public Rectangle height;
	public Rectangle width;
	public float x; //The X coordinate of the upper-left corner of the Rectangle.
	public float y; //The Y coordinate of the upper-left corner of the Rectangle.
	
	
	Rectangle[] rects = new Rectangle[4];
	
	/*{
		for (int i=0; i<4; i++)
		{
			rects[i] = new Rectangle();
		}
		for (int i=0; i<4; i++)
		{
			rects[i] = height;
		}
	}*/
}
