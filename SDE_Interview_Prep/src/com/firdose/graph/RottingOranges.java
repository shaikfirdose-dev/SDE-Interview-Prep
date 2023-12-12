
//Leetcode 994(Medium): https://leetcode.com/problems/rotting-oranges/

package com.firdose.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	static class Pair {
		int row;
		int col;
		int time;

		Pair(int row, int col, int time) {
			this.row = row;
			this.col = col;
			this.time = time;
		}
	}

	public int orangesRotting(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		if ((n == 1 && m == 1) && (grid[0][0] == 0 || grid[0][0] == 2)) {
			return 0;
		}
		if ((n == 1 && m == 1) && grid[0][0] == 1) {
			return -1;
		}
		int count1 = 0;
		int count2 = 0;
		Queue<Pair> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 2) {
					Pair p = new Pair(i, j, 0);
					queue.add(p);
					count2++;
				} else if (grid[i][j] == 1) {
					count1++;
				}
			}
		}

		if (count1 == 0) {
			return 0;
		} else if (count2 == 0) {
			return -1;
		}

		int ans = -1;
		while (queue.size() > 0) {
			Pair rem = queue.remove();
			int cRow = rem.row;
			int cCol = rem.col;
			int cTime = rem.time;

			ans = cTime;

			// top orange cRow-1, cCol
			if (cRow - 1 >= 0 && grid[cRow - 1][cCol] == 1) {
				Pair p = new Pair(cRow - 1, cCol, cTime + 1);
				queue.add(p);
				grid[cRow - 1][cCol] = 2;
			}

			// down orange cRow+1, cCol
			if (cRow + 1 < n && grid[cRow + 1][cCol] == 1) {
				Pair p = new Pair(cRow + 1, cCol, cTime + 1);
				queue.add(p);
				grid[cRow + 1][cCol] = 2;
			}

			// left orange cRow, cCol-1
			if (cCol - 1 >= 0 && grid[cRow][cCol - 1] == 1) {
				Pair p = new Pair(cRow, cCol - 1, cTime + 1);
				queue.add(p);
				grid[cRow][cCol - 1] = 2;
			}

			// right orange cRow, cCol+1
			if (cCol + 1 < m && grid[cRow][cCol + 1] == 1) {
				Pair p = new Pair(cRow, cCol + 1, cTime + 1);
				queue.add(p);
				grid[cRow][cCol + 1] = 2;
			}

		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}
		return ans;

	}

}
