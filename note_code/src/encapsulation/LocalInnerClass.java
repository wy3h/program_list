package encapsulation;

public class LocalInnerClass
{
	public static void main(String[] args)
	{
		Person p = new Person();
		p.talk("Lily", "ice cream", 2);
	}
}

class Person
{
	public void talk( String aname, String afood, int aid)
	{
		class Girl
		{
			private String name;
			private String food;
			private int id;
			
			Girl(String name,String food,int id)
			{
				this.name = name;
				this.food = food;
				this.id = id;
			}
			public void show()
			{
				System.out.printf("Im %s, my id is %d, %s is my best", name, id, food);
			}
		}
		Girl g = new Girl(aname, afood, aid);
		g.show();
	}
}