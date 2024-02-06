
//T.c : O(N)
//S.C : O(N)

package com.firdose.stacks;

import java.util.Stack;

public class PrefixToPostfix {
	static String preToPost(String pre_exp) {
		Stack<String> stack = new Stack<>();
		int i = pre_exp.length() - 1;
		while (i >= 0) {
			char ch = pre_exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				String s1 = stack.pop();
				String s2 = stack.pop();
				String ans = s1 + s2 + ch;
				stack.push(ans + "");
			} else {
				stack.push(ch + "");
			}
			i--;
		}
		return stack.pop();

	}

}
