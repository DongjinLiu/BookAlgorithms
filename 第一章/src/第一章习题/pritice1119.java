package µÚÒ»ÕÂÏ°Ìâ;

public class pritice1119 {
	
	static int[] f=new int[100];


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f[0]=0;
		f[1]=1;
		for(int n=0;n<100;n++) {
			System.out.println(n+" "+F(n));
		}
	}
	
	public static long F (int n){
		if(n==0) return 0;
		if(n==1) return 1;
		f[n]=f[n-1]+f[n-2];
		return f[n];
	}
}
