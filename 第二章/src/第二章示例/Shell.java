package µÚ¶þÕÂÊ¾Àý;
/**
 * Ï£¶ûÅÅÐò
 * @author jin
 *
 */
public class Shell {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            System.out.print(h + "-sort:"+"\t");
            show(a);
            h = h / 3;
        }
    }

    public static void show(Comparable[] a) {
        for (Comparable item : a) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] array = { 16, 1, 14, 15, 2, 3, 13, 12, 4, 5, 11, 10, 9, 8, 7, 6 };
        Shell.sort(array);
        System.out.print("answer:\t");
        Shell.show(array);
    }

}
