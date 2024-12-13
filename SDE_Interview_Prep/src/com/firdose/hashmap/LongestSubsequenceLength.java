package com.firdose.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestSubsequenceLength {
//		public static void main(String[] args) {
//			int[] arr = {-50, 1, -5, 4, 7, -7, 3,-1};
//			List<List<Integer>> subq = new ArrayList<>();
//			List<Integer> sub = new ArrayList<>();
//			
//			helper(arr, 0, sub, subq);
//			
//			int maxLen = Integer.MIN_VALUE;
//			for(int i=0;i<subq.size();i++) {
//				int x = subq.get(i).stream()
//                        .reduce(0, Integer::sum);
//				
//				if(x==0) {6
//					maxLen = Math.max(maxLen, subq.get(i).size());
//				}
//			}
//			
//			System.out.println(maxLen);
//		}
		
		
//		public static void helper(int[] arr, int i, List<Integer> sub, List<List<Integer>> subq) {
//			if(i==arr.length) {
//				subq.add(new ArrayList<>(sub));
//				return;
//			}
//			
//			sub.add(arr[i]);
//			helper(arr, i+1, sub, subq);
//			sub.remove(sub.size()-1);
//			helper(arr, i+1, sub, subq);
//			
//			return;
//		}
	
	public static void main(String[] args) {
		int[] arr = {-7, 1, -5, 4, 7, -50, 3,-1};
		int n = arr.length;
		HashMap<Integer, Integer> hm = new HashMap<>();
		int cummulativeSum = 0;
		int maxLen = Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			cummulativeSum += arr[i];
			
			if(hm.containsKey(cummulativeSum)==true) {
				maxLen = Math.max(maxLen, i-hm.get(cummulativeSum));
			}
			
			if(!hm.containsKey(cummulativeSum)) {
				hm.put(cummulativeSum, i);
			}
		}
		System.out.println(maxLen);
	}
}
