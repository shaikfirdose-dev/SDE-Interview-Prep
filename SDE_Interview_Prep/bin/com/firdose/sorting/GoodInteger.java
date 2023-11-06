//Question: 
//	Given N array Integers, Calculate number of good integers. An element is said to be good integers, if {No. of element < element == element itself}
//
//	Note: Array elements are distinct.

package com.firdose.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class GoodInteger {
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=sc.nextInt();
		}
		System.out.println(goodInteger(arr, n));
	}

	private static int goodInteger(int[] arr, int n) {
		Arrays.sort(arr);
		int count=0;
		for(int i=0;i<n;i++) {
			if(arr[i]==i) {
				count++;
			}
		}
		return count;
	}

}
