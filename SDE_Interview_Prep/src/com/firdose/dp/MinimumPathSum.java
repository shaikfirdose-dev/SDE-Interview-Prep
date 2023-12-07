


//Leetcode 64(medium): https://leetcode.com/problems/minimum-path-sum/description/

package com.firdose.dp;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		int ans = helper(grid, m - 1, n - 1, dp);
		return ans;
	}

	private int helper(int[][] grid, int m, int n, int[][] dp) {
		// for negative index
		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}
		// 0th value
		if (m == 0 && n == 0) {
			return grid[0][0];
		}
		if (dp[m][n] != -1) { // dp storing existing values
			return dp[m][n];
		}

		int way1 = helper(grid, m - 1, n, dp);
		int way2 = helper(grid, m, n - 1, dp);

		// memorization
		dp[m][n] = Math.min(way1, way2) + grid[m][n];
		return Math.min(way1, way2) + grid[m][n];
	}

}
