//Question:
//	Take an input N, the size of array.
//	Take N more inputs and store that in an array.
//
//	1.It reads a number N.
//	2.Take Another N numbers as input and store them in an Array.
//	3.It reads a Number M.
//
//	Write a recursive function which returns the first index at which M is found in
//	the array and -1 if M is not found anywhere.
//
//	print returned value.
//
//
//	Example(To be used only for expected output):
//	Input:
//	4
//	2 8 6 4 
//	5
//	Output:
//	-1

package com.firdose.recursion;

import java.util.Scanner;

public class FirstIndex {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(isFound(arr, m, 0));
	}

	private static int isFound(int[] arr, int m, int index) {
		if (arr[index] == m) {
			return index;
		}
		if (index < arr.length - 1) {
			int temp = isFound(arr, m, index + 1);
			return temp;
		} else {
			return -1;
		}
	}

}
