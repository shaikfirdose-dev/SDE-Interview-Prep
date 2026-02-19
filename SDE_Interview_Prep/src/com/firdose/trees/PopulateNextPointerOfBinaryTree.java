
//Leetcode (medium): https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
//	T.C:O(N)
//	S.C:O(1)
		
		/*
		 * 
		 * Firstly check if root.left is null or not because we should go last before level
		 * if it is true then take variable temp and it starts from root node
		 * temp will jump each node on each level 
		 * now connect each node to the next node until temp become null
		 * first connect left null to the right node and right node to the next node left node and so on.
		 * then temp jump to the next node
		 * if temp become null then root jump to next level left node 
		 * then temp node go to the start ing of the level
		 * then connect the nodes
		 * 
		 */

package com.firdose.trees;

public class PopulateNextPointerOfBinaryTree {
	
	static class Node{
		int va;
		Node left;
		Node right;
		Node next;
	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		helper(root);
		return root;

	}

	public static void helper(Node root) {
		while (root.left != null) {
			Node temp = root;
			while (temp != null) {
				temp.left.next = temp.right;
				if (temp.next != null) {
					temp.right.next = temp.next.left;
				}
				temp = temp.next;
			}
			root = root.left;
		}
		return;
	}
}



/* Different Approach*/
import java.util.*;

/*class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode next;

  TreeNode(int x) {
    val = x;
    left = right = next = null;
  }
};*/

class Solution {

  public TreeNode connect(TreeNode root) {
    // TODO: Write your code here
    if (root == null) {
      return null;
    }

    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int n = q.size();
      TreeNode prev = null;
      for (int i = 0; i < n; i++) {
        TreeNode rem = q.remove();
        if (prev != null) {
          prev.next = rem;
        }

        prev = rem;

        if (rem.left != null) {
          q.add(rem.left);
        }
        if (rem.right != null) {
          q.add(rem.right);
        }
      }
    }
    return root;
  }
}
