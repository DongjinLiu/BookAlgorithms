import java.util.Iterator;
/**
 * Homework week2
 * @author jin
 * Data 2017/8/10
 * Grade 97
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    // construct an empty deque
    public Deque() {
        n = 0;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException("can't add null item");
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            node.next = null;
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        n++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException("can't add null item");
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            node.next = null;
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("can't remove on a empty deque");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("can't remove on a empty deque");
        if (n == 1) {
            return removeFirst();
        }
        Node s = first;
        Item item = last.item;
        while (s.next != last) {
            s = s.next;
        }
        s.next = null;
        last = s;
        n--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return current != null;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Deque<Integer> deque = new Deque<Integer>();
        deque.addFirst(1);
        deque.addLast(2);
        for (Integer i : deque) {
            System.out.println(i);
        }
        System.out.println(deque.size());
    }

}
