package com.firdose.backtracking;

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
