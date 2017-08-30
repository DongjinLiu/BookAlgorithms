package 第二章示例;
/**
 * 选择排序
 * @author jin
 *
 */
public class Seletion {

    public static void sort(Comparable[] a) {
        int n=a.length;
        for(int i=0;i<n;i++) {
            int min=i;
            for(int j=i+1;j<n;j++) {
                if(less(a[j],a[min])) min=j;
            }
            exch(a,i,min);
            display(a);
        }
    }
    
    private static boolean less(Comparable a,Comparable b) {
        return a.compareTo(b)<0;
    }
    
    private static void exch(Comparable[] a,int i,int j) {
        Comparable temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
    
    public static void display(Comparable[] a) {
        for(Comparable c:a) {
            System.out.print(c+"\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] array = { 16, 1, 14, 15, 2, 3, 13, 12, 4, 5, 11, 10, 9, 8, 7, 6 };
        display(array);
        sort(array);
        display(array);
    }

}
