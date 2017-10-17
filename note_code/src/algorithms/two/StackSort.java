package algorithms.two;

public class StackSort
{
	public static void sort(Comparable[] a)
	{
		int N = a.length;
		for(int k = N/2; k >= 1; k--)
		{
			sink(a, k, N);
		}
		while(N > 1)
		{
			exch(a, 1, N--);
			sink(a, 1, N);
		}
		
	}
	private static void sink(Comparable[] a, int k, int N)
	{}
	private static void exch(Comparable[] a, int k, int N)
	{}
	
}
