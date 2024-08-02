package com.firdose.arrays;

public class ProductOfArrayExceptItself {
	//brute force
	//T.C:O(N*2)
//	S.C:O(1)
//	public int[] productExceptSelf(int[] nums) {
//		int n = nums.length;
//		int[] ans = new int[n];
//		for (int i = 0; i < n; i++) {
//			int prod = 1;
//			for(int j=0;j<n;j++) {
//				if(i!=j) {
//					prod = prod*nums[j];
//				}
//			}
//		}
//		return ans;
//	}
	
	

	//better approach
//	T.C;O(n)
//	S.C:O(2N)
//	public int[] productExceptSelf(int[] nums) {
//		int n = nums.length;
//		int[] ans = new int[n];
//		int[] pre = func1(nums);
//		int[] suff = func2(nums);
//		for (int i = 0; i < n; i++) {
//			if (i == 0) {
//				ans[i] = suff[i + 1];
//			} else if (i == n - 1) {
//				ans[i] = pre[i - 1];
//			} else {
//				ans[i] = pre[i - 1] * suff[i + 1];
//			}
//		}
//		return ans;
//	}
//
//	private int[] func1(int[] nums) {
//		int[] pref = new int[nums.length];
//		pref[0] = nums[0];
//		for (int i = 1; i < nums.length; i++) {
//			pref[i] = pref[i - 1] * nums[i];
//		}
//		return pref;
//	}
//
//	private int[] func2(int[] nums) {
//		int[] suff = new int[nums.length];
//		suff[nums.length - 1] = nums[nums.length - 1];
//		for (int i = nums.length - 2; i >= 0; i--) {
//			suff[i] = suff[i + 1] * nums[i];
//		}
//		return suff;
//	}

	
	
	// optimal solution
	// T.C:O(N)
	// S.C:O(N)
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int[] pre = func1(nums);
		int suff = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (i == 0) {
				ans[i] = suff;
			} else {
				ans[i] = pre[i - 1] * suff;
				suff = suff * nums[i];
			}
		}
		return ans;
	}

	private int[] func1(int[] nums) {
		int[] pref = new int[nums.length];
		pref[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			pref[i] = pref[i - 1] * nums[i];
		}
		return pref;
	}

}
