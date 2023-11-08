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
		Arrays.sort(arr);
		int count=0;
		int lessCount=0;
		if(arr[0]==0) {
			count++;
		}
		for(int i=1;i<n;i++) {
			if(arr[i]!=arr[i-1]) {
				lessCount=i;
			}
			if(arr[i]==lessCount) {
				count++;
			}
		}
		return count;
	}

}
