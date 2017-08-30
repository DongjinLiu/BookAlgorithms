package 第二章示例;

/**
 * 堆排序
 * @author jin
 *
 */
public class HeapSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        
        /**
         * 堆的构造
         * 结果：堆有序
         */
        for (int i = n / 2; i >= 1; i--) {
            sink(a, i, n);
        }
        
        /**
         * 下沉排序
         * 结果：已排序
         */
        while (n > 1) {
            exch(a, 1, n--);
            sink(a, 1, n);
        }           
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = temp;
    }

    private static void sink(Comparable[] a, int i, int n) {
        while (2 * i <= n) {
            int j = i * 2;
            if (j < n && less(a, j, j + 1)) {
                j++;
            }
            if (less(a, j, i)) {
                break;
            }
            exch(a, i, j);
            i = j;
        }
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void display(Comparable[] a) {
        for (Comparable i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] array = { 3, 2, 1, 6, 5, 4, 7, 8, 9 };
        //String[] array= {"S","O","R","T","E","X","A","M","P","L","E"};
        display(array);
        sort(array);
        display(array);
    }

}
