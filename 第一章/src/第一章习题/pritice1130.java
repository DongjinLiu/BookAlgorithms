package µÚÒ»ÕÂÏ°Ìâ;

public class pritice1130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N=20;
		boolean[][] a=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(gcd(i,j)!=0&&gcd(i,j)!=1) {
					a[i][j]=true;
				}else {
					a[i][j]=false;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int gcd(int m,int n) {
		if(n==0) return m;
		int r=m%n;
		return gcd(n,r);
	}
}
