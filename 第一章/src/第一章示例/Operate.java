package µÚÒ»ÕÂÊ¾Àý;

import java.util.Stack;

public class Operate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> ops=new Stack<String>();
		Stack<Double> vals=new Stack<Double>();
		
		String expression="(1+((2+3)+(4*5)))";
		//String expression="(1+2)";
		char[] expressionArray=expression.toCharArray();
		
		for(int i=0;i<expressionArray.length;i++) {
			//System.out.println(expressionArray[i]);
			if(expressionArray[i]=='(') ;
			else if(expressionArray[i]=='+') ops.push("+");
			else if(expressionArray[i]=='-') ops.push("-");
			else if(expressionArray[i]=='*') ops.push("*");
			else if(expressionArray[i]=='/') ops.push("/");
			else if(expressionArray[i]==')') {
				String operation=ops.pop();
				double v=vals.pop();
				if(operation.equals("+")) v=vals.pop()+v;
				else if(operation.equals("-")) v=vals.pop()-v;
				else if(operation.equals("*")) v=vals.pop()*v;
				else if(operation.equals("/")) v=vals.pop()/v;
				vals.push(v);
			}else {
				vals.push(Double.valueOf(expressionArray[i])-48);
			}
		}
		System.out.println(vals.pop());
	}

}
