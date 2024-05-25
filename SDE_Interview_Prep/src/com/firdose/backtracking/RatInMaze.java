
//GFG(medium):https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

//T.C:O(4^n*n)
//S.C:O(L*X)--->L=length of the path ans X=number of paths

package com.firdose.backtracking;

import java.util.ArrayList;

public class RatInMaze {

	public static ArrayList<String> findPath(int[][] m, int n) {
		// Your code here
		ArrayList<String> ans = new ArrayList<>();
		helper(m, n - 1, 0, 0, "", ans);
		if (ans.size() > 0) {
			return ans;
		}
		ans.add(-1 + "");
		return ans;
	}

	public static void helper(int[][] m, int n, int i, int j, String dir, ArrayList<String> ans) {
		if (i < 0 || j < 0 || i > n || j > n || m[i][j] == 0) {
			return;
		}

		if (i == n && j == n) {
			ans.add(dir);
			return;
		}

		m[i][j] = 0;
		helper(m, n, i + 1, j, dir + "D", ans);
		helper(m, n, i, j + 1, dir + "R", ans);
		helper(m, n, i, j - 1, dir + "L", ans);
		helper(m, n, i - 1, j, dir + "U", ans);
		m[i][j] = 1;
		return;
	}

}
