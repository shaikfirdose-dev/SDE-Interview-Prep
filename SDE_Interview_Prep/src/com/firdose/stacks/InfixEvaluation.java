

//Leetcode (medium): https://leetcode.com/problems/basic-calculator-ii/
//	T.C:O(2N)=O(N)
//	S.C:O(N)

package com.firdose.stacks;

import java.util.Stack;

public class InfixEvaluation {

	public int calculate(String s) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int n = s.length();
		int i = 0;
		while (i < n) {

			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				int num = 0;
				while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					num = num * 10 + s.charAt(i) - '0';
					i++;
				}
				operands.push(num);
				i--;
			} else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '/') {
				while (operators.size() > 0 && preceedance(operators.peek()) >= preceedance(s.charAt(i))) {
					char op = operators.pop();
					int val2 = operands.pop();
					int val1 = operands.pop();
					int ans = calC(val1, val2, op);
					operands.push(ans);
				}
				operators.push(s.charAt(i));
			} else {

			}
			i++;
		}
		while (operators.size() > 0) {
			char op = operators.pop();
			int val2 = operands.pop();
			int val1 = operands.pop();
			int ans = calC(val1, val2, op);
			operands.push(ans);
		}
		return operands.pop();
	}

	private static int calC(int a, int b, char ch) {
		if (ch == '+') {
			return a + b;
		} else if (ch == '-') {
			return a - b;
		} else if (ch == '*') {
			return a * b;
		} else {
			return a / b;
		}
	}

	private static int preceedance(char ch) {
		if (ch == '+' || ch == '-') {
			return 0;
		} else {
			return 1;
		}
	}

}
