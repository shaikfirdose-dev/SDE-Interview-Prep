
//Leeetcode(Hard): https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSell3 {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][][] dp = new int[n][2][3];
		for (int i = 0; i < n; i++) {
			for (int buy = 0; buy < 2; buy++) {
				Arrays.fill(dp[i][buy], -1);
			}
		}
		int ans = helper(prices, 0, 1, 2, dp);
		return ans;
	}

	public int helper(int[] prices, int i, int buy, int cap, int[][][] dp) {
		if (i == prices.length) {
			return 0;
		}
		if (cap == 0) {
			return 0;
		}
		if (dp[i][buy][cap] != -1) {
			return dp[i][buy][cap];
		}
		int profit = 0;
		if (buy == 1) {
			int x = -prices[i] + helper(prices, i + 1, 0, cap, dp);
			int y = 0 + helper(prices, i + 1, 1, cap, dp);
			profit = Math.max(x, y);
		} else {
			int x = prices[i] + helper(prices, i + 1, 1, cap - 1, dp);
			int y = 0 + helper(prices, i + 1, 0, cap, dp);
			profit = Math.max(x, y);
		}

		dp[i][buy][cap] = profit;
		return profit;
	}

}
