package snippet;

public class Snippet
{
	public static void main(String[] args)
		{
			Stack<Dog> d = new Stack<Dog>();
			Dog d1 = new Dog("Smith", 1);
			Dog d2 = new Dog("Tom", 2);
			Dog d3 = new Dog("Jerry", 3);
			d.push(d1);
			d.push(d2);
			d.push(d3);
			System.out.println("first:" + d.pop());
			System.out.println("Second:" + d.pop());
			System.out.println("Third:" + d.pop());
		}
}

