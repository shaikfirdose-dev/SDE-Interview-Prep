
//Given a NxM 2-D matrix, the task to find the sum of all the submatrices.

//T.C : O(N*M)
//S.C : O(1)

package com.firdose.twodarrays;

import java.util.Scanner;

public class SumOfSubMatrix {
	// Here contribution technique used to find all the sum of sub arrray matrix
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m]; 
		for (int i = 0; i < n; i++) {        // matrix input
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println(sumOfAllSubMatrix(n, m, matrix));
	}

	private static int sumOfAllSubMatrix(int n, int m, int[][] matrix) {
		int totalSum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int occurance = (i + 1) * (j + 1) * (n - i) * (m - j); // multiplying no.of TL * no.of BR points
				totalSum = totalSum + matrix[i][j] * occurance;         // then adding amount of contribution of element into totalsum
			}
		}
		return totalSum;
	}

}
