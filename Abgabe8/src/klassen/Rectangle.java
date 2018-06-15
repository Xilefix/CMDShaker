package klassen;

public class Rectangle implements ResizeableGO, MoveableGO {
	
	//Variables
	public float height;
	public float width;
	public float x; //The X coordinate of the upper-left corner of the Rectangle.
	public float y; //The Y coordinate of the upper-left corner of the Rectangle.
	
	public Rectangle(float height, float width, float x, float y){
		this.height = height;
		this.height = width;
		this.height = x;
		this.height = y;
				
	}
	
	//Methods
	@Override
	public void move(float x, float y) {		
		this.x = x;
		this.y = y;

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
		this.width = width;
	}


	public static void resizeAll(float r, ResizeableGO rgo[]) {
		for (ResizeableGO g : rgo) g.resize(r);
	}

	public static void moveAll(float dx, float dy, MoveableGO mgo[]) {
		for (MoveableGO m : mgo) m.move(dx, dy);
	}


public static void main(String[] args) {
	Rectangle[] rects = new Rectangle[4];
	//Objecte in Array initialisieren 
	rects[0] = new Rectangle(8,7,3,2);
	rects[1] = new Rectangle(8,7,3,2);
	rects[2] = new Rectangle(8,7,3,2);
	rects[3] = new Rectangle(8,7,3,2);
	
	resizeAll(2, rects);
	moveAll(2, 3, rects);
	}
}

