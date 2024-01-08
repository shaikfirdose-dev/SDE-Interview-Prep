
//Question : https://www.geeksforgeeks.org/problems/quick-sort/1?utm_source=gfg

package com.firdose.sorting;

public class QuickSortAlgo {
	static void quickSort(int arr[], int low, int high) {

		if (low >= high) {
			return;
		}
		int p = partition(arr, low, high);
		quickSort(arr, low, p - 1);
		quickSort(arr, p + 1, high);

	}

	static int partition(int arr[], int low, int high) {

		int p1 = low + 1;
		int p2 = high;
		while (p1 <= p2) {
			if (arr[p1] <= arr[low]) {
				p1++;
			} else if (arr[p2] > arr[low]) {
				p2--;
			} else {
				int temp = arr[p1];
				arr[p1] = arr[p2];
				arr[p2] = temp;
				p1++;
				p2--;
			}
		}
		int temp = arr[low];
		arr[low] = arr[p2];
		arr[p2] = temp;
		return p2;
	}

}
