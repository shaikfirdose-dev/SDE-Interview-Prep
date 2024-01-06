//
//Question : Given a sorted arrays with N elements and 3 indices s, m and e such that subarray [s,m] is sorted, subarray [m+1,e] is sorted.
//			Sort the subarray [s,e].
//
//Note: s to m and then m+1 to e are continuous subarray
//
//T.C : O(N)
//S.C : O(N)

package com.firdose.sorting;

import java.util.Scanner;

public class MergeTwoSortedSubArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int s = sc.nextInt();
		int m = sc.nextInt();
		int e = sc.nextInt();
		mergeSortedSubArray(arr, s, m, e);

	}

	private static void mergeSortedSubArray(int[] arr, int s, int m, int e) {
		
		int temp[] = new int[e - s + 1]; // merged sorted subarray
		int p1 = s;
		int p2 = m + 1;
		int p3 = 0;
		while (p1 <= m && p2 <= e) {           // merging two sorted subarrays
			if (arr[p1] < arr[p2]) {
				temp[p3] = arr[p1];
				p1++;
				p3++;
			} else {
				temp[p3] = arr[p2];
				p3++;
				p2++;
			}
		}
		while (p1 <= m) {
			temp[p3] = arr[p1];
			p3++;
			p1++;
		}
		while (p2 <= e) {
			temp[p3] = arr[p2];
			p3++;
			p2++;
		}

		int index = 0;                      
		for (int i = s; i <= e; i++) {         // copying from temp array to original array
			arr[i] = temp[index];
			index++;
		}
		for (int ele : arr) {
			System.out.print(ele + " ");
		}
	}

}
