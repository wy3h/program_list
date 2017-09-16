package arrayList;

public class StudentsTest
{
	public static void main(String[] args)
	{
		Students s = new Students();
		s.add("Tome", 101);
		s.add("Jerray", 102);
		s.add("Alex", 103, 2);
		s.add("Mccree", 104, 2);
		
		s.remove(102);
		s.show1();
		
		s.change(2, "Ana", 105);
		s.show1();
		
		s.clear();
		s.show2();
	}
}
