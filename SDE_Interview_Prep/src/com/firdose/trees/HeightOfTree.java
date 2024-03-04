
//GFG : https://www.geeksforgeeks.org/problems/height-of-binary-tree/1?itm_source=geeksforgeeks
//T.C: O(N)
//S.C:O(Height)

package com.firdose.trees;

public class HeightOfTree {
	
	static class Node{
		int val;
		Node left;
		Node right;
	}
	
	int height(Node node) 
    {
        if(node==null){ 
            return 0;    // it is actually -1 because if no left and right root are there means it has zero height
        }
        // code here 
        int left = height(node.left);
        int right = height(node.right);
        
        return Math.max(left, right)+1;    // here will get the height of the tree
    }

}
