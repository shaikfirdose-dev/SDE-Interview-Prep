
//Leetcode(easy): https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//	T.C:O(N)
//	S.C:O(1)


package com.firdose.dp;

public class BestTimeToBuyAndSellStock {

	public int maxProfit(int[] prices) {
		int n = prices.length;
		int maxProfit = 0;
		int minBuyPoint = prices[0];
		for (int i = 1; i < n; i++) {
			int profit = prices[i] - minBuyPoint;
			if (profit > maxProfit) {
				maxProfit = profit;
			}

			minBuyPoint = Math.min(minBuyPoint, prices[i]);
		}
		return maxProfit;
	}

}
