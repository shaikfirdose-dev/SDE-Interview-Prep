
//Leetcode(medium): https://leetcode.com/problems/edit-distance/
//	T.C:O(n*m)
//	S.C:O(n*m)

package com.firdose.dp;

import java.util.Arrays;

public class EditDistance {

	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		int[][] dp = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = helper(word1, word2, n - 1, m - 1, dp);
		return ans;
	}

	public int helper(String s1, String s2, int i, int j, int[][] dp) {
		if (i == -1 && j == -1) {
			return 0;
		}
		if (i == -1 && j != -1) {
			return j + 1;
		}
		if (i != -1 && j == -1) {
			return i + 1;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			int x = helper(s1, s2, i - 1, j - 1, dp);
			dp[i][j] = x;
			return x;
		} else {
			int x = helper(s1, s2, i - 1, j, dp); // delete
			int y = helper(s1, s2, i - 1, j - 1, dp); // replace
			int z = helper(s1, s2, i, j - 1, dp); // insert
			dp[i][j] = Math.min(Math.min(x, y), z) + 1;
			return dp[i][j];
		}
	}

}
