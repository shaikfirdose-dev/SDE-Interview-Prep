
//Leetcode: https://leetcode.com/problems/coin-change/
//	T.C:O(N*amount)
//	S.C:O(N*amount)
package com.firdose.dp;

import java.util.Arrays;

public class CoinChange {
	// dfs-->memorization
//	public int coinChange(int[] coins, int amount) {
//		int n = coins.length;
//		int[][] dp = new int[n][amount + 1];
//		for (int i = 0; i < n; i++) {
//			Arrays.fill(dp[i], -1);
//		}
//		int ans = helper(n - 1, coins, amount, dp);
//		if (ans >= 1000000000) {
//			return -1;
//		}
//		return ans;
//	}
//
//	public int helper(int i, int[] coins, int amount, int[][] dp) {
//		if (i == 0) {
//			if (amount % coins[i] == 0) {
//				return amount / coins[i];
//			}
//			return 1000000000;
//		}
//		if (amount == 0) {
//			return 0;
//		}
//		if (dp[i][amount] != -1) {
//			return dp[i][amount];
//		}
//
//		int notTake = 0 + helper(i - 1, coins, amount, dp);
//		int take = Integer.MAX_VALUE;
//		if (amount >= coins[i]) {
//			take = 1 + helper(i, coins, amount - coins[i], dp);
//		}
//		dp[i][amount] = Math.min(take, notTake);
//		return Math.min(take, notTake);
//	}

	
	//bfs-->bottom-up approach
	public int coinChange(int[] coins, int amount) {
		int n = coins.length;
		int[][] dp = new int[n][amount + 1];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}

		for (int T = 0; T <= amount; T++) {
			if (T % coins[0] == 0) {
				dp[0][T] = T / coins[0];
			} else {
				dp[0][T] = 1000000000;
			}
		}
		for (int i = 1; i < n; i++) {
			for (int T = 0; T <= amount; T++) {
				int notTake = dp[i - 1][T];
				int take = Integer.MAX_VALUE;
				if (T >= coins[i]) {
					take = 1 + dp[i][T - coins[i]];
				}

				dp[i][T] = Math.min(take, notTake);
			}
		}
		int ans = dp[n - 1][amount];
		if (ans >= 1000000000) {
			return -1;
		}
		return ans;
	}

}
