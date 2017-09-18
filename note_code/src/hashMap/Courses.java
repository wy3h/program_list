package hashMap;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * a courses class by HashMap 
 */
public class Courses
{
	// a HashMap to save courses information
	private Map<String, Course> courses;
	
	// initialize HashMap
	Courses()
	{
		courses = new HashMap<String, Course>();
	}
	
	public void add(String name, int id)
	{
		if(courses.get(name) == null)
		{
			Course temp = new Course(name, id);
			courses.put(name , temp);
			System.out.println("course name: " + name + " add successfully");
		}
		else
			System.out.println("course name: " + name + " already exist");
	}
	
	public void del(String name)
	{
		if(courses.get(name) == null)
			System.out.println("course name: " + name + " not found");
		else
		{
			courses.remove(name);
			System.out.println("course name: " + name + " delete successfully");
		}
	}
	
	public void show()
	{
		Set<Entry<String, Course>> temp = courses.entrySet();
		System.out.printf("%10s%10s%n", "name" , "id");
		for(Entry<String, Course> e : temp)
		{
			System.out.printf("%10s%10d%n", e.getKey(), e.getValue().getId());
		}
	}
	
	public void change(String name, int id)
	{
		if(courses.get(name) != null)
		{
			Course c = new Course(name, id);
			courses.remove(name);
			courses.put(name, c);
			System.out.println("course name: " + name + " change successfully");
		}
		else
			System.out.println("course name: " + name + " not found");
	}
}
