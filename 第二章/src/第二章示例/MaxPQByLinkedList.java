package �ڶ���ʾ��;

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
         * ����LinkedList.java�ҳ�����������Ԫ�أ���ɾ��������
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
