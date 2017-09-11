package classAndObject;

public class Girl
{
	private String name;		// three parameter to describer class Girl.
	private int age;
	private String job;
	
	Girl(String name,int age) // constructor only two parameter.
	{
		this.name = name;
		this.age = age;
		this.job = "";
	}
	Girl(String name,int age,String job)	// overload three parameter.
	{
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	public String getName()				// three method to get value.
	{return name;}
	public int getAge()
	{return age;}
	public String getJob()
	{return job;}
	
	public void sayHello()			// some method(class has).
	{
		System.out.println("Hello," + "Im " + getName() + ".");
	}
	public void sayMore()
	{
		if (getJob() != "")
			System.out.println("My age is mystery, and my job is " + getJob() + ".");
		else
			System.out.println("My age is mystery.");
	}
	
	public static void main(String[] args) // test class
	{
		Girl g1 = new Girl("Ana", 18, "student");
		Girl g2 = new Girl("Lily", 30);
		g1.sayHello();
		g1.sayMore();
		g2.sayHello();
		g2.sayMore();
	}
}
