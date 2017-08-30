package �ڶ���ʾ��;

import java.util.ArrayList;

/**
 * ʹ����������ʵ�����ȶ���
 * @author jin
 *
 */
public class MaxPQByArray {

    private ArrayList<Integer> array = new ArrayList<Integer>();

    public void insert(Integer v) {
        array.add(v);
    }

    public Integer max() {
        int max = 0;
        for (int i = 1; i < array.size(); i++) {
            if (array.get(i) > array.get(max)) {
                max = i;
            }
        }
        return array.remove(max);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MaxPQByArray maxPQ=new MaxPQByArray();
        maxPQ.insert(3);
        maxPQ.insert(5);
        maxPQ.insert(1);
        System.out.println(maxPQ.max());
    }

}
