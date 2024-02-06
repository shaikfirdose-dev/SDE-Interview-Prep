
//GFG: https://www.geeksforgeeks.org/problems/infix-to-postfix-1587115620/1?utm_source=gfg

//T.C:O(N)
//S.C:O(N)

package com.firdose.stacks;

import java.util.Stack;

public class InfixToPostfix {

	public static String infixToPostfix(String exp) {
		// Your code here
		Stack<String> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int n = exp.length();
		int i = 0;
		while (i < n) {
			char ch = exp.charAt(i);
			if (ch == '(') {
				operators.push(ch);
			} else if (ch == ')') {
				while (operators.peek() != '(') {
					char op = operators.pop();
					String s2 = operands.pop();
					String s1 = operands.pop();
					String ans = s1 + s2 + op;
					operands.push(ans);
				}
				operators.pop();
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
				while (operators.size() > 0 && precedance(operators.peek()) >= precedance(ch) && operators.peek() != '(') {
					char op = operators.pop();
					String s2 = operands.pop();
					String s1 = operands.pop();
					String ans = s1 + s2 + op;
					operands.push(ans + "");
				}
				operators.push(ch);
			} else {
				operands.push(ch + "");
			}
			i++;
		}
		while (operators.size() > 0) {
			char op = operators.pop();
			String s2 = operands.pop();
			String s1 = operands.pop();
			String ans = s1 + s2 + op;
			operands.push(ans + "");
		}
		return operands.pop();

	}

	private static int precedance(char ch) {
		if (ch == '^') {
			return 2;
		} else if (ch == '*' || ch == '/') {
			return 1;
		}
		return 0;
	}

}
