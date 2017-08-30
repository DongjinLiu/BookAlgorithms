package 第二章示例;
/**
 * 归并排序（自顶向下、递归）
 * @author jin
 *
 */
public class Merge {
    
    private static Comparable[] aux;
    
    public static void sort(Comparable[] a) {
        aux=new Comparable[a.length];
        sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable[] a,int lo,int hi) {
        if(hi<=lo) return;
        int mid=lo+(hi-lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);
    }
    
    protected static void merge(Comparable[] a,int lo,int mid,int hi) {
        int i=lo;
        int j=mid+1;
        
        for(int k=lo;k<=hi;k++) {
            aux[k]=a[k];
        }
        
        for(int k=lo;k<=hi;k++) {
            if(i>mid) a[k]=aux[j++];
            else if(j>hi) a[k]=aux[i++];
            else if(less(aux[j],aux[i])) a[k]=aux[j++];
            else a[k]=aux[i++];
        }
    }
    
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w)<0;
    }

    public static void display(Comparable[] a) {
        for(Comparable c:a) {
            System.out.print(c);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] array= {3,2,1,6,5,4,7,8,9};
        display(array);
        sort(array);
        display(array);
    }

}
