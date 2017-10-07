package algorithms.one;

import java.util.Iterator;


public class Queue<Item> implements Iterable<Item>
{
	private Node first;
	private Node last;
	private int N;
	private class Node
	{
		Item item;
		Node next;
	}
	public boolean isEmpty(){	return first == null;}
	public int size(){ return N;}
	public void enqueue(Item item)
	{
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) 
			first = last;
		else 
			oldlast.next = last;
		N++;
	}
	public Item dequeue()
	{
		Item item = first.item;
		first = first.next;
		if(isEmpty())
			last = null;
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
		Queue<Dog> d = new Queue<Dog>();
		Dog d1 = new Dog("Smith", 1);
		Dog d2 = new Dog("Tom", 2);
		Dog d3 = new Dog("Jerry", 3);
		d.enqueue(d1);
		d.enqueue(d2);
		d.enqueue(d3);
		System.out.println("first:" + d.dequeue());
		System.out.println("Second:" + d.dequeue());
		System.out.println("Third:" + d.dequeue());
	}
}
