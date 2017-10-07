package algorithms.one;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
{
	private Node first;	// recently added element
	private int N;		// elements number
	
	private class Node
	{
		Item item;
		Node next;
	}
	
	public boolean isEmpty(){return first == null;}
	public int size(){return N;}
	public void push(Item item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
		N++;
	}
	public Item pop()
	{
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	@Override
	public Iterator<Item> iterator()
	{
		
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>
	{
		private Node current = first;
		public boolean hasNext()
		{return current != null;}
		public void remove(){}
		public Item next()
		{
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
	
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
