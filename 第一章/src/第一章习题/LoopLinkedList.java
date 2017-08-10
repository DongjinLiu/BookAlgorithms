package 第一章习题;

import java.util.Iterator;

/**
 * 用循环链表求解约瑟夫环
 * 
 * @author jin
 * Date 2017/8/9
 * @param <Item>
 */
public class LoopLinkedList<Item> implements Iterable<Item> {

    protected Node first;
    private Node last;
    protected Node s;
    private int size;

    public LoopLinkedList() {
        size = 0;
    }

    private class Node {
        Item item;
        Node next;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addAtLast(Item item) {

        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = first;
        if (isEmpty()) {
            first = last;
            first.next = first;
            s = last;
        } else {
            oldLast.next = last;
            s = last;
        }
        size++;
    }

    /**
     * delete the node after n
     * 
     * @param n
     */
    public void delete(Node n) {
        Node node = first;
        while (node != n) {
            node = node.next;
        }
        node.next = node.next.next;
        size--;
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
        int n = 7;
        int m = 2;
        LoopLinkedList<Integer> l = new LoopLinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            l.addAtLast(i);
        }

        while(!l.isEmpty()) {
            for (int i = 0; i < m-1; i++) {
                l.s = l.s.next;
            }
            System.out.println(l.s.next.item);
            l.delete(l.s);
        }
    }
}
