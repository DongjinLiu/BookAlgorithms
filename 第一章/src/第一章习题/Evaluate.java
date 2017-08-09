package µÚÒ»ÕÂÏ°Ìâ;

import edu.princeton.cs.algs4.Stack;

public class Evaluate {

	public static double evaluate(String postfix) {
		Stack<Double> stack=new Stack<Double>();
		double operand1,operand2;
		for(int i=0;i<postfix.length();i++) {
			if(postfix.charAt(i)>=48 && postfix.charAt(i) <= 57) {
				stack.push(Double.valueOf(postfix.charAt(i))-48);
			}else if(postfix.charAt(i)=='+') {
				operand2=stack.pop();
				operand1=stack.pop();
				stack.push(operand1+operand2);
			}else if(postfix.charAt(i)=='-') {
				operand2=stack.pop();
				operand1=stack.pop();
				stack.push(operand1-operand2);
			}else if(postfix.charAt(i)=='*') {
				operand2=stack.pop();
				operand1=stack.pop();
				stack.push(operand1*operand2);
			}else if(postfix.charAt(i)=='/') {
				operand2=stack.pop();
				operand1=stack.pop();
				stack.push(operand1/operand2);
			}
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression="3+(5-2)";
		System.out.println(evaluate(InfixToPostfix.infixToPostfix(expression)));
	}

}
