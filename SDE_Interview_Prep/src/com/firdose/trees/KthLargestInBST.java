
//GFG:https://www.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
//	T.C:O(N)
//	S.C:O(H)

package com.firdose.trees;

public class KthLargestInBST {
	
	class Node
	{
	    int data;
	    Node left;
	    Node right;
	    Node(int data)
	    {
	        this.data = data;
	        left=null;
	        right=null;
	    }
	}
	
	public int kthLargest(Node root,int K)
    {
        //Your code here
        //brute force 
        //apply inorder traversal 
        // get length-K+1 th value from arryalist
        
        //optimized
        
        int[] counter = new int[]{0};
        int[] kthLarge = new int[]{Integer.MIN_VALUE};
        
        helper(root, K, counter, kthLarge);
        
        return kthLarge[0];
    }
    
    public static void helper(Node root, int k, int[] counter, int[] kthLarge){
        
        if(root==null || counter[0]>=k){
            return;
        }
        
        helper(root.right, k, counter, kthLarge);
        
        counter[0]++;
        
        if(counter[0]==k){
            kthLarge[0] = root.data;
            return;
        }
        
        helper(root.left, k, counter, kthLarge);
        
        return;
    }

}
