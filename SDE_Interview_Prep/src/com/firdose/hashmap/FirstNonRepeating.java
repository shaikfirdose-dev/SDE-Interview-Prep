//Question  : Find the first non-repeating element in a given array arr of N integers.

package com.firdose.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class FirstNonRepeating {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(firstNonRepeat(arr, n));

	}

	private static int firstNonRepeat(int[] arr, int n) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (hm.containsKey(arr[i])) {
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp + 1);
			} else {
				hm.put(arr[i], 1);
			}
		}

		for (int v : arr) {
			if (hm.get(v) == 1) {
				return v;
			}
		}
		return -1;
	}

}
