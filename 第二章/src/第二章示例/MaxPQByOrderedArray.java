package 第二章示例;

import java.util.ArrayList;

/**
 * 使用有序数组实现优先队列
 * @author jin
 *
 */
public class MaxPQByOrderedArray {

    private static ArrayList<Integer> array=new ArrayList<Integer>();
    
    /**
     * 有序插入
     * @param v
     */
    public void insert(Integer v) {
        if(array.size()==0) {
            array.add(v);
        }
        int i=0;
        while(v<array.get(i)) {
            i++;
            if(i>=array.size()) {
                break;
            }
        }
        array.add(i, v);
    }
    
    public Integer max() {
        return array.remove(0);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxPQByOrderedArray maxPQ=new MaxPQByOrderedArray();
        maxPQ.insert(2);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.insert(2);
        maxPQ.insert(8);
        for(Integer i:array) {
            System.out.print(i+" ");
        }
                
        System.out.println("\n"+maxPQ.max());
        System.out.println("\n"+maxPQ.max());
    }

}
