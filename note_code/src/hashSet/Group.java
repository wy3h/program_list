package hashSet;

import java.util.Set;
import java.util.HashSet;


public class Group
{
	private String teacherName;
	private int groupNumber;
	private Set<Student> students = new HashSet<Student>();
	
	Group(String teacherName, int groupNumber)
	{
		this.teacherName = teacherName;
		this.groupNumber = groupNumber;
	}

	public String getTeacherName()
	{
		return teacherName;
	}
	public int getGroupNumber()
	{
		return groupNumber;
	}
	
	public void add(Student s)
	{
		students.add(s);
	}
	public void remove(String name, int id)
	{
		Student temp = new Student(name, id);
		if(students.contains(temp))
			students.remove(temp);
		else
			System.out.println("No found");
	}
	public void show()
	{
		System.out.println("Teacher name: " + teacherName + " group number: " + groupNumber);
		System.out.printf("name      id%n");
		for(Student s : students)
		{
			System.out.printf("%10s%10d%n", s.getName() , s.getId());
		}
	}

	
	
}
