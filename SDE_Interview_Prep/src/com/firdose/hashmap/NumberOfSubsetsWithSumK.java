package com.firdose.hashmap;

public class NumberOfSubsetsWithSumK {
	
	//T.C:O(2^n)
	//S.C:O(2^n)

	public static int ans;

	public static void main(String[] args) {

		int[] arr = { 6, 3, 9 };
		int k = 9;
		ans = 0;

		subsetSum(arr, 0, k, 0);
		System.out.println(ans);
	}

	public static void subsetSum(int[] arr, int i, int k, int sum) {

		if (i == arr.length) {
			if (sum == k) {
				ans++;
			}
			return;
		}

		// pick
		subsetSum(arr, i + 1, k, sum + arr[i]);
		// not pick
		subsetSum(arr, i + 1, k, sum);

		return;
	}
	
	
	//if subsets should be printing means
////public static void subsetSum(int[] arr, int i, int k, int sum, List<Integer> ans){
//        
//        if(i==arr.length){
//            if(sum==k){
//                for(int j=0;j<ans.size();j++){
//                    System.out.print(ans.get(j)+" ");
//                }
//                System.out.println();
//                
//            }
//            return;
//        }
//        
//        
//        //pick
//        ans.add(arr[i]);
//        subsetSum(arr, i+1, k, sum+arr[i], ans);
//        //not pick
//        ans.remove(ans.size()-1);
//        subsetSum(arr, i+1, k, sum,ans);
//        
//        return;
//    }

}



//optimized

class Solution {
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i], -1);
        }
        
        return helper(n-1, nums, target, dp, 0);
        
    }
    
    public int helper(int i, int[] nums, int target, int[][] dp, int currSum){
        if(i<0){
            return (target==currSum)?1:0;
        }
    
        
        if(dp[i][currSum]!=-1){
            return dp[i][currSum];
        }
        
        int pick = 0;
        if(target>=currSum+nums[i]){
            pick = helper(i-1, nums, target, dp, currSum+nums[i]);
        }
        
        int notPick = helper(i-1, nums, target, dp, currSum);
        
        dp[i][currSum] = pick+notPick;
        return pick+notPick;
    }
}
