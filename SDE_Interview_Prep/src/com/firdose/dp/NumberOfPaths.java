

//Question: The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right or down.
//
//mat[i][j] == 0 represents blocked cell and mat[i][j] == 1 represents unblocked cell and you can't move via blocked cell.


package com.firdose.dp;

import java.util.Scanner;

public class NumberOfPaths {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int mat[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		int dp[][] = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(numberOfPaths(mat, m - 1, n - 1, dp));
	}

	private static int numberOfPaths(int[][] mat, int m, int n, int[][] dp) {

		if (m < 0 || n < 0) {
			return 0;
		}
		if (m == 0 && n == 0) {
			return 1;
		}
		if (mat[m][n] == 0) {
			return 0;
		}
		if (dp[m][n] != -1) {
			return dp[m][n];
		}

		int way1 = numberOfPaths(mat, m - 1, n, dp);
		int way2 = numberOfPaths(mat, m, n - 1, dp);
		dp[m][n] = way1 + way2;
		return way1 + way2;
	}

}
