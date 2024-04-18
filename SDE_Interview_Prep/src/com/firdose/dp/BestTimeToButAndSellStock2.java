
//Leetcode(medium): https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//	T.C:O(N)
//	S.C:O(N)

package com.firdose.dp;

public class BestTimeToButAndSellStock2 {
	
	
	//optimal solution
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int profit = 0;
		for (int i = 1; i < n; i++) {
			if (prices[i] > prices[i - 1]) {
				profit = profit + (prices[i] - prices[i - 1]);
			}
		}
		return profit;
	}

}
