
//GFG(medium): https://www.geeksforgeeks.org/problems/predecessor-and-successor/1
//	T.C:O(N)
//	S.C:O(1)

package com.firdose.trees;

public class PredecessorAndSuccessorOfBST {
	
	static class Node{
		int val;
		Node left;
		Node right;
		
		Node(int val){
			this.val = val;		}
	}
	
	
	public static void funcPreSuc(Node root, Node[] pre, Node[] suc, int key) {
		
		if(root==null) {
			return;
		}
		
		Node curr = root;
		
		Node predecessors = null;
		Node successor = null;
		
		while(curr!=null) {
			if(curr.val < key) {
				successor = curr;
				curr = curr.left;
			}
			else if(curr.val > key) {
				predecessors = curr;
				curr = curr.right;
			}
			else {
				break;
			}
		}
		
		if(curr==null) {
			pre[0] = predecessors;
			suc[0] = successor;
			
			return;
		}
		
		if(curr.left!=null) {
			Node temp1 = curr.left;
			while(temp1.right!=null) {
				temp1 = temp1.right;
			}
			
			pre[0] = temp1;
		}
		else {
			pre[0] = predecessors;
		}
		
		//successor
		
		if(curr.right!=null) {
			Node temp2 = curr.right;
			while(temp2.left!=null) {
				temp2 = temp2.left;
			}
			
			suc[0] = temp2;
		}
		else {
			suc[0] = successor;
		}
		
		return;
	}
	
	

}
