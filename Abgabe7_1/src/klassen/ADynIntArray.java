package klassen;

public abstract class ADynIntArray implements IDynIntArray{
	public abstract void add(int e);
	public abstract void setElementAt(int i, int e); 
	public abstract int getElementAt(int i);
	public abstract int getElementCount();
	public abstract void print();
}
