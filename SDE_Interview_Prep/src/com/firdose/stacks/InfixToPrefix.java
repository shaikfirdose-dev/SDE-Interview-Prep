

//T.C:O(N)
//S.C:O(N)

package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPrefix {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(infixToPrefix(s));
	}
	private static String infixToPrefix(String s) {
		Stack<String> operand = new Stack<>();
		Stack<Character> operator = new Stack<>();
		int n = s.length();
		int i=0;
		while(i<n) {
			char ch = s.charAt(i);
			if(ch=='(') {
				operator.push(ch);
			}
			else if(ch==')') {
				while(operator.peek()!='(') {
					char op = operator.pop();
					String s2 = operand.pop();
					String s1 = operand.pop();
					String res = op+s1+s2;
					operand.push(res+"");
				}
				operator.pop();
			}
			else if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^') {
				while(operator.size()>0 && precedence(operator.peek())>=precedence(ch) && operator.peek()!='(') {
					char op = operator.pop();
					String s2= operand.pop();
					String s1 = operand.pop();
					String res = op+s1+s2;
					operand.push(res+"");
				}
				operator.push(ch);
			}
			else {
				operand.push(ch+"");
			}
			i++;
		}
		while(operator.size()>0) {
			char op = operator.pop();
			String s2 = operand.pop();
			String s1 = operand.pop();
			String res = op+s1+s2;
			operand.push(res+"");
		}
		return operand.pop();
	}
	private static int precedence(char ch) {
		if(ch=='^') {
			return 2;
		}
		else if(ch=='*' || ch=='/') {
			return 1;
		}
		return 0;
	}

}
