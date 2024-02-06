
//GFG : https://www.geeksforgeeks.org/problems/postfix-to-prefix-conversion/1
//T.C:O(N)
//S.C:O(N)

package com.firdose.stacks;

import java.util.Stack;

public class PostToPrefix {

	static String postToPre(String post_exp) {
		Stack<String> stack = new Stack<>();
		int i = 0;
		while (i < post_exp.length()) {
			char ch = post_exp.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				String s2 = stack.pop();
				String s1 = stack.pop();
				String res = ch + s1 + s2;
				stack.push(res + "");
			} else {
				stack.push(ch + "");
			}
			i++;
		}
		return stack.pop();
	}

}
