package ��һ��ϰ��;

import ��һ��ʾ��.Queue;

public class Josephus {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=7;
        int m=3;
        Queue<Integer> q=new Queue<Integer>();
        for(int i=0;i<n;i++) {
            q.enqueue(i);
        }
        while(!q.isEmpty()) {
            for(int i=0;i<m-1;i++) {
                //��Ԫ�طŵ���β���㷨̫���ˣ�����
                //������ѭ������
                q.enqueue(q.dequeue());
            }
            System.out.println(q.dequeue());
        }    
    }

}
