package scoreSort;

import java.util.Comparator;
import java.util.Arrays;


public class SortScore
{
	public static void main(String[] args)
	{
		Integer[] scores = {89, -23, 64, 91, 119, 52, 73};
		SortScore.reversedSort(scores);
		for(int i = 0; i < 3; i++)
		{
			System.out.println(scores[i]);
		}
		
	}
	
	public static void reversedSort(Integer[] scores)
	{
		Comparator<Integer> comp = new Reversed();
		Arrays.sort(scores, comp);
	}
}

class Reversed implements Comparator<Integer>
{

	public int compare(Integer o1, Integer o2)
	{
		if(o1 > o2)
			return -1;
		if(o1 < o2)
			return 1;
		return 0;
	}
}
