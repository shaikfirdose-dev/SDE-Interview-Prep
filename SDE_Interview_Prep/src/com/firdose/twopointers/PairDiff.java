//
//Question : https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=gfg
//	T.C:O(NLOGN)
//	S.C:O(1)

package com.firdose.twopointers;

import java.util.Arrays;

public class PairDiff {
	
	public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        //code here.
        int i=0;
        int j=1;
        while(i<size && j<size){
            int diff = Math.abs(arr[i]-arr[j]);
            if(i!=j && diff==n){
                return true;
            }
            else if(diff>n){
                i++;
            }
            else{
                j++;
            }
        }
        return false;
    }

}
