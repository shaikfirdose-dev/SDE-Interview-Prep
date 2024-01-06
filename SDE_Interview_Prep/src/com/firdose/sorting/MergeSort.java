
//Question : https://www.geeksforgeeks.org/problems/merge-sort/1?utm_source=gfg

package com.firdose.sorting;

import java.util.Scanner;

public class MergeSort {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		mergeSort(arr, 0, arr.length-1);
		for(int ele : arr) {
			System.out.print(ele+" ");
		}
	}
	
	static void merge(int arr[], int l, int m, int r) {
		int temp[] = new int[r - l + 1];
		int p1 = l;
		int p2 = m + 1;
		int p3 = 0;
		while (p1 <= m && p2 <= r) {
			if (arr[p1] < arr[p2]) {
				temp[p3] = arr[p1];
				p3++;
				p1++;
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
		while (p2 <= r) {
			temp[p3] = arr[p2];
			p3++;
			p2++;
		}

		int i = l;
		int j = 0;
		while (j < temp.length) {
			arr[i] = temp[j];
			i++;
			j++;
		}
		return;
	}

	static void mergeSort(int arr[], int l, int r) {
		if (l == r) {
			return;
		}
		int m = (l + r) / 2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);

		merge(arr, l, m, r);

	}

}
