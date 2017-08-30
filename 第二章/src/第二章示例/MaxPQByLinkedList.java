package 第二章示例;

public class MaxPQByLinkedList {

    private Node first;
    private Node last;
    private int n;
    
    private class Node{
        Integer i;
        Node next;
    }
    
    public MaxPQByLinkedList() {
        n=0;
    }
    
    public void insert(Integer v) {
        if(isEmpty()) {
            first.i=v;
            first.next=null;
            last=first;
        }
        Node node=new Node();
        node.i=v;
        node.next=null;
        last.next=node;
        last=node;
    }
    
    public Integer max() {
        /**
         * 根据LinkedList.java找出链表中最大的元素，再删除并返回
         */
        return null;
    }
    
    private boolean isEmpty() {
        return n==0;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
