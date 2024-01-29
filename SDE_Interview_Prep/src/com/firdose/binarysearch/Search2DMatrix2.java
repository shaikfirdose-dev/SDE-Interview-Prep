

//Leetcode :https://leetcode.com/problems/search-a-2d-matrix-ii/
//	T.C:O(log(m*n))
//	S.C:O(1)



package com.firdose.binarysearch;

public class Search2DMatrix2 {

	public boolean searchMatrix(int[][] matrix, int target) {
		int low = 0;
		int high = matrix[0].length - 1;
		while (low < matrix.length && high >= 0) {
			if (matrix[low][high] == target) {
				return true;
			} else if (matrix[low][high] > target) {
				high--;
			} else {
				low++;
			}
		}
		return false;
	}

}
