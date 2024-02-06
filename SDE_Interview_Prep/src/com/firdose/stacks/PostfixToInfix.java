
//T.C : O(N)
//S.C: O(N)

package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class PostfixToInfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exp = sc.nextLine();
		System.out.println(postfixToInfix(exp));
	}

	private static String postfixToInfix(String exp) {
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < exp.length()) {
			char ch = exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				String s2 = stack.pop();
				String s1 = stack.pop();
				String ans = "(" + s1 + ch + s2 + ")";
				stack.push(ans + "");
			} else {
				stack.push(ch + "");
			}
			i++;
		}
		return stack.pop();
	}
}
