
//Question : https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1?utm_source=gfg

//dutch flag algo

//T.C : 0(N)
//S.C: O(1);

package com.firdose.twopointers;

public class Sort012 {

	public static void sort012(int a[], int n) {
		
		int i = 0;
		int j = 0;
		int k = a.length - 1;
		while (j <= k) {
			if (a[j] == 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			} else if (a[j] == 1) {
				j++;
			} else {
				int temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k--;
			}
		}

	}
	
	//using count sort
//	public static void sort012(int a[], int n)
//    {
//        // code here 
//        int max = Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            if(a[i]>max){
//                max = a[i];
//            }
//        }
//        int []count = new int[max+1];
//        for(int i=0;i<n;i++){
//            int val = a[i];
//            count[val]++;
//        }
//        int[] sort = new int[n];
//        int k=0;
//        for(int i=0;i<count.length;i++){
//            int c = count[i];
//            for(int j=0;j<c;j++){
//                sort[k]=i;
//                k++;
//            }
//        }
//        for(int i=0;i<n;i++){
//            a[i]=sort[i];
//        }
//        
//    }
}
