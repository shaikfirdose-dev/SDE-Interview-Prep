


//Leetcode(hard): https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
//	T.C:O(N)
//	S.C:O(H)

//serialization : it is process of converting data structures into linear form
//deserialization : it is a process of converting linear form to the non-linear form

package com.firdose.trees;

public class SerializeAndDeserializeBinaryTree {
	
	static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		TreeNode(int val){
			this.val = val;
		}
	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		serializeHelper(root, sb);
		return sb.toString();

	}

	public void serializeHelper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append("# ");
			return;
		}
		sb.append(root.val + " ");
		serializeHelper(root.left, sb);
		serializeHelper(root.right, sb);

		return;
	}

	// Decodes your encoded data to tree.
	int i;

	public TreeNode deserialize(String data) {
		String[] ch = data.split(" ");
		i = 0;
		TreeNode root = deserializeHelper(ch);
		return root;
	}

	public TreeNode deserializeHelper(String[] ch) {
		if (ch[i].equals("#")) {
			i++;
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(ch[i]));
		i++;
		root.left = deserializeHelper(ch);
		root.right = deserializeHelper(ch);

		return root;
	}

}
