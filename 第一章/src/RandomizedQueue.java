import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;
/**
 * Homework week2
 * @author jin
 * Date 2017/8/10
 * Grade 97
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int n;

    private class Node {
        private Item item;
        private Node next;
    }

    // construct an empty randomized queue
    public RandomizedQueue() {
        n = 0;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException();
        Node node = new Node();
        node.item = item;
        if (isEmpty()) {
            node.next = null;
            first = node;
            last = node;
        } else {
            node.next = null;
            last.next = node;
            last = node;
        }
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("can't remove on a empty deque");
        if (n == 1) {
            return removeFirst();
        }
        int r = StdRandom.uniform(n);
        if (r == 0) {
            return removeFirst();
        }
        if (r == n - 1) {
            return removeLast();
        }
        Node s = first;
        for (int i = 0; i < r - 1; i++) {
            s = s.next;
        }
        Item item = s.next.item;
        s.next = s.next.next;
        n--;
        return item;
    }

    private Item removeFirst() {
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    private Item removeLast() {
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

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException("can't get a sample on a empty deque");
        Node s = first;
        int r = StdRandom.uniform(n);
        for (int i = 0; i < r; i++) {
            s = s.next;
        }
        return s.item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {

        private int index = 0;
        private Item[] r;
        Node s = first;
        public QueueIterator() {
            r = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                r[i] = s.item;
                s = s.next;
            }
            StdRandom.shuffle(r);
        }

        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return index < n;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }

        @Override
        public Item next() {
            // TODO Auto-generated method stub
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            Item item = r[index++];
            return item;
        }

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedQueue<Integer> q = new RandomizedQueue<Integer>();
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(1);
        q.enqueue(3);
        for (Integer i : q) {
            System.out.println(i);
        }
        System.out.println();
        for (Integer i : q) {
            System.out.println(i);
        }
    }

}
