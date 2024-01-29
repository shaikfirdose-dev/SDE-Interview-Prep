
//Leetcode: https://leetcode.com/problems/search-a-2d-matrix/

//T.C :O(log(m*n))
//S.C: O(1)

package com.firdose.binarysearch;

public class SearchIn2D1 {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		int m = matrix[0].length;
		int low = 0;
		int high = n * m - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int ridx = mid / m;
			int cidx = mid % m;
			if (matrix[ridx][cidx] == target) {
				return true;
			} else if (matrix[ridx][cidx] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return false;

	}

}
