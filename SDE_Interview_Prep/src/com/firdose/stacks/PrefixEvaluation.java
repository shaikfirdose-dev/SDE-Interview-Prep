
//T.C : O(N)
//S.C:O(N)


package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		System.out.println(prefixEvaluation(exp));
	}

	private static int prefixEvaluation(String exp) {
		Stack<Integer> stack = new Stack<>();
		int i = exp.length() - 1;
		while (i >= 0) {
			char ch = exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				int s1 = stack.pop();
				int s2 = stack.pop();
				int ans = calculate(s1, s2, ch);

				stack.push(ans);
			} else {
				stack.push(ch - '0');
			}
			i--;
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
