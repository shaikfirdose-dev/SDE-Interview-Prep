package com.firdose.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
	
	List<Integer> al = new ArrayList()<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return al;
    }

    public void traversal(TreeNode root){
        if(root==null){
            return;
        }

        traversal(root.left);
        al.add(root.val);
        traversal(root.right);
    }

}
