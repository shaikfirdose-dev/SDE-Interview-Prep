

//Question: Given Array of length n and two integers start and end representing index. 
//Print space separated Subarray of the Array from start idx to end idx.

package com.firdose.arrays;

import java.util.Scanner;

public class PrintSubArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		for (int i = start; i <= end; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
