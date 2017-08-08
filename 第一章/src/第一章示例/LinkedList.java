package µÚÒ»ÕÂÊ¾Àý;

public class LinkedList<Item> {

	private Node first;
	private Node last;
	private int N;
	
	private class Node{
		Item item;
		Node next;
	}
	
	public void add(Item item) {
		Node node=new Node();
		node.item=item;
		node.next=null;
		last.next=node;
		N++;
	}
	
}
