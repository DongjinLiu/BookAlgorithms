package Example;

import edu.princeton.cs.algs4.Queue;

/**
 * ���ڶ��ֲ��ҵķ��ű� ��������
 * 
 * @author jin
 *
 * @param <Key>
 * @param <Value>
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int n;

    public BinarySearchST(int capacity) {
        n = 0;
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return n;
    }

    public int size(Key lo, Key hi) {
        int i = rank(lo);
        int j = rank(hi);
        return j - i + 1;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * ��ȡkey��Ӧ��value ���key�������򷵻�null
     * 
     * @param key
     * @return
     */
    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }

    /**
     * ���Ҽ����ҵ�����¼�ֵ�����򴴽��µ�Ԫ��
     * 
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        if (n == keys.length) {
            resize(keys.length * 2);
        }
        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    /**
     * ɾ��Ԫ��
     * 
     * @param key
     */
    public void delete(Key key) {
        if (isEmpty())
            return;
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            for (int j = i; j < n - 1; j++) {
                keys[j] = keys[j + 1];
                values[j] = values[j + 1];
            }
            keys[n - 1] = null;
            values[n - 1] = null;
            n--;
        }

        if (n > 0 && n == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[n - 1];
    }

    /**
     * �жϼ��Ƿ�����ڱ���
     * 
     * @param key
     * @return
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     * ��������Ϊk�ļ�
     * 
     * @param k
     * @return
     */
    public Key select(int k) {
        return keys[k];
    }

    /**
     * ���ش��ڵ���key����С��
     * 
     * @param key
     * @return
     */
    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    /**
     * ����С�ڵ���key������
     * 
     * @param key
     * @return
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        } else {
            return keys[i - 1];
        }
    }

    /**
     * �������м�
     * 
     * @return
     */
    public Queue<Key> keys() {
        return keys(keys[0], keys[n - 1]);
    }

    /**
     * ���ش� lo �� hi �����м�
     * 
     * @param lo
     * @param hi
     * @return
     */
    public Queue<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[rank(hi)]);
        }
        return q;
    }

    /**
     * С��key�ļ�������
     * 
     * @param key
     * @return
     */
    private int rank(Key key) {
        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    /**
     * ���·��������С
     * 
     * @param len
     */
    private void resize(int len) {
        Key[] keyTemp = (Key[]) new Comparable[len];
        Value[] valueTemp = (Value[]) new Object[len];
        for (int i = 0; i < n; i++) {
            keyTemp[i] = keys[i];
            valueTemp[i] = values[i];
        }
        keys = keyTemp;
        values = valueTemp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinarySearchST<String, Integer> st = new BinarySearchST(3);
        st.put("A", 1);
        st.put("C", 3);
        st.put("C", 5);
        st.put("B", 2);
        st.put("F", 6);
        st.put("G", 8);
        st.delete("F");
        st.deleteMin();
        System.out.println(st.keys());
    }

}
