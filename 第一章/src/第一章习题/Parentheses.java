package 第一章习题;

import 第一章示例.Stack;

public class Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test="[]{[([)()]}";
		Stack<Character> parentheses=new Stack<Character>();
		char[] testArray=test.toCharArray();
		for(int i=0;i<test.length();i++) {
			if(testArray[i]=='('||testArray[i]=='{'||testArray[i]=='[') {
				parentheses.push(testArray[i]);
			}else if(testArray[i]==')'&&parentheses.pop()!='(') {
				System.out.println(false);
				return;
			}else if(testArray[i]==']'&&parentheses.pop()!='[') {
				System.out.println(false);
				return;
			}else if(testArray[i]=='}'&&parentheses.pop()!='{') {
				System.out.println(false);
				return;
			}
		}
		System.out.println(true);
	}

}
