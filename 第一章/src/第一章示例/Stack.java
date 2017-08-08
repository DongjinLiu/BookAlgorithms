package ��һ��ʾ��;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>{

	private Node first;
	private int N;
	private class Node{
		Item item;
		Node next;
	}
	public boolean isEmpty() {
		return first==null;
	}
	public int size() {
		return N;
	}
	public void push(Item item) {
		Node oldFirst=first;
		first=new Node();
		first.item=item;
		first.next=oldFirst;
		N++;
	}
	public Item pop() {
		if(isEmpty()) {
			return null;
		}
		Item item=first.item;
		first=first.next;
		N--;
		return item;
	}
	
	public Iterator<Item> iterator(){
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{
		private Node current=first;
		public boolean hasNext() {
			return current!=null;
		}
		public void remove() {
			
		}
		public Item next() {
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack=new Stack<String>();
		stack.push("first");
		stack.push("second");
		stack.push("third");
		for(String string:stack) {
			System.out.println(string);
		}
		stack.pop();
		System.out.println();
		for(String string:stack) {
			System.out.println(string);
		}
	}
}
