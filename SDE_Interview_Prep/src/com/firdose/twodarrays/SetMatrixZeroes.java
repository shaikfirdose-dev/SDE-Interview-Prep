
//Leetcode(medium): https://leetcode.com/problems/set-matrix-zeroes/
//	T.C:O(q*n*m)
//	S.C:O(1)

package com.firdose.twodarrays;

import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public void setZeroes(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		Queue<Pair> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					q.add(new Pair(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Pair rem = q.remove();
			makeZeros(rem.row, rem.col, matrix);
		}
		return;
	}

	private void makeZeros(int row, int col, int[][] matrix) {
		// row fixed
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[row][i] != 0) {
				matrix[row][i] = 0;
			}
		}

		// col fixed
		for (int j = 0; j < matrix.length; j++) {
			if (matrix[j][col] != 0) {
				matrix[j][col] = 0;
			}
		}
		return;
	}
}
