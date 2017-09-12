package encapsulation;

public class InnerClass
{
	public static void main(String[] args)
	{
		People p = new People("Ana", 1);
		People.Friend f = p.new Friend("smile");
		f.talk();
	}
}

class People
{
	private String name;
	private int id;
	
	People(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	
	public class Friend
	{
		private String likeWord;
		Friend(String word)
		{
			likeWord = word;
		}
		public void talk()
		{
			System.out.println("Im " + name + ",my id is " + id + "," + likeWord + " is a good word.");
		}
	}
}