package chapter6Method;

public class Overload
{
	void f(int n)
	{
		System.out.println("This is a f(int)");
	}
	void f(String s)
	{
		System.out.println("This is a f(String)");
	}
	public static void main(String[] args)
	{
		Overload o = new Overload();
		o.f(1);
		o.f("hello");
	}
}
