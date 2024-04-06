
//GFG(medium): https://www.geeksforgeeks.org/problems/stickler-theif-1587115621/1?itm_source=geeksforgeeks
//
//T.C:O(N)
//S.C:O(N)---> dp array and stack space

package com.firdose.dp;

import java.util.Arrays;

public class MaximumSubSequenceSum {
	public int FindMaxSum(int arr[], int n) {
		// Your code here
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		int ans = helper(arr, n - 1, dp);
		return ans;
	}

	public int helper(int[] arr, int n, int[] dp) {
		if (n < 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}

		int x = helper(arr, n - 1, dp);
		int y = helper(arr, n - 2, dp) + arr[n];
		dp[n] = Math.max(x, y);
		return Math.max(x, y);
	}
}
