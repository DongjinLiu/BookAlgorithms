package 第一章习题;

import 第一章示例.Queue;

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
                //把元素放到队尾，算法太棒了！！！
                //类似于循环链表
                q.enqueue(q.dequeue());
            }
            System.out.println(q.dequeue());
        }    
    }

}
