package com.firdose.twopointers;

public class MovesZeroesToEnd {
	
//	void pushZerosToEnd(int[] arr, int n) {   
//        // code here
//        int[] a = new int[n];
//        int k=0;  							// T.C : O(N) S.C:O(N)
//        for(int i=0;i<n;i++){
//            if(arr[i]!=0){
//                a[k]=arr[i];
//                k++;
//            }
//        }
//        for(int i=0;i<n;i++){
//            arr[i]=a[i];
//        }
//    }
	
	
	
	void pushZerosToEnd(int[] arr, int n) {
		int count=0;
		for(int i=0;i<n;i++) {
			if(arr[i]!=0) {
				arr[count++]=arr[i];    		//T.C:O(N) S.C:O(1)
			}
		}
		while(count<n) {
			arr[count++]=0;
		}
	}

}
