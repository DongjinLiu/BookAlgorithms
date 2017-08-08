package 第一章习题;

import 第一章示例.Stack;

public class Binary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number=31;
		System.out.println(toBinary(number));
		System.out.println(toBinaryByStack(number));
	}
	
	public static String toBinary(int number) {
		String string="";
		while(number>0) {
			string=number%2+string;
			number/=2;
		}
		return string;
	}
	
	public static String toBinaryByStack(int number) {
		Stack<Integer> stack=new Stack<Integer>();
		while(number>0) {
			stack.push(number%2);
			number/=2;
		}
		String string="";
		for(Integer i:stack) {
			string+=i.toString();
		}
		return string;
	}
}
