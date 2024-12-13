
//Leetcode(hard): https://leetcode.com/problems/longest-valid-parentheses/
//
//T.C:O(N)
//S.C:O(1)

//brute force : generate all the substrings and finds the valis longest parenthesis substring
//	T.C:O(N^3)
//	S.C:O(N)

package com.firdose.stacks;

public class LongestValidParenthesis {
	//optimal solution
	public int longestValidParentheses(String s) {
		int n = s.length();
		int left = 0;
		int right = 0;
		int maxLen = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				maxLen = Math.max(maxLen, left * 2);
			} else if (right > left) {
				left = 0;
				right = 0;
			}
		}

		left = 0;
		right = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == '(') {
				left++;
			} else {
				right++;
			}
			if (left == right) {
				maxLen = Math.max(maxLen, left * 2);
			} else if (left > right) {
				left = 0;
				right = 0;
			}
		}
		return maxLen;
	}

}
