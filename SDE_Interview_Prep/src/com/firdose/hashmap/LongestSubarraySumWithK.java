package com.firdose.hashmap;

import java.util.HashMap;

public class LongestSubarraySumWithK {
	
	
	 public static int lenOfLongSubarr (int A[], int N, int K) {
	        //Complete the function
	        HashMap<Integer,Integer> hm = new HashMap<>();
	     
	        int maxLen = 0;
	        int pSum=0;
	        for(int i=0;i<N;i++){
	            pSum+=A[i];
	            
	            if(pSum==K){
	                maxLen = Math.max(maxLen, i+1);
	            }
	            
	            if(hm.containsKey(pSum-K)==true){
	                maxLen = Math.max(maxLen, (i-hm.get(pSum-K)));
	            }
	            if(!hm.containsKey(pSum)){
	                hm.put(pSum,i);
	            }
	        }
	        return maxLen;
	        
	    }

}
