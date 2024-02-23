
//GFG : https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1

//T.C: O(N)
//S.C : O(N)


package com.firdose.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
	
	static class Node{
		int data;
		Node left;
		Node right;
	}
	
	static ArrayList<Integer> leftView(Node root)       //approach is level order traversal 
    {
														//print first node of each level
      ArrayList<Integer> ans = new ArrayList<>();
      Queue<Node> queue = new LinkedList<>();
      if(root==null){
          return ans;
      }
     
      queue.add(root);
      
      while(queue.size()>0){
          int n = queue.size();
          for(int i = 1;i<=n;i++){
              Node rem = queue.remove();
              if(i==1){
                  ans.add(rem.data);
              }
              if(rem.left != null){
                  queue.add(rem.left);
              }
              if(rem.right != null){
                  queue.add(rem.right);
              }
            } 
        }
        return ans;
    }

}
