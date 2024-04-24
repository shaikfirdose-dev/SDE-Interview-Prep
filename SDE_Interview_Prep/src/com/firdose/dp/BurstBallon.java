
//Leetcode(hard):https://leetcode.com/problems/burst-balloons/
//	T.C:O(N^3)
//	S.C:O(N^2)

package com.firdose.dp;

import java.util.Arrays;

public class BurstBallon {

	public int maxCoins(int[] nums) {
		int n = nums.length;
		int[] arr = new int[n + 2];
		arr[0] = 1;
		arr[n + 1] = 1;
		for (int i = 0; i < n; i++) {
			arr[i + 1] = nums[i];
		}
		int[][] dp = new int[n + 2][n + 2];
		for (int i = 0; i < n + 2; i++) {
			Arrays.fill(dp[i], -1);
		}
		int ans = helper(arr, 0, n + 1, dp);
		return ans;

	}

	public int helper(int[] arr, int s, int e, int[][] dp) {
		if (s + 1 >= e) {
			return 0;
		}
		if (dp[s][e] != -1) {
			return dp[s][e];
		}
		int ans = Integer.MIN_VALUE;
		for (int i = s + 1; i < e; i++) {
			int leftans = helper(arr, s, i, dp);
			int rightans = helper(arr, i, e, dp);
			int myans = leftans + rightans + arr[s] * arr[i] * arr[e];

			ans = Math.max(ans, myans);
		}
		dp[s][e] = ans;
		return ans;

	}

}
