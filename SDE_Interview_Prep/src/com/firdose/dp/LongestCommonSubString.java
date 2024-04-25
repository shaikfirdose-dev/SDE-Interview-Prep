//GFG(medium): https://www.geeksforgeeks.org/problems/longest-common-substring1452/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
//T.C:O(N*M)
//S.C:O(N*M)
package com.firdose.dp;

public class LongestCommonSubString {

	int longestCommonSubstr(String S1, String S2, int n, int m) {
		int[][] dp = new int[n + 1][m + 1];
		int maxLen = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					maxLen = Math.max(maxLen, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return (maxLen == Integer.MIN_VALUE) ? 0 : maxLen;
	}

}
