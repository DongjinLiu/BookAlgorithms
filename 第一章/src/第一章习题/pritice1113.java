package µÚÒ»ÕÂÏ°Ìâ;

public class pritice1113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a= {
				{1,2,3,4},
				{1,2,3,4}
				};
		int[][] b=new int[4][2];
		
		for(int i=0;i<2;i++) {
			for(int j=0;j<4;j++) {
				b[j][i]=a[i][j];
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<2;j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}

}
