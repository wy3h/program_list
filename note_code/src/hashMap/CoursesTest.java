package hashMap;

public class CoursesTest
{
	public static void main(String[] args)
	{
		Courses c = new Courses();
		c.add("Math", 100);
		c.add("English", 200);
		c.add("Java", 300);
		c.add("History", 400);
		c.add("Computer System", 500);
		c.show();
		
		c.del("History");
		c.change("Java", 301);
		c.show();
	}
}
