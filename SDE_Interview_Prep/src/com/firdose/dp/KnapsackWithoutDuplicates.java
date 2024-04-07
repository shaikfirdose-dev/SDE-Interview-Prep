
//GFG(medium): https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?itm_source=geeksforgeeks
//	T.C:O(N*W)
//	S.C:O(N*W)


package com.firdose.dp;

import java.util.Arrays;

public class KnapsackWithoutDuplicates {
	static int knapSack(int W, int wt[], int val[], int n) {
		// your code here
		int dp[][] = new int[n][W + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = helper(W, wt, val, n - 1, dp);
		return ans;

	}

	static int helper(int W, int[] wt, int[] val, int n, int[][] dp) {
		if (n < 0 || W == 0) {
			return 0;
		}
		if (dp[n][W] != -1) {
			return dp[n][W];
		}
		int x = helper(W, wt, val, n - 1, dp);   //leave the last index weight
		int y = -1;
		if (W >= wt[n]) {
			y = helper(W - wt[n], wt, val, n - 1, dp) + val[n];  // pick the last index weight
		}
		dp[n][W] = Math.max(x, y);    // store the max value of 
		return Math.max(x, y);
	}

}
