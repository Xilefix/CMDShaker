package klassen;

import java.util.stream.IntStream;

public class IntMengeImpl extends AbstrakteIntMenge {
	int array[];

	@Override
	public void add(int i) {
		if (contains(i)==true)
		{
			int[]  arr = new int[array.length+1];
			arr[array.length]=i;
			return ;
		}
		else 
		{
			return;
			
		}
			

	}

	@Override
	public void remove(int i) {
		if(this.contains(i)==true)
		{
			
		}
		

	}

	@Override
	public boolean contains(int i) {
		if(IntStream.of(array).anyMatch(x -> x == i))
		{
			return true;
		}
		else
		{
			return false;
		}	
	}

	@Override
	public int getSize() {
		return array.length;
	}

	@Override
	public int[] getElements() {
		
		return array.clone();
	}

}
