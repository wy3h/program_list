package inherit;

public class Animal		// a super class
{
	private String name;	
	private int age;
	
	Animal(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
	public void eat()
	{
		System.out.println("A animal eating something.");
	}
	public void paly()
	{
		System.out.println("A animal palying something.");
	}
	public void show()
	{
		System.out.println("the Animal name is " + getName());
		System.out.println("is " + getAge() + "years old");
	}
}
