
//GFG(easy):https://www.geeksforgeeks.org/problems/mirror-tree/1
//	T.C:O(N)
//	S.C:O(H)

package com.firdose.trees;

public class MirrorTree {
	static class Node{
		int val;
		Node left;
		Node right;
	}

	void mirror(Node node) {
		if (node == null) {
			return;
		}

		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		mirror(node.left);
		mirror(node.right);
		return;
	}

}
