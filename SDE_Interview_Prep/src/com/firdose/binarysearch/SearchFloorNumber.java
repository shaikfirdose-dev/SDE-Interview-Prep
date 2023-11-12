//Question : Given a sorted array of n integers and a number k, Return floor(k).

//input: 
//	9
//	-4 3 4 7 10 11 12 15 19
//	5
//	
//output: 4


package com.firdose.binarysearch;

import java.util.Scanner;

public class SearchFloorNumber {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(floor(arr, n, k));
	}

	private static int floor(int[] arr, int n, int k) {
		int low = 0;
		int high = n - 1;
		int ans = Integer.MIN_VALUE;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == k) {
				return k;
			} else if (arr[mid] < k) {
				ans = arr[mid];
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}
}
