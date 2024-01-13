
//Question : Given an array arr[] of N positive elements in which every element is repeating four times but 1 element is repeating 1 time. 
//			Find the element repeating 1 time.
//			
//			T.C: O(N)
//			S.C: O(1)

package com.firdose.bitmanupulation;

import java.util.Scanner;

public class SingleElement4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(singleElement3(arr));
	}

	private static int singleElement3(int[] arr) {
		int n = arr.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = ans ^ arr[i];
		}
		return ans;
	}

}
