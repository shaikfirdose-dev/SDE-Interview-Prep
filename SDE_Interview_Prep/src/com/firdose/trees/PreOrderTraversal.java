package com.firdose.trees;

import java.util.ArrayList;
import java.util.List;

public class PreOrderTraversal {
	
	List<Integer> al = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        traversal(root);
        return al;
    }

    public void traversal(TreeNode root){
        if(root==null){
            return;
        }
        al.add(root.val);
        traversal(root.left);
        traversal(root.right);
    }

}
