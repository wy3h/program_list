package polymorphism;

public class AnimalTest
{
	public static void main(String[] args)
	{
		Animal dog = new Dog("Tom", 2);			// upcasting
		Animal cat = new Cat("Jerry", 1);
		
		dog.eat();		// polymorphism 		
		cat.eat();
		dog.play();
		cat.play();
	}
}
