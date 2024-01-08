
//Question : Given N elements, first N-1 elements are sorted, Sort entire array and Print it. 

package com.firdose.sorting;

import java.util.Scanner;

public class InsertElement {
	
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        int[] arr = new int[n];
	        for(int i=0;i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	        insertElement(n, arr);
	    }
	    private static void insertElement(int n, int[] arr){
	        for(int j=n-2;j>=0;j--){
	            if(arr[j]>arr[j+1]){
	                int temp= arr[j];
	                arr[j] = arr[j+1];
	                arr[j+1]=temp;
	            }
	        }
	        for(int i=0;i<n;i++){
	            System.out.print(arr[i]+" ");
	        }
	        return;
	    }

}
