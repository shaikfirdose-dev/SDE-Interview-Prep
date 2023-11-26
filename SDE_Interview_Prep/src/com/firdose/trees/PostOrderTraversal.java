package com.firdose.trees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
	
	List<Integer> al = new ArrayList()<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        traversal(root);
        return al;
    }
    public void traversal(TreeNode root){
        if(root==null){
            return;
        }
        traversal(root.left);
        traversal(root.right);
        al.add(root.val);
    }

}
