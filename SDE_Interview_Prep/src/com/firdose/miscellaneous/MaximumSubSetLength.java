
//Leetcode : https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset/description/
//T.C:O(nlogN)
//S.C:O(N)

package com.firdose.miscellaneous;

import java.util.HashMap;

public class MaximumSubSetLength {
	
	public int maximumLength(int[] arr) {
        int ans = 0;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int e : arr){
            
            if(hm.containsKey(e)){
                hm.put(e, hm.get(e)+1);
            }
            else{
                hm.put(e,1);
            }
        }
        
        if(hm.containsKey(1)){
            int f = hm.get(1);
            if(f%2==0){
                f--;
            }
            ans =f;
        }
        for(int ele : arr){
            int cans=0;
            while(ele!=1 && hm.containsKey(ele) && hm.get(ele)>=2){
                cans = cans+2;
                
                ele = ele*ele;
            }
            if(hm.containsKey(ele)){
                cans++;
            }
            else{
                cans--;
            }
            ans = Math.max(ans, cans);
        }
        // System.out.println(ans);
        return ans;
        
    }
	
	

}
