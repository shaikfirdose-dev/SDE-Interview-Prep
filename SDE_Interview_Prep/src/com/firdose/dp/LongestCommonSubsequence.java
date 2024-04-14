
//Leeetcode(medium):https://leetcode.com/problems/longest-common-subsequence/
//	T.C:O(N*M)
//	S.C:O(N*M)

package com.firdose.dp;

public class LongestCommonSubsequence {

	// Recurtion
	// public int longestCommonSubsequence(String text1, String text2) {
	// int n = text1.length();
	// int m = text2.length();
	// int[][] dp = new int[n][m];
	// for(int i=0;i<n;i++){
	// Arrays.fill(dp[i],-1);
	// }
	// int ans = helper(text1, n-1, text2, m-1, dp);
	// return ans;
	// }

	// public int helper(String s1, int i, String s2, int j, int[][] dp){
	// if(i==-1 || j==-1){
	// return 0;
	// }
	// if(dp[i][j]!=-1){
	// return dp[i][j];
	// }
	// if(s1.charAt(i)==s2.charAt(j)){
	// int x = helper(s1, i-1, s2, j-1, dp);
	// dp[i][j] = x+1;
	// return x+1;
	// }
	// else{
	// int x = helper(s1, i-1, s2, j, dp);
	// int y = helper(s1, i, s2, j-1, dp);
	// dp[i][j] = Math.max(x,y);
	// return Math.max(x,y);
	// }
	// }

	// Iterative solution
	// Time complexity : O(n*m)
	// Space complexity : O(n*m)
	public int longestCommonSubsequence(String text1, String text2) {
		int n = text1.length();
		int m = text2.length();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];

	}

}
