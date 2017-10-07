package rentCar;

public class Car
{
	private String name;
	private int rent;
	
	Car(String name, int rent)
	{
		this.name = name;
		this.rent = rent;
	}

	public String getName()
	{
		return name;
	}


	public int getRent()
	{
		return rent;
	}

	public void show(){}

	
}
