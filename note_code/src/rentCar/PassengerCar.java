package rentCar;

public class PassengerCar extends Car
{
	private int capacity;
	
	PassengerCar(String name, int rent, int capacity)
	{
		super(name, rent);
		this.capacity = capacity;
	}

	public int getCapacity()
	{
		return capacity;
	}
	public void show()
	{
		System.out.printf("name:%s rent:%d capicity:%d", getName(), getRent(), getCapacity());
	}
}
