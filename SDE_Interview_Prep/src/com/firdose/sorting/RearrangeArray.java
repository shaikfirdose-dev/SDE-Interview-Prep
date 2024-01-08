//
//Question : 
//	Given N elements, Rearrange the array so that
//
//	a) arr[0] should go to correct sorted position
//	b) all elements <=arr[0] should go to leftside of arr[0]
//	c) all elements >arr[0] should go to rightside of arr[0]
//			
//			T.C:O(N)
//			S.C:O(1)

package com.firdose.sorting;

import java.util.Scanner;

public class RearrangeArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		reArrange(arr);
	}

	private static void reArrange(int[] arr) {
		int p1 = 1;
		int p2 = arr.length - 1;
		while (p1 <= p2) {
			if (arr[p1] <= arr[0]) {
				p1++;
			} else if (arr[p2] > arr[0]) {
				p2--;
			} else {
				int temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
				p1++;
				p2--;
			}
		}
		int temp = arr[0];
		arr[0] = arr[p2];
		arr[p2] = temp;

		for (int ele : arr) {
			System.out.print(ele + " ");
		}
		return;
	}

}
