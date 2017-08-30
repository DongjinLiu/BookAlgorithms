package 第二章示例;
/**
 * 归并排序（自底向上、非递归）
 * @author jin
 *
 */
public class MergeBU {

    private static Comparable[] aux;
    
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
    
    public static void sort(Comparable[] a) {
        int N=a.length;
        aux=new Comparable[N];
        for(int sz=1;sz<N;sz=sz*2) {
            for(int lo=0;lo<N-sz;lo+=sz*2) {
                merge(a, lo, lo+sz-1, Math.min(lo+sz*2-1, N-1));
            }
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] array= {3,2,1,6,5,4,7,8,9};
        Merge.display(array);
        sort(array);
        Merge.display(array);
    }

}
