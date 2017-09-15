package random;

import java.util.Random;

public class RandomTest		// input 5 random number form 1 to 6
{
	public static void main(String[] args)
	{
		Random r = new Random(17);
		for(int i = 0; i < 5; i++)
		{
			int p = r.nextInt(5) + 1;
			System.out.println("" + p);
		}
	}
	
}
