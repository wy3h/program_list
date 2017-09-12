package encapsulation;

public class AnonymousInnerClass
{
	public static void main(String[] args)
	{
		Dog d1 = new Dog("Tom", 2);
		d1.show("Jerry", 1, "female");				
		SaySomething s = new SaySomething()					// Anonymous inner class implement interface SaySomething
		{
			public void saysomething()						// overload saysomething()
			{
				System.out.println("this is a overload saysomething()");
			}
		};
		s.saysomething();
	}
}

class Dog
{
	private String name;
	private int age;
	
	Dog(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	void showSomething(){};
	void show(String a_name, int a_age, String a_sex)
	{
		Dog d = new Dog(a_name, a_age)			// anonymous inner class inherit superclass
		{
			void showSomething()				// overload showSomething()
			{
				System.out.println("my sex is " + a_sex);
			}
		};
		System.out.printf("dog%nname:%s age:%d %n", d.name, d.age);
		d.showSomething();
	}
}

interface SaySomething
{
	void saysomething();
}