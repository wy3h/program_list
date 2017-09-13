package polymorphism;

public class SingTest
{
	public static void main(String[] args)
	{
		Sing b = new Bird();
		Sing p = new People();
		
		b.sing();
		p.sing();
	}
}
