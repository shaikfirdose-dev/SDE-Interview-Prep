//Question : Given an array arr[] of length N, The task is to count all distinct elements in arr[].

package com.firdose.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class CountDistinctElements {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(countDistinctEle(arr, n));
	}

	private static int countDistinctEle(int[] arr, int n) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}
		return hm.size();
	}

}
