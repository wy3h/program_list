package chapter6Method;

public class HelloMethod
{
	public static void main(String[] args)
	{
		HelloMethod hello = new HelloMethod();
		hello.sayHello();		// call method
	}
	
	public void sayHello()	// define method
	{
		System.out.println("Hello");
	}
}
