package µÚÒ»ÕÂÏ°Ìâ;

public class pritice1111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] array= {{true,false,true},{false,false,true},{true,true,false}};
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(i==0) {
					System.out.print(j);
				}else if(j==0) {
					System.out.print(i);
				}else {
					if(array[i-1][j-1]) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}
				if(j==3) {
					System.out.println();
				}
			}
		}
	}

}
