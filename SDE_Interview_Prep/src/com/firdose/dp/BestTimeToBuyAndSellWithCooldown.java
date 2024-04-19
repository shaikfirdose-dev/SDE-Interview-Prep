//Leetcode(medium): https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
	

package com.firdose.dp;

import java.util.Arrays;

public class BestTimeToBuyAndSellWithCooldown {
	
	//memorization
	//Time Complexity : O(n)
	//Space complexity : O(n)
//	public int maxProfit(int[] prices) {
//		int n = prices.length;
//		int[][] dp = new int[n + 2][2];
//		for (int i = 0; i < n + 2; i++) {
//			Arrays.fill(dp[i], -1);
//		}
//		int ans = helper(prices, 0, 1, dp);
//		return ans;
//	}
//
//	public int helper(int[] prices, int i, int buy, int[][] dp) {
//		if (i >= prices.length) {
//			return 0;
//		}
//		if (dp[i][buy] != -1) {
//			return dp[i][buy];
//		}
//		int profit = 0;
//		if (buy == 1) {
//			int x = -prices[i] + helper(prices, i + 1, 0, dp);
//			int y = 0 + helper(prices, i + 1, 1, dp);
//			profit = Math.max(x, y);
//		} else {
//			int x = prices[i] + helper(prices, i + 2, 1, dp);
//			int y = 0 + helper(prices, i + 1, 0, dp);
//			profit = Math.max(x, y);
//		}
//		dp[i][buy] = profit;
//		return profit;
//	}
	
	
	
	//Tabulation.
	 public int maxProfit(int[] prices) {
	        int n = prices.length;
	        int[][] dp = new int[n+2][2];
	        // for(int i=0;i<n+2;i++){
	        //     Arrays.fill(dp[i],-1);
	        // }
	        int profit = 0;
	        for(int i=n-1;i>=0;i--){
	            for(int buy=0;buy<=1;buy++){
	                if(buy==1){
	                    int x = -prices[i]+dp[i+1][0];
	                    int y = 0 + dp[i+1][1];
	                    dp[i][buy]  = Math.max(x,y);
	                }
	                else{
	                    int x = prices[i]+dp[i+2][1];
	                    int y = 0 + dp[i+1][0];
	                    dp[i][buy] = Math.max(x,y);
	                }
	            }
	        }
	        return dp[0][1];
	    }

}
