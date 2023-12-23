//You are given an array of size 'n' and n elements of the same array. 
//You are required to find and print all the subarrays of the given array. 
//Each subarray should be space seperated and on a seperate lines. Refer to sample input and output.


//T.C : O(N^3)
//S.C : O(1)

package com.firdose.arrays;

import java.util.Scanner;

public class PrintAllSubArrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int st = 0; st < n; st++) {    // starting point should start from index 0
			for (int en = st; en < n; en++) {	// ending point starts from start index
				for (int i = st; i <= en; i++) {	// printing subarray from start to end point
					System.out.print(arr[i] + " ");
				}
				System.out.println();			// going to next line for next operation
			}
		}
	}

}
