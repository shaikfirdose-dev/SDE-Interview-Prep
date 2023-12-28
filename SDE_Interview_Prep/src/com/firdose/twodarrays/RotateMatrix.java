

//Leetcode 48:https://leetcode.com/problems/rotate-image/

package com.firdose.twodarrays;

import java.util.Scanner;

public class RotateMatrix {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[n][n];
		for (int i = 0; i < n; i++) {        //array input
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		rotate(matrix);    //transpose function call
		
	}

	public static void rotate(int[][] matrix) {    // matrix rotating by 90 degrees
		int n = matrix.length;
		transpose(matrix);             // transpose function call
		for (int i = 0; i < n; i++) {
			int st = 0;
			int end = matrix[i].length - 1;
			while (st <= end) {					// rotating each row
				int temp = matrix[i][st];
				matrix[i][st] = matrix[i][end];
				matrix[i][end] = temp;
				st++;
				end--;
			}
		}

		for (int i = 0; i < n; i++) {			// printing output matrix
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static void transpose(int[][] matrix) {					//transpose function call
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		return;
	}

}
