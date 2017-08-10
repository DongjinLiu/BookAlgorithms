package µÚÒ»ÕÂÏ°Ìâ;

import java.util.Iterator;

public class Steque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(Item item) {
        Node n = new Node();
        n.item = item;
        if (isEmpty()) {
            n.next = null;
            first = n;
            last = n;
        } else {
            n.next = first;
            first = n;
        }
        N++;
    }

    public Item pop() {
        if (isEmpty()) {
            return null;
        } else {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }
    }

    public void enqueue(Item item) {
        Node n = new Node();
        n.item = item;
        if (isEmpty()) {
            n.next = null;
            first = n;
            last = n;
        } else {          
            last.next = n;
            n.next = null;
            last=n;
        }
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Steque<String> steque=new Steque<String>();
        steque.push("first");
        steque.enqueue("second");
        steque.enqueue("third");
        steque.push("123");
        steque.enqueue("666");
//        System.out.println(steque.first.item);
//        System.out.println(steque.last.item);
//        System.out.println(steque.size());
//        System.out.println();
        for(String s:steque) {           
            System.out.println(s);
        }        
    }

}
