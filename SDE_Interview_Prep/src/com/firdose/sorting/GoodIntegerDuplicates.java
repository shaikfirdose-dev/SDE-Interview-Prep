//Given N array Integers, Calculate number of good integers. An element is said to be good integers, if {No. of element < element == element itself}
//
//Note: Array elements can be duplicate.

package com.firdose.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class GoodIntegerDuplicates {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(goodIntegers(arr, n));
	}

	private static int goodIntegers(int[] arr, int n) {
		Arrays.sort(arr);  // first sort the array so that elements should be in increasing order
		int count=0;		// this count is for counting good integers
		int lessCount=0;	// this is for storing the good integer index
		if(arr[0]==0) { 	//edge case-> if first element is zero then it should definitely good integer
			count++;
		}
		for(int i=1;i<n;i++) {
			if(arr[i]!=arr[i-1]) {   // checking current element is first occurance or not
				lessCount=i;			// if first element is first occurance then store its index
			}
			if(arr[i]==lessCount) {   // here check element and index of good integer, if both are same then count
				count++;
			}
		}
		return count;
	}

}
