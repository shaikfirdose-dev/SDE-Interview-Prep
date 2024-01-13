
//Question : Given an array arr[] of N positive elements in which every element is repeating 4 times but 1 element is repeating 2 times. 
//			Find the element repeating 2 times.
//			
//			T.C:O(32*N)=O(N)
//			S.C: O(1)

package com.firdose.bitmanupulation;

import java.util.Scanner;

public class DoubleElement2 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(doubleElement2(arr));
	}

	private static int doubleElement2(int[] arr) {
		int ans = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (checkBit(arr[j], i) == true) {
					count++;
				}
			}
			if (count % 4 == 2) {
				ans = ans + (1 << i);
			}
		}
		return ans;
	}

	private static boolean checkBit(int n, int i) {
		if ((n & (1 << i)) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
