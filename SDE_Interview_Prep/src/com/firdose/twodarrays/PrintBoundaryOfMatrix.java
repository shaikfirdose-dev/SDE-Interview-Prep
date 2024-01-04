

package com.firdose.twodarrays;

import java.util.Scanner;

public class PrintBoundaryOfMatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] mat = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		printBoundary(mat);
	}

	private static void printBoundary(int[][] mat) {
		int n = mat.length;
		int i = 0;
		int j = 0;
		for (int k = 0; k < n - 1; k++) {
			System.out.print(mat[i][j] + " ");
			j++;
		}
		for (int k = 0; k < n - 1; k++) {
			System.out.print(mat[i][j] + " ");
			i++;
		}
		for (int k = 0; k < n - 1; k++) {
			System.out.print(mat[i][j] + " ");
			j--;
		}
		for (int k = 0; k < n - 1; k++) {
			System.out.print(mat[i][j] + " ");
			i--;
		}
		return;
	}

}
