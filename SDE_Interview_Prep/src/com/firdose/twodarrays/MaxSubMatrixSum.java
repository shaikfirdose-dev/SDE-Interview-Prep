
//Given a N*M 2-D matrix which is sorted row-wise as well as col-wise, the task to find the sum of submatrix having maximum sum.
//
//Expected Time Complexity: O(N*M), and Solution is not necessarily dp, 
//You will find Dp solution on GFG, you should try to apply something we already learnt
//
//T.C : O(N*M)
//S.C: O(N)

package com.firdose.twodarrays;

import java.util.Scanner;

public class MaxSubMatrixSum {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m];
		for (int i = 0; i < n; i++) { // matrix input
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		int prefixSum[][] = findPrefixSum(n, m, matrix);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int sum = sumOfSubMatrix(i, j, n - 1, m - 1, prefixSum);
				max = Math.max(max, sum);
			}
		}
		System.out.println(max);

	}

	private static int[][] findPrefixSum(int n, int m, int[][] matrix) {
		int prefixSum[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (j == 0) {
					prefixSum[i][j] = matrix[i][j];
				} else {
					prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j];
				}
			}
		}

		for (int j = 0; j < m; j++) {
			for (int i = 1; i < n; i++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j];
			}
		}
		return prefixSum;
	}

	private static int sumOfSubMatrix(int x1, int y1, int x2, int y2, int[][] pfSum) {
		int sum = 0;
		sum = pfSum[x2][y2];
		if (x1 - 1 >= 0) {
			sum = sum - pfSum[x1 - 1][y2];
		}
		if (y1 - 1 >= 0) {
			sum = sum - pfSum[x2][y1 - 1];
		}
		if (x1 - 1 >= 0 && y1 - 1 >= 0) {
			sum = sum + pfSum[x1 - 1][y1 - 1];
		}
		return sum;
	}

}
