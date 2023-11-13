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
		for(int i=0;i<n;i++) {   // taking input array
			arr[i]=sc.nextInt();
		}
		System.out.println(goodInteger(arr, n));
	}

	private static int goodInteger(int[] arr, int n) {
		Arrays.sort(arr); // sort the array 
		int count=0;      // counting no.of good integer
		for(int i=0;i<n;i++) {
			if(arr[i]==i) {   // checking if current integer is equal to their index or not because
				count++;		// after sorting the array all the elements should be in increasing order so that we can easily 
			}					// get the good integer by checking its index
		}
		return count;
	}

}
