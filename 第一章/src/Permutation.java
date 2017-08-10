import edu.princeton.cs.algs4.StdIn;
/**
 * Homework week2 
 * @author jin
 * Date 2017/8/10
 * Grade 97
 */
public class Permutation {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedQueue<String> q = new RandomizedQueue<String>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            q.enqueue(StdIn.readString());
        }
        for (int i = 0; i < k; i++) {
            System.out.println(q.dequeue());
        }
    }

}
