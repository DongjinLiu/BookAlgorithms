package µÚÒ»ÕÂÏ°Ìâ;

public class pritice1120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.log(Ln(3)));
	}

	public static double Ln(int n) {
		if(n==1) return 1;
		return Ln(n-1)*n;
	}
}
