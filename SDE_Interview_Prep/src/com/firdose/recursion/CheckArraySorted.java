//Question: 
//	Take an input N, the size of array.
//	Take N more inputs and store that in an array.
//
//	1.It reads a number N.
//	2.Take Another N numbers as input and store them in an Array.
//
//	Write a recursive function which returns true if the array is sorted and false
//	otherwise
//
//	print returned value.
//
//
//	Example(To be used only for expected output):
//	Input:
//	4
//	2 8 6 4
//	Output:
//	false

package com.firdose.recursion;

import java.util.Scanner;

public class CheckArraySorted {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(isSorted(arr, 0, 1));
	}

	private static boolean isSorted(int[] arr, int index1, int index2) {
		if (index1 > arr.length - 2) {
			return true;
		}
		if (arr[index1] <= arr[index2]) {
			boolean temp = isSorted(arr, index1 + 1, index2 + 1);
			return temp;
		} else {
			return false;
		}
	}

}
