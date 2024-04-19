
//Leetcode(medium): https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
	

package com.firdose.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellWithTransactionFee {
	
	
	//T.C:O(N)
	//S.C:O(N)
//	public int maxProfit(int[] prices, int fee) {
//		int n = prices.length;
//		int[][] dp = new int[n][2];
//		for (int i = 0; i < n; i++) {
//			Arrays.fill(dp[i], -1);
//		}
//		int ans = helper(prices, 0, 1, dp, fee);
//		return ans;
//	}
//
//	public int helper(int[] prices, int i, int buy, int[][] dp, int fee) {
//		if (i == prices.length) {
//			return 0;
//		}
//		if (dp[i][buy] != -1) {
//			return dp[i][buy];
//		}
//		int profit = 0;
//
//		if (buy == 1) {
//			int x = -prices[i] + helper(prices, i + 1, 0, dp, fee);
//			int y = 0 + helper(prices, i + 1, 1, dp, fee);
//			profit = Math.max(x, y);
//		} else {
//			int x = prices[i] - fee + helper(prices, i + 1, 1, dp, fee);
//			int y = 0 + helper(prices, i + 1, 0, dp, fee);
//			profit = Math.max(x, y);
//		}
//		dp[i][buy] = profit;
//		return profit;
//	}
	
	
	//Space optimized solution
	public int maxProfit(int[] prices, int fee) {
		int n = prices.length;
		int effectiveBuyStock = prices[0];
		int profit = 0;
		
		for(int i=1;i<n;i++) {
			effectiveBuyStock = Math.min(effectiveBuyStock, prices[i]-profit);
			profit = Math.max(profit, prices[i]-effectiveBuyStock-fee);
		}
		return profit;
	}
	
	//another solution
//	 public int maxProfit(int[] prices, int fee) {
//	        int n = prices.length;
//			int effectiveBuyStock = -prices[0];
//			int profit = 0;
//			
//			for(int i=1;i<n;i++) {
//				effectiveBuyStock = Math.max(effectiveBuyStock, profit-prices[i]);
//				profit = Math.max(profit, prices[i]+effectiveBuyStock-fee);
//			}
//			return profit;
//	    }

}
