package generic;

public class Show
{
	// generic method to show class extends People information.
	public static <T extends People> void show(T obj)
	{
		System.out.println(obj.getClass().getName() + " name: " + obj.getName() + " id: " + obj.getId());
	}
	
	public static void main(String[] args)
	{
		// 4 object to test method
		People p1 = new People("Ana", 1);
		People p2 = new Police("Alex", 2);
		People p3 = new Firemen("Bob", 3);
		People p4 = new Laywer("Mccree", 4);
		
		Show.show(p1);
		Show.show(p2);
		Show.show(p3);
		Show.show(p4);
	}
}

class Police extends People
{
	Police(String name, int id)
	{
		super(name, id);
	}
}
class Firemen extends People
{
	Firemen(String name, int id)
	{
		super(name, id);
	}	
}
class Laywer extends People
{
	Laywer(String name, int id)
	{
		super(name, id);
	}	
}