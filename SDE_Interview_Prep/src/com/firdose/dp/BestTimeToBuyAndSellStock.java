
//Leetcode(easy): https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//	T.C:O(N)
//	S.C:O(1)


package com.firdose.dp;

public class BestTimeToBuyAndSellStock {
	
	//space optimized solution
//	T.C:O(N)
//	S.C:O(1)
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
	
	
	
	 //     //memorisation
//	T.C:O(n)
//	S.C:O(N)
    //     int n = prices.length;
    //     int[][] dp = new int[n][2];
    //     for(int i=0;i<n;i++){
    //         Arrays.fill(dp[i], -1);
    //     }
    //     int ans = helper(prices, 0, 1, 1, dp);
    //     return ans;
    // }

    // public int helper(int[] prices, int i, int buy, int cap, int[][] dp){
    //     if(i==prices.length){
    //         return 0;
    //     }
    //     if(cap==0){
    //         return 0;
    //     }
    //     if(dp[i][buy]!=-1){
    //         return dp[i][buy];
    //     }
    //     int profit = 0;
    //     if(buy==1){
    //         int x = -prices[i]+helper(prices, i+1, 0, cap, dp);
    //         int y = 0 + helper(prices, i+1, 1, cap, dp);
    //         profit = Math.max(x,y);
    //     }
    //     else{
    //         int x = prices[i] + helper(prices, i+1, 1, cap-1,dp);
    //         int y = 0 + helper(prices, i+1, 0, cap, dp);
    //         profit = Math.max(x,y);
    //     }
    //     dp[i][buy] = profit;
    //     return profit;
//    }

}
