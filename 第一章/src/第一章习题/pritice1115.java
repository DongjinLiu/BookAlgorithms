package µÚÒ»ÕÂÏ°Ìâ;

public class pritice1115 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a= {0,5,2,6,5,4,1,2,3,6,5,4,1};
		int m=7;
		int[] b=histogram(a,m);
		int sum=0;
		for(int i=0;i<b.length;i++) {
			sum+=b[i];
			System.out.println(b[i]);	
		}
		if(sum==a.length) {
			System.out.println("Equal");
		}
	}
	
	public static int[] histogram(int[] a,int m) {
		int[] b=new int[m];
		for(int i=0;i<a.length;i++) {
			b[a[i]]++;
		}
		return b;
	}
}
