
//Leetcode(medium):https://leetcode.com/problems/longest-palindromic-subsequence/
//	T.c:O(n*n)
//	S.C:O(n*n)

package com.firdose.dp;

import java.util.Arrays;

public class LongestPallindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		int i = 0;
		int j = n - 1;
		while (i < j) {
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		String s1 = "".valueOf(arr);

		int[][] dp = new int[n][n];
		for (int k = 0; k < n; k++) {
			Arrays.fill(dp[k], -1);
		}

		int ans = helper(s, n - 1, s1, n - 1, dp);
		return ans;
	}

	public int helper(String s1, int i, String s2, int j, int[][] dp) {

		if (i == -1 || j == -1) {
			return 0;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			int x = helper(s1, i - 1, s2, j - 1, dp);
			dp[i][j] = x + 1;
			return x + 1;
		} else {
			int x = helper(s1, i - 1, s2, j, dp);
			int y = helper(s1, i, s2, j - 1, dp);
			dp[i][j] = Math.max(x, y);
			return Math.max(x, y);
		}
	}

}
