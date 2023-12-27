package com.firdose.twodarrays;

import java.util.Scanner;

public class TransposeMatrix {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {        //array input
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		transpose(n, arr);    //transpose function call
		for (int i = 0; i < n; i++) {  // array output
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] transpose(int n, int[][] arr) {  // logic of transpose
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
		return arr;
	}

}
