
//Leetcode : https://leetcode.com/problems/count-complete-tree-nodes/

package com.firdose.trees;

public class CountNodes {
	
	public int countNodes(TreeNode root) {

        if(root==null){
            return 0;
        }

        int leftHalf = countNodes(root.left);
        int rightHalf = countNodes(root.right);

        return leftHalf+rightHalf+1;
        
    }

}
