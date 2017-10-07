package polymorphism;

public abstract class Animal	// a abstract class 
{
	private String name;
	private int age;
	
	Animal(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{return name;}
	
	public int getAge()
	{return age;}
	
	public abstract void play();
	public abstract void eat();
}
