
//Question : https://www.geeksforgeeks.org/problems/counting-sort/1


package com.firdose.sorting;

public class CountSort {
	public static String countSort(String str) {
		
		char[] arr = str.toCharArray();
		char maxch = 'a';
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxch) {
				maxch = arr[i];
			}
		}
		int max = maxch - 'a';
		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			int val = arr[i] - 'a';
			count[val]++;
		}

		int k = 0;
		for (int i = 0; i < count.length; i++) {
			int c = count[i];
			for (int j = 0; j < c; j++) {
				arr[k] = (char) (i + 'a');
				k++;
			}
		}
		return new String(arr);
	}

}
