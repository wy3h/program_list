package algorithms.one;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>
{
	private Item[] a = (Item[]) new Object[1];
	private int N = 0;     					// true item number
	public boolean isEmpty(){ return N==0;}
	public int size(){ return N;}
	private void resize(int max)
	{
		Item[] temp = (Item[]) new Object[max];
		for(int i = 0; i < N; i++)
			temp[i] = a[i];
		a = temp;
	}
	public void push(Item item)
	{
		if(N == a.length) resize(2*a.length);
		a[N++] = item;
	}
	public Item pop()
	{
		Item item = a[--N];
		a[N] = null;
		if(N > 0 && N == a.length/4)	resize(a.length/2);
		return item;
	}
	public Iterator<Item> iterator()
	{	return new ReverseArrayIterator();}
	
	private class ReverseArrayIterator implements Iterator<Item>
	{
		private int i = N;
		public boolean hasNext(){	return i > 0;}
		public Item next(){	return a[--i];}
		public void remove(){}
	}
	
	public static void main(String[] args)
	{
		ResizingArrayStack<Dog> d = new ResizingArrayStack<Dog>();
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

class Dog
{
	String name = "";
	int age = 0;
	Dog(String name,int age)
	{
		this.name = name;
		this.age = age;
	}
	public String toString()
	{
		return name;
	}
}
