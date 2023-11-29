//Leetcode 102:https://leetcode.com/problems/binary-tree-level-order-traversal/

package com.firdose.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        
        List<List<Integer>> list = new ArrayList()<>();

        if(root==null){
            return list;
        }

        queue.add(root);
        while(queue.size()>0){
            int n = queue.size();
            List<Integer> al = new ArrayList<>();
            for(int i=1;i<=n;i++){
                TreeNode temp = queue.remove();
                al.add(temp.val);
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
            list.add(al);
        }
        return list;
        
    }

}
