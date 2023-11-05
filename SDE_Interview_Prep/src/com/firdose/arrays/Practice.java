package com.firdose.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		fre(arr,n);
	}
	private static void fre(int[] arr, int n) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++) {
			if(hm.containsKey(arr[i])) {
				int temp = hm.get(arr[i]);
				hm.put(arr[i], temp+1);
			}
			else {
				hm.put(arr[i], 1);
			}
		}
		System.out.println(hm);
	}

}
