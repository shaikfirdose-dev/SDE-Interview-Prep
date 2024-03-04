
//Leetcode (easy): https://leetcode.com/problems/binary-tree-inorder-traversal/

package com.firdose.trees;

import java.util.ArrayList;
import java.util.List;

public class InOrderTraversal {
		// This is using recursion normal inorder traversal ------T.C :O(N)----S.C:O(N)
//	List<Integer> al = new ArrayList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        traversal(root);
//        return al;
//    }
//
//    public void traversal(TreeNode root){
//        if(root==null){
//            return;
//        }
//
//        traversal(root.left);
//        al.add(root.val);
//        traversal(root.right);
//    }
    
    
  //morries traversal --------> T.C:O(N) and S.C :O(1)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }

        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                ans.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode currp1 = curr.left;
                while(currp1.right!=null && currp1.right!=curr){
                    currp1 = currp1.right;
                }
                if(currp1.right==null){
                    currp1.right = curr;
                    curr = curr.left;
                }
                else{
                    currp1.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return ans;
    }

}
