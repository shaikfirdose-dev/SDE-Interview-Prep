
//Leetcode (medium ): https://leetcode.com/problems/find-bottom-left-tree-value/?envType=daily-question&envId=2024-02-28

package com.firdose.leetcode.daily.problems;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftNodeValue {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
	}
	public int findBottomLeftValue(TreeNode root) {
		
		//brute force--------------T.C: O(N)------S.C :O(N)
		
		// List<List<Integer>> allNodeValues = new ArrayList<>();
		// if(root==null){
		// return -1;
		// }
		// Queue<TreeNode> q = new LinkedList<>();
		// q.add(root);
		// while(q.size()>0){
		// int n = q.size();
		// List<Integer> level = new ArrayList<>();
		// for(int i=1;i<=n;i++){
		// TreeNode rem = q.remove();
		// level.add(rem.val);
		// if(rem.left!=null){
		// q.add(rem.left);
		// }
		// if(rem.right!=null){
		// q.add(rem.right);
		// }
		// }
		// allNodeValues.add(level);
		// }
		// List<Integer> lastLevel = allNodeValues.get(allNodeValues.size()-1);
		// return lastLevel.get(0);

		
		//optimal T.C : O(N) and S.C : O(W)->width of the tree
		if (root == null) {
			return -1;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int lastNode = Integer.MIN_VALUE;
		while (q.size() > 0) {
			int n = q.size();
			for (int i = 1; i <= n; i++) {
				TreeNode rem = q.remove();
				if (i == 1) {
					lastNode = rem.val;
				}
				if (rem.left != null) {
					q.add(rem.left);
				}
				if (rem.right != null) {
					q.add(rem.right);
				}
			}
		}
		return lastNode;
	}

}
