package rentCar;

import java.util.*;
import java.util.Scanner;
public class Menu
{
	ArrayList<Car> cars;
	ArrayList<Item> list;
	Scanner input = new Scanner(System.in);
	
	Menu()
	{
		cars = new ArrayList<Car>();
		list = new ArrayList<Item>();
	}
	
	public static void main(String[] args)
	{
		Menu m = new Menu();
		int choice = 999;
		m.initialize();
		while(choice != 0)
		{
			switch(choice = m.showMenu())
			{
			case 1:
				m.showCar();
				break;
			case 2:
				m.rentCar();
				break;
			case 3:
				m.showList();
				break;
			default:
				choice = 0;
			}
		}
		
	}
	
	public int showMenu()
	{
		System.out.println("----------------------------------------");
		System.out.println("1. show all car");
		System.out.println("2. rent car");
		System.out.println("3. show your rent list");
		System.out.println("else to quit");
		System.out.print("your choice :");
		int temp;
		if(input.hasNextInt())
		{
			temp = input.nextInt();
		}
		else 
		{
			System.out.println("please input integer");
			temp = 0;
		}
		
		System.out.println("----------------------------------------");
		return temp;
		
	}
	public void initialize()
	{
		PassengerCar pc = new PassengerCar("passengerCar", 100, 4);
		Truck t = new Truck("truck", 200, 5);
		MixedCar mc = new MixedCar("mixedCar", 200, 2, 5);
		cars.add(pc);
		cars.add(t);
		cars.add(mc);
	}
	public void showCar()
	{
		for(Car c : cars)
		{
			c.show();
			System.out.println();
		}
	}
	public void rentCar()
	{
		int index;
		int quantity;
		
		System.out.println("input car's index(from 0) you want to rent");
		index = input.nextInt();
		System.out.println("input quantity you want");
		quantity = input.nextInt();
		Item i = new Item(cars.get(index), quantity);
		list.add(i);
	}
	public void showList()
	{
		int totalMoney = 0;
		int totalCarry = 0;
		int totalCapacity = 0;
		for(Item i : list)
		{
			totalMoney += i.c.getRent() * i.quantity;
			i.c.show();
			System.out.println(" quantity:" + i.quantity);
			if(i.c.getClass() == Truck.class)
			{
				Truck t = (Truck) i.c;
				totalCarry += t.getCarryWeight() * i.quantity;
			}
			else if(i.c.getClass() == PassengerCar.class)
			{
				PassengerCar p = (PassengerCar)i.c;
				totalCapacity += p.getCapacity() * i.quantity;
			}
			else
			{
				MixedCar mc = (MixedCar) i.c;
				totalCapacity += mc.getCapacity();
				totalCarry += mc.getCarryWeight();
			}
		}
		System.out.printf("total money:%d totalCarry:%d totalCapacity:%d%n", totalMoney, totalCarry, totalCapacity);
	}
}

class Item
{
	Car c;
	int quantity;
	Item(Car c, int quantity)
	{
		this.c = c;
		this.quantity = quantity;
	}
}