package µÚÒ»ÕÂÏ°Ìâ;

public class pritice126 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="abcdefg";
		String b="efgabcd";
		System.out.println(isCircularRotation(a,b));
	}
	
	public static boolean isCircularRotation(String a,String b) {
		if(a.length()!=b.length()) {
			return false;
		}
		String left;
		String right;
		for(int i=1;i<=a.length();i++) {
			left=b.substring(0,i);
			right=b.substring(i);
			//System.out.println(right+left);
			if((right+left).equals(a)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isCircularRotationBest(String a,String b) {
		return a.length()==b.length()&&(a+a).indexOf(b)!=-1;
	}

}
