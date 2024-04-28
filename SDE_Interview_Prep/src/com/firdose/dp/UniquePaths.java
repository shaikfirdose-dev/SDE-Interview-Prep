
//Question  LeetCode 62(medium): https://leetcode.com/problems/unique-paths/

//There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
//
//Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
//
//The test cases are generated so that the answer will be less than or equal to 2 * 109
package com.firdose.dp;

public class UniquePaths {

public int uniquePaths(int m, int n) {
	
	//iterative code
//	public int uniquePaths(int m, int n) {
//	     int[][] dp = new int[m][n];
//	     for(int i=0;i<m;i++){
//	        for(int j=0;j<n;j++){
//	            if(i==0 || j==0){
//	                dp[i][j] = 1;
//	            }
//	            else{
//	                dp[i][j] = dp[i-1][j]+dp[i][j-1];
//	            }
//	        }
//	     }  
//	     
//	     return dp[m-1][n-1];
//	    }
        
	//recursive code
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j] = -1;
            }
        }

        int ans = helper(dp,m-1,n-1);
        return ans;
        
    }
    private int helper(int[][] dp, int m, int n){

        if(m<0 || n<0){
            return 0;
        }
        if(m==0 && n==0){
            return 1;
        }
        if(dp[m][n]!=-1){
            return dp[m][n];
        }

        int way1 = helper(dp, m-1, n);
        int way2 = helper(dp, m, n-1);
        dp[m][n] = way1+way2;
        return way1+way2;
    }

}
