//Question: You are given an array consisting of n integers where every element appears exactly twice, except for one element which appears exactly once. Duplicate Numbers are adjacent to each other.
//
//Return the single element that appears only once.
//
//Your solution must run in O(log n) time and O(1) space.
//
//input: 
//	15
//	4 4 1 1 9 9 11 11 20 7 7 3 3 5 5
//	
//output: 20


package com.firdose.binarysearch;

import java.util.Scanner;

public class SingleElement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(singleElement(arr, n));

	}
	private static int singleElement(int[] arr, int n) {
		int low =2;
		int high = n-3;
		
		if(arr[0]!=arr[1]) {
			return arr[0];
		}
		if(arr[n-1]!=arr[n-2]) {
			return arr[n-1];
		}
		while(low<=high){
			int mid = (low+high)/2;
			if(arr[mid]!=arr[mid+1] && arr[mid]!=arr[mid-1]) {
				return arr[mid];
			}
			if(arr[mid]==arr[mid-1]) {
				mid--;
			}
			if(mid%2==0) {
				low=mid+2;
			}
			else {
				high=mid-1;
			}
		}
		return -1;
	}

}
