//Question : Given an array Arr of N positive integers and another number X. 
//		   Determine whether or not there exist two elements in Arr whose sum is exactly X.

package com.firdose.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class PairSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(pairSum(arr, n, k));
	}

	private static String pairSum(int[] arr, int n, int k) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}
		for (int i = 0; i < n; i++) {
			int a = arr[i];
			int b = k - a;
			if (a != b && hm.containsKey(b) == true) {
				return "Y";
			} else if (a == b && hm.get(a) > 1) {
				return "Y";
			}
		}
		return "N";
	}

}
