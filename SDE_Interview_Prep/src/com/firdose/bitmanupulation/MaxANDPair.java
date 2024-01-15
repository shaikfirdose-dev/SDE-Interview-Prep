

//Question : Given an array arr[] of N positive elements. 
//The task is to find the Maximum AND Value generated by any pair(arri, arrj) from the array such that i != j.
//
//	T.C:O(32*N)=O(N)
//	S.C:O(1)

package com.firdose.bitmanupulation;

import java.util.Scanner;

public class MaxANDPair {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {   //input array
			arr[i] = sc.nextInt();
		}
		System.out.println(maxAndPair(arr));
	}

	private static int maxAndPair(int[] arr) {
		int n = arr.length;
		for (int i = 31; i >= 0; i--) {                       //counting each ith set bit of each element in an arraya
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (checkBit(arr[j], i) == true) {           // this will tell whether bit is set or not
					count++;
				}
			}
			if (count >= 2) {                               // after counting update the value which is unset bit element 
				for (int j = 0; j < n; j++) {
					if (checkBit(arr[j], i) == false) {
						arr[j] = 0;
					}
				}
			}
		}
		int idx1 = -1;													
		int idx2 = -1;
		for (int k = 0; k < n; k++) {						// getting two max element indexes
			if (arr[k] > 0 && idx1 == -1) {
				idx1 = k;
			} else if (arr[k] > 0 && idx1 != -1) {
				idx2 = k;
			}
		}
		return arr[idx1] & arr[idx2];                     // returning and of two max pair of element
	}

	private static boolean checkBit(int n, int k) {      //check bit function implementation
		if ((n & (1 << k)) != 0) {
			return true;
		} else {
			return false;
		}
	}

}
