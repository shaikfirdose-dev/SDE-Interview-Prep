
//Leetcode (medium): https://leetcode.com/problems/validate-binary-search-tree/

package com.firdose.trees;

public class ValidateBST {

	// public boolean isValidBST(TreeNode root) {
	// //brute force T.c: O(N) S.C:O(N)
	// ArrayList<Integer> ans = new ArrayList<>();
	// helper(root, ans);
	// for(int i=1;i<ans.size();i++){
	// if(ans.get(i-1)>=ans.get(i)){
	// return false;
	// }
	// }
	// return true;
	// }
	// public static void helper(TreeNode root, ArrayList<Integer> ans){
	// if(root==null){
	// return;
	// }

	// helper(root.left, ans);
	// ans.add(root.val);
	// helper(root.right, ans);
	// }

	// optimal t.c :O(N) S.C :O(H)
	public boolean isValidBST(TreeNode root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isBST(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		long rval = root.val;
		if (rval < min || rval > max)
			return false;

		boolean l = isBST(root.left, min, rval - 1);
		boolean r = isBST(root.right, rval + 1, max);

		if (l == false || r == false) {
			return false;
		}
		return true;
	}

}
