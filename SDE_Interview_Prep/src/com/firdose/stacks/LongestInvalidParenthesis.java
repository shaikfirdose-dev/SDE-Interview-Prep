
//Question (hard): 
//	A student of Algoprep has recently found out about groupings of brackets (sequences of parentheses).
//
//	A balanced parentheses sequence follows the following definition:
//	1. An empty sequence is balanced.
//	2. If R is a balanced sequence, then (R) is also balanced.
//	3. If M and N represent two balanced sequences, then their concatenation MN is also balanced.
//
//	the sequences (), ()() and (())() are balanced, while ()) and ))() are unbalanced.
//
//	Now, you need to find the length of longest unbalanced subsequence of the given string (containing '(' and ')').
//	
//	T.C:O(N)
//	S.C:O(N)


package com.firdose.stacks;

import java.util.Scanner;
import java.util.Stack;

public class LongestInvalidParenthesis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		if (isBalanced(str) == true) {
			System.out.println(str.length() - 1);
		} else {
			System.out.println(str.length());
		}
	}

	private static boolean isBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (stack.isEmpty() || str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				if (str.charAt(i) == ')') {
					if (stack.peek() == '(') {
						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		if (stack.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

}
