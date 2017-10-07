package inherit;

public class Cat extends Animal		// subclass
{
	private String color;
	
	Cat(String name, int age, String color)		// constructor
	{
		super(name, age);	// must call superclass constructor
		this.color = color;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void eat()	// override eat(), play(), show()
	{
		System.out.println("A cat eating something.");
	}
	public void play()
	{
		System.out.println("A cat playing something.");
	}
	public void show()
	{
		System.out.println("The cat name is " + super.getName());	// must call super.getName() to get super private date
		System.out.println("is " + super.getAge() + " years old");
		System.out.println("its a " + getColor() + " cat");
	}
	
	public static void main(String[] args)
	{
		Cat c = new Cat("Tom", 2, "blue");
		c.eat();
		c.play();
		c.show();
		System.out.println(c instanceof Cat);
	}
}
