//
//Question : 
//	Given N elements and [s,e], Rearrange the SubArray so that
//
//	a) arr[s] should go to correct sorted position in [s,e]
//	b) all elements <=arr[s] should go to leftside of arr[s]
//	c) all elements > arr[s] should go to rightside of arr[s]
//			
//			T.C:O(N)
//			S.C:O(1)

package com.firdose.sorting;

import java.util.Scanner;

public class ReArrangeSubArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int e = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		reArrange(arr, s, e);
	}

	private static void reArrange(int[] arr, int s, int e) {
		int p1 = s + 1;
		int p2 = e;
		while (p1 <= p2) {
			if (arr[p1] <= arr[s]) {
				p1++;
			} else if (arr[p2] > arr[s]) {
				p2--;
			} else {
				int temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
				p1++;
				p2--;
			}
		}
		int temp = arr[s];
		arr[s] = arr[p2];
		arr[p2] = temp;
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		return;
	}

}
