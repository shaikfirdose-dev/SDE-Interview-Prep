//Given N length Array, at every step remove an array element. Cost to remove element = sum of array elements present. Find min cost to remove all the elements.
//
//Note: Add to cost first and then remove.
//
//3
//3 2 5
//
//output: 17

package com.firdose.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class OrderOfRemoval {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {
			ans = ans + (arr[i] * (n - i));
		}
		System.out.println(ans);
	}

}
