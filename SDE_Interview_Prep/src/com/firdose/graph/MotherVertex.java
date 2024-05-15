
//GfG:https://www.geeksforgeeks.org/problems/mother-vertex/1
//	T.C:O(V+E)
//	S.C:O(V)
package com.firdose.graph;

import java.util.ArrayList;
import java.util.Stack;

public class MotherVertex {

	static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> st) {
		visited[node] = 1;
		for (int u : adj.get(node)) {
			if (visited[u] == 0) {
				dfs(u, adj, visited, st);
			}
		}
		st.push(node);
	}

	static void dfs1(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
		visited[node] = 1;
		for (int u : adj.get(node)) {
			if (visited[u] == 0) {
				dfs1(u, adj, visited);
			}
		}
	}

	// Function to find a Mother Vertex in the Graph.
	public int findMotherVertex(int V, ArrayList<ArrayList<Integer>> adj) {
		// Code here
		int[] visited = new int[V];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < adj.size(); i++) {
			if (visited[i] == 0) {
				dfs(i, adj, visited, st);
			}
		}
		for (int i = 0; i < V; i++) {
			visited[i] = 0;
		}
		int ans = st.pop();
		dfs1(ans, adj, visited);
		for (int e : visited) {
			if (e == 0) {
				return -1;
			}
		}
		return ans;
	}

}
