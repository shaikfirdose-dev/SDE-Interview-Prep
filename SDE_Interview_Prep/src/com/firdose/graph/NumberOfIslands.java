
//Leetcode(medium): https://leetcode.com/problems/number-of-islands/submissions/1301987629/
//	T.C:O(N*M)
//	S.C:O(N*M)

package com.firdose.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	public int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] visited = new int[n][m];
		int islands = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && grid[i][j] == '1') {
					islands++;
					bfs(i, j, grid, visited);
				}
			}
		}

		return islands;
	}

	public void bfs(int ro, int co, char[][] grid, int[][] visited) {
		visited[ro][co] = 1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(ro, co));

		while (!q.isEmpty()) {
			Pair rem = q.remove();
			int row = rem.row;
			int col = rem.col;

			int[] delRow = { -1, 1, 0, 0 };
			int[] delCol = { 0, 0, -1, 1 };

			for (int i = 0; i < 4; i++) {
				int nrow = row + delRow[i];
				int ncol = col + delCol[i];

				if (nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && visited[nrow][ncol] == 0
						&& grid[nrow][ncol] == '1') {
					visited[nrow][ncol] = 1;
					q.add(new Pair(nrow, ncol));
				}
			}
		}
		return;
	}

	static class Pair {
		int row;
		int col;

		Pair(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
