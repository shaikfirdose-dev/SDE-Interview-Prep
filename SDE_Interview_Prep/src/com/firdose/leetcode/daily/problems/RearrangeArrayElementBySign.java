
//Leetcode (medium): https://leetcode.com/problems/rearrange-array-elements-by-sign/?envType=daily-question&envId=2024-02-14


package com.firdose.leetcode.daily.problems;

public class RearrangeArrayElementBySign {
	
	//brute force 		dive the array and merge									T.C:O(N)   S.C:O(N) 
//	public int[] rearrangeArray(int[] nums) {
//        int n = nums.length;
//        int[] pos = new int[n/2+1];
//        int[] neg = new int[n/2+1];
//        int i=0;
//        int j = 0;
//        for(int e : nums){
//            if(e>0){
//                pos[i]=e;
//                i++;
//            }
//            else{
//                neg[j]=e;
//                j++;
//            }
//        }
//
//        int k=0;
//        i=0;
//        j=0;
//        while(k<n){
//            nums[k++]=pos[i];
//            nums[k++]=neg[j];
//            i++;
//            j++;
//        }
//        return nums;
//    }
	
	
	//optimal two-pointer approach           T.C:O(N)  S.C:O(N)
	public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pos = 0;
        int neg = 1;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[pos]=nums[i];
                pos+=2;
            }
            else{
                ans[neg] = nums[i];
                neg+=2;
            }
        }
        return ans;
    }
	
	
	
	

}
