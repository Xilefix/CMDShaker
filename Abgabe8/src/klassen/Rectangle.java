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

}
