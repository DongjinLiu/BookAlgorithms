package µÚÒ»ÕÂÊ¾Àý;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{

	private Node first;
	private Node last;
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
	
	public void enqueue(Item item) {
		Node oldLast=last;
		last=new Node();
		last.item=item;
		last.next=null;
		if(isEmpty()) {
			first=last; 
		}else {
			oldLast.next=last;
		}
		N++;
	}
	
	public Item dequeue() {
		Item item=first.item;
		first=first.next;
		if(isEmpty()) {
			last=null;
		}
		N--;
		return item;
	}
	public Item getIndexOf(int k) {
		Node kNode=first;
		for(int i=0;i<k;i++) {
			kNode=kNode.next;
		}
		return kNode.item;
	}
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Item>{

		Node current=first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current!=null;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item=current.item;
			current=current.next;
			return item;
		}
		
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue=new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		//System.out.println(queue.getIndexOf(1));
		for(Integer i:queue) {
			System.out.println(i);
		}
//		queue.dequeue();
//		queue.dequeue();
//		System.out.println();
//		for(Integer i:queue) {
//			System.out.println(i);
//		}
	}
}
