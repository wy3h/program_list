package polymorphism;

public class Cat extends Animal		// extends Animal
{
	Cat(String name, int age)
	{
		super(name, age);
	}
	
	public void play()	// override play()
	{
		System.out.println("A cat playing");
	}
	public void eat()	// override eat()
	{
		System.out.println("A cat eating");
	}
}
