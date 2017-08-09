package 第一章习题;

import edu.princeton.cs.algs4.Stack;

public class InfixToPostfix {

	public static int priority(char c) {
		switch (c) {
		case '(':
			return 0;
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}

	public static String infixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> operation = new Stack<Character>();
		for (int i = 0; i < infix.length(); i++) {
			if (infix.charAt(i) >= 48 && infix.charAt(i) <= 57) {
			    //数字直接add到postfix
				postfix += infix.charAt(i);
			} else if (infix.charAt(i) == '(') {
			    //'('直接push
				operation.push('(');
			} else if (infix.charAt(i) == ')') {
				char temp;
				while (!operation.isEmpty()) {
					temp = operation.pop();
					if (temp != '(') {
						postfix += temp;
					} else {
						break;
					}
				}
				continue;
			}else {
				while (!operation.isEmpty() && priority(operation.peek()) >= priority(infix.charAt(i))) {
					postfix += operation.pop();
				}
				operation.push(infix.charAt(i));	
			}
		}
		while (!operation.isEmpty()) {
			postfix += operation.pop();
		}
		return postfix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String str="(1+2)*(3-1)";
		String str = "3+(5-2)";
		System.out.println(infixToPostfix(str));
	}

}
