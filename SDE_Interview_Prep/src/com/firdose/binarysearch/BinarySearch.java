//Given a sorted array of n integers and a number k, Return true if k is present otherwise return false.

//10
//4 7 10 13 15 20 21 24 26 28
//13
//
//true

package com.firdose.binarysearch;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(binarySearch(arr, n, k));
	}

	private static boolean binarySearch(int[] arr, int n, int k) {
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == k) {
				return true;
			} else if (arr[mid] < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

}
