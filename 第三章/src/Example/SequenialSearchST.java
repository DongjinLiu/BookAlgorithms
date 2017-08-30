package Example;

import java.util.ArrayList;

/**
 * 基于无序链表的符号表 顺序查找
 * 
 * @author jin
 *
 * @param <Key>
 * @param <Value>
 */
public class SequenialSearchST<Key, Value> {
    private Node first;
    private int n;
    private ArrayList<Key> keyArray = new ArrayList<Key>();

    public SequenialSearchST() {
        n = 0;
    }

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 获取key的值，如果key不存在则返回null
     * 
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (isEmpty())
            return null;
        for (Node node = first; node != null; node = node.next) {
            if (node.key == key) {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 更新键的值或者添加新的元素
     * 
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        for (Node node = first; node != null; node = node.next) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
        keyArray.add(key);
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * 删除元素
     * 
     * @param key
     */
    public void delete(Key key) {
        if (isEmpty())
            return;
        if (first.key == key) {
            first = first.next;
            keyArray.remove(key);
            n--;
            return;
        }
        for (Node node = first; node != null; node = node.next) {
            if (node.next.key == key) {
                node.next = node.next.next;
                keyArray.remove(key);
                n--;
                return;
            }
        }
    }

    public Iterable<Key> keys() {
        return keyArray;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SequenialSearchST<String, Integer> st = new SequenialSearchST();
        st.put("A", 1);
        st.put("C", 3);
        System.out.println(st.get("C"));
        st.put("B", 2);
        st.delete("C");
        System.out.println(st.get("A"));
        System.out.println(st.keys());
        System.out.println(st.size());
    }
}
