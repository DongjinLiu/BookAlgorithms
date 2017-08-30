package 第二章示例;
/**
 * 快速排序
 * @author jin
 *
 */
public class Quick {

    public static void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable[] a,int lo,int hi) {
        if(hi<=lo) return;
        int j=partition(a,lo,hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }
    
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi)
                    break;
            while (less(v, a[--j]))
                if (j == lo)
                    break;
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void display(Comparable[] a) {
        for (Comparable c : a) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] array = { 5, 2, 3, 1, 6, 9, 8, 7, 4 };
        display(array);
        sort(array);
        display(array);
    }

}
