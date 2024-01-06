
//Question : Given two sorted arrays with N and M elements. Merge them into one sorted array and Print them.

//T.C : O(N+M)
//S.C : O(N+M)

package com.firdose.sorting;

import java.util.Scanner;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[m];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		mergeSortedArrays(n, m, a, b);
	}

	private static void mergeSortedArrays(int n, int m, int[] a, int[] b) {
		int[] c = new int[n + m];
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		while (p1 < n && p2 < m) {
			if (a[p1] < b[p2]) {
				c[p3] = a[p1];
				p3++;
				p1++;
			} else {
				c[p3] = b[p2];
				p3++;
				p2++;
			}
		}
		while (p1 < n) {
			c[p3] = a[p1];
			p3++;
			p1++;
		}
		while (p2 < m) {
			c[p3] = b[p2];
			p3++;
			p2++;
		}
		for (int ele : c) {
			System.out.print(ele + " ");
		}
	}

}
