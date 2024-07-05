
//Leetcode(medium): https://leetcode.com/problems/clone-graph/submissions/1303220299/
//	T.C:O(V+E)
//	S.C:O(V)

package com.firdose.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	private Node cloneUtil(Node node, HashMap<Node, Node> map) {
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		for (Node neighbor : node.neighbors) {
			if (!map.containsKey(neighbor)) {
				newNode.neighbors.add(cloneUtil(neighbor, map));
			} else {
				newNode.neighbors.add(map.get(neighbor));
			}
		}

		return newNode;
	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return null; 
		HashMap<Node, Node> map = new HashMap<>();
		return cloneUtil(node, map);
	}

}
