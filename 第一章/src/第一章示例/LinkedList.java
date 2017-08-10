package µÚÒ»ÕÂÊ¾Àý;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {

    protected Node first;
    private Node last;
    protected Node s;
    private int N;

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void addAtfirst(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        if (isEmpty()) {
            first.next = null;
            last = first;
        } else {
            first.next = oldfirst;
        }
        N++;
    }

    public void addAtLast(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public void addAt(int i, Item item) {
        if (i > N - 1 || i < 0) {
            return;
        }
        if (i == 0) {
            addAtfirst(item);
            return;
        }
        s = first;
        for (int j = 0; j < i - 1; j++) {
            s = s.next;
        }
        Node n = new Node();
        n.item = item;
        n.next = s.next;
        s.next = n;
        N++;
    }

    public void deleteFirst() {
        if (first == null) {
            return;
        } else {
            first = first.next;
        }
        N--;
    }

    public void deleteLast() {
        s = first;
        while (s.next != last) {
            s = s.next;
        }
        s.next = null;
        last = s;
        N--;
    }

    public void deleteAt(int i) {
        if (i > N - 1 || i < 0) {
            return;
        }
        if (i == 0) {
            deleteFirst();
            return;
        }
        if (i == N - 1) {
            deleteLast();
            return;
        }
        s = first;
        for (int j = 0; j < i - 1; j++) {
            s = s.next;
        }
        s.next = s.next.next;
        N--;
    }

    public Item get(int i) {
        s = first;
        for (int j = 0; j < i; j++) {
            s = s.next;
        }
        return s.item;
    }

    public boolean find(Item item) {
        s = first;
        for (int i = 0; i < N; i++) {
            if (s.item == item) {
                return true;
            } else {
                s = s.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<Item> iterator() {
        // TODO Auto-generated method stub
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

        Node current = first;

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
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.addAtfirst(1);
        l.addAtfirst(2);
        l.addAtLast(3);
        // for(int i=0;i<l.size();i++) {
        // System.out.println(l.get(i));
        // }
        l.deleteLast();
        l.addAtLast(5);
        // System.out.println(l.size());
        // System.out.println(l.get(1));
        for (Integer i : l) {
            System.out.println(i);
        }
        System.out.println(l.find(5));
    }
}
