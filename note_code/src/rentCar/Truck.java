package rentCar;

public class Truck extends Car
{
	private int carryWeight;
	Truck(String name, int rent, int carryWeight)
	{
		super(name, rent);
		this.carryWeight = carryWeight;
	}
	public int getCarryWeight()
	{
		return carryWeight;
	}
	public void show()
	{
		System.out.printf("name:%s rent:%d carryWeight:%d", getName(), getRent(), getCarryWeight());
	}
}
