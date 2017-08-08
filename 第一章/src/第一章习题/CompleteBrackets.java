package 第一章习题;
import 第一章示例.Stack;

public class CompleteBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="1+2)*3-4)*5-6)))";
		String a,b,c;
		Stack<String> stack=new Stack<String>();
		for(int i=0;i<string.length();i++) {
			if(string.toCharArray()[i]!=')') {
				stack.push(String.valueOf(string.toCharArray()[i]));
			}else {
				a=stack.pop();
				b=stack.pop();
				c=stack.pop();
				stack.push("("+c+b+a+")");
			}
		}
		string=stack.pop();
		System.out.println(string);
	}

}
