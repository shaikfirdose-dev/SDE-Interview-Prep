
//Leetcode (medium): https://leetcode.com/problems/evaluate-reverse-polish-notation/

//T.C : O(N)
//S.C: O(N)

package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class ReversePoliseNotation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] tokens = new String[n];
		for (int i = 0; i < n; i++) {
			tokens[i] = sc.next();
		}
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < tokens.length) {
			if (tokens[i].length() == 1 && tokens[i].charAt(0) < 48) {
				int val2 = stack.pop();
				int val1 = stack.pop();
				int res = calculate(val1, val2, tokens[i].charAt(0));
				stack.push(res);
			} else {
				int val = Integer.parseInt(tokens[i]);
				stack.push(val);
			}
			i++;
		}
		return stack.pop();

	}

	private static int calculate(int a, int b, char ch) {
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

}
