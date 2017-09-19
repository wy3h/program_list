package generic;

public class People
{
	private String name;
	private int id;
	
	People(String name, int id)
	{
		this.name = name;
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public int getId()
	{
		return id;
	}
}
