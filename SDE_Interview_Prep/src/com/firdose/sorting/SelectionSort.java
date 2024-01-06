
//Question : Given N array Integers, Sort the array using Selection sort technique

package com.firdose.sorting;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		selectionSort(n, arr);
	}

	private static void selectionSort(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			int minEle = arr[i];
			int index = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < minEle) {
					minEle = arr[j];
					index = j;
				}
			}

			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;

		}
		for (int ele = 0; ele < n; ele++) {
			System.out.print(arr[ele] + " ");
		}
	}

}
