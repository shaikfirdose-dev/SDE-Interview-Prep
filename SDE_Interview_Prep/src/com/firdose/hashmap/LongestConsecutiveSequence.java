package com.firdose.hashmap;

import java.util.HashSet;

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {

		/*
		 * brute force T.C:O(NlogN). S.C:O(1)
		 */
//		if(nums.length==0 || nums.length==1){
		    //         return nums.length;
		    //     }
		    //     Arrays.sort(nums);
		    //    int maxLen = Integer.MIN_VALUE;
		    //    int count = 1;
		    //    for(int i=1;i<nums.length;i++){
		    //         if(nums[i]!=nums[i-1]){
		    //             if(nums[i]==nums[i-1]+1){
		    //                 count++;
		    //             }
		    //             else{
		    //                 maxLen = Math.max(maxLen, count);
		    //                 count = 1;
		    //             }
		    //         }
		    //     }
		    //     return Math.max(count, maxLen);
		    // }
		

		
		/*
		 * optimal solution
		 * 
		 * T.C:O(N)
		 * S.C:O(N)
		 */
		if (nums.length == 0) {
			return 0;
		}
		HashSet<Integer> set = new HashSet<>();
		for (int ele : nums) { // here removed duplicate numbers
			set.add(ele);
		}
		int maxLen = Integer.MIN_VALUE;
		for (int num : nums) { // iterate the array
			int nextSeq = num + 1; // taking their next sequence number
			int prevSeq = num - 1; // taking their prev sequence number
			int countSeq = 1;
			while (set.remove(nextSeq)) { // counting next consecutive numbers by removing from set
				countSeq++;
				nextSeq++;
			}
			while (set.remove(prevSeq)) {// counting previous consecutive numbers by removing from set
				prevSeq--;
				countSeq++;
			}
			maxLen = Math.max(maxLen, countSeq); // after that finding maximu length of the consecutive array
		}
		return maxLen;
	}

}
