package chapter6Method;

public class Overload
{
	void f(int n)	// parameter list is int
	{
		System.out.println("This is a f(int)");
	}
	void f(String s) // parameter list is String
	{
		System.out.println("This is a f(String)");
	}
	public static void main(String[] args)
	{
		Overload o = new Overload();
		o.f(1);			// call f(int)
		o.f("hello");	// call f(String)
	}
}
