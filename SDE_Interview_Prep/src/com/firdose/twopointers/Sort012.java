
//Question : https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?utm_source=gfg

//dutch flag algo

//T.C : 0(N)
//S.C: O(1);

package com.firdose.twopointers;

public class Sort012 {

	public static void sort012(int a[], int n) {
		
		int i = 0;
		int j = 0;
		int k = a.length - 1;
		while (j <= k) {
			if (a[j] == 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			} else if (a[j] == 1) {
				j++;
			} else {
				int temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k--;
			}
		}

	}
}
