package rentCar;

public class MixedCar extends Car
{
	private int capacity;
	private int carryWeight;	// symbol is ton
	
	MixedCar(String name, int rent, int capacity, int carryWeight)
	{
		super(name, rent);
		this.capacity = capacity;
		this.carryWeight = carryWeight;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public int getCarryWeight()
	{
		return carryWeight;
	}
	public void show()
	{
		System.out.printf("name:%s rent:%d capicity:%d people carryWeight:%dT", getName(), getRent(), getCapacity(), getCarryWeight());
	}
}
