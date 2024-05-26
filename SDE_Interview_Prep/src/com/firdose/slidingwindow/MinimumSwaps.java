package com.firdose.slidingwindow;

import java.util.Scanner;

//Minimum swaps required to make all the elements put together which are <= B

public class MinimumSwaps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		System.out.println(minSwaps(arr, b));
	}
	
	public static int minSwaps(int[] arr, int B) {
		int k = 0;    //number of elements which are <= B
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=B) {
				k++;
			}
		}
		
		int count = 0;     // counting number of elements <= B in first window
		for(int i=0;i<k;i++) {
			if(arr[i]<=B) {
				count++;
			}
		}
		
		int reqSwaps = k-count;
		int start = 1;
		int ep = k;
		//find minimum swaps in other windows
		while(ep<arr.length) {
			if(arr[ep]<=B) {
				count++;
			}
			if(arr[start-1]<=B) {
				count--;
			}
			reqSwaps = Math.min(reqSwaps, k-count);
			start++;
			ep++;
		}
		return reqSwaps;
	}

}
