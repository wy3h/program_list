package polymorphism;

public class Dog extends Animal		// extends Animal
{
	Dog(String name, int age)
	{
		super(name, age);
	}
	
	public void play()		// override play()
	{
		System.out.println("a dog palying");
	}
	public void eat()	// override eat()
	{
		System.out.println("a dog eating");
	}
}
