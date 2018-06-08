package klassen;

public abstract class AbstrakteIntMenge implements IntMenge {
	public abstract void add(int i);
    public abstract void remove(int i);
    public abstract boolean contains(int i);
    public abstract int getSize();
    public abstract int[] getElements();
	@Override
	public boolean isEmpty() {
		if(this.getSize()==0)
		return true;
        else 
		return false;
	}


	@Override
	public int getSum() {
		int arr[];
		arr	= getElements();
		int sum = 0;
		for(int counter=0;counter<getSize()-1;counter++){
			sum+=arr[counter];
    }
    return sum;
	}

	@Override
	public void print() {
		int a[]= this.getElements();
		for(int s : a)
		{
			System.out.println(s);
		}
	}

}
