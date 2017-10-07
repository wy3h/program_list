package hashSet;

import java.util.Scanner;

public class GroupTest
{
	public static void main(String[] args)
	{
		Students s = new Students();
		
		s.add("Ana", 1);
		s.add("Mccree", 2);
		s.add("Tracer", 3);
		s.add("Lily", 4);
		s.add("Lelouch", 5);
		s.add("Tom", 6);
		s.add("Jerry", 7);
		
		Group g1 = new Group("Alex", 1);
		Group g2 = new Group("Smith", 2);
		Scanner in = new Scanner(System.in);
		
		System.out.println("input first group number's id(only two).");
		s.show1();
		for(int i = 0; i < 2; i++)
		{
			System.out.println("input id");
			int id = Integer.parseInt(in.next());
			for(Student student : s.getList())
			{
				if(student.getId() == id)
					g1.add(student);
			}
		}
		g1.show();
		
		System.out.println("input first group number's id(only two).");
		s.show1();
		for(int i = 0; i < 2; i++)
		{
			System.out.println("input id");
			int id = in.nextInt();
			for(Student student : s.getList())
			{
				if(student.getId() == id)
					g2.add(student);
			}
		}
		g2.show();
		
		in.close();
		System.out.println("Else peoples are last group.");
	}
}
