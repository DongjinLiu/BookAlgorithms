package 第二章示例;

/**
 * 使用二叉堆实现优先队列
 * 
 * @author jin
 *
 * @param <Key>
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] pq;
    private int n = 0;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Key v) {
        if ((pq.length - 1) == n) {
            resize(2 * pq.length);
        }
        pq[++n] = v;
        swim(n);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, n--);
        pq[n + 1] = null;
        sink(1);
        if (n > 0 && n == (pq.length / 4)) {
            resize(pq.length / 2);
        }
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    /**
     * 上浮
     * 
     * @param k
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k /= 2;
        }
    }

    /**
     * 下沉
     * 
     * @param k
     */
    private void sink(int k) {
        while (2 * k < n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (less(j, k)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private void resize(int len) {
        Key[] temp = (Key[]) new Comparable[len];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxPQ maxPQ = new MaxPQ(3);
        maxPQ.insert(2);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.insert(2);
        maxPQ.insert(8);

        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ.delMax());
    }

}
