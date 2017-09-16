package arrayList;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Students
{
	private List<Student> students = new ArrayList<Student>(); 

	public void add(String name, int id)	
	{
		Student s = new Student(name, id);
		students.add(s);
	}
	public void add(String name, int id, int index)
	{
		Student s = new Student(name, id);
		students.add(index, s);
	}
	public boolean remove(int id)
	{
		int index = -1;
		for(Student s : students)
		{
			if(s.getId() == id)
			{
				index = students.indexOf(s);
			}
		}
		if(index != -1)
		{
			students.remove(index);
			return true;
		}
		else
			return false;
	}
	public void show1()
	{
		System.out.printf("name      id%n");
		for(Student s : students)
		{
			System.out.printf("%10s%10d%n", s.getName(), s.getId());
		}
	}
	public void show2()
	{
		System.out.printf("name      id%n");
		Iterator<Student> it = students.iterator();
		while(it.hasNext())
		{
			Student s = it.next();
			System.out.printf("%10s%10d%n", s.getName(), s.getId());
		}
	}
	public void change(int index, String name, int id)
	{
		students.set(index, new Student(name, id));
	}
	public void clear()
	{
		students.clear();
	}
	
}
