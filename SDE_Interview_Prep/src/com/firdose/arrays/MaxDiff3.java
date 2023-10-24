//Question: 
//	Given n length array "arr". Find (i,j) with maximum value of arr[i] - arr[j] + j - i. 
//	You need to print max value of (arr[i] - arr[j] + j - i) possible and not the (i,j) itself.

//5
//3 9 8 4 1
//
//o/p:	11

package com.firdose.arrays;

import java.util.Scanner;

public class MaxDiff3 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        } 
        
        System.out.println(maxDiff(arr, n));
    }
	
	public static int maxDiff(int[] arr, int n) {
		int max = Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<=n-1;j++){
                int diff = (arr[i]-arr[j])+(j-i);
                if(diff>max){
                    max=diff;
                }
            }
        }
        return max;
	}

}
