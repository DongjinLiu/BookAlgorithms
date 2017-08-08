package µÚÒ»ÕÂÏ°Ìâ;

import edu.princeton.cs.algs4.Counter;

public class pritice129 {
	
	public static int rank(int key,int[] a,Counter counter) {
		int low=0;
		int high=a.length-1;
		int middle;
		while(low<high) {
			middle=(low+high)/2;
			counter.increment();
			if(a[middle]>key) {
				high=middle-1;
			}else if(a[middle]<key) {
				low=middle+1;
			}else {
				return middle;
			}
		}
		return -1;
	}
	
	public static void main(String[] arg) {
		
		Counter counter=new Counter("count");
		int[] datas= {1,2,3,4,5,9,10,15};
		rank(2,datas,counter);
		System.out.println(counter);
	}
}
