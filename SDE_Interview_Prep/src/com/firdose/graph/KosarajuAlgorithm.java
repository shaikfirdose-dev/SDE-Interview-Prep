
//GFG(medium): https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1?utm_source=geeksforgeeks
//	T.C:O(V+E)
//	S.C:O(V+E)

package com.firdose.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgorithm {
	private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> st) {
		visited[node] = 1;
		List<Integer> nbrs = adj.get(node);
		for (int nbr : nbrs) {
			if (visited[nbr] == 0) {
				dfs(nbr, adj, visited, st);
			}
		}
		st.push(node);
	}

	public void dfs2(int node, ArrayList<ArrayList<Integer>> graph, int[] visited) {
		visited[node] = 1;
		for (int nbr : graph.get(node)) {
			if (visited[nbr] == 0) {
				dfs2(nbr, graph, visited);
			}
		}
	}

	// Function to find number of strongly connected components in the graph.
	public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
		// code here
		// sort the all the edges by finishing time
		int[] visited = new int[V];
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (visited[i] == 0) {
				dfs(i, adj, visited, st);
			}
		}

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}

		// reversed the graph
		for (int i = 0; i < V; i++) {
			visited[i] = 0;
			for (int it : adj.get(i)) {
				graph.get(it).add(i);
			}
		}

		// apply dfs by stack (finishing time)
		int ans = 0;
		while (!st.isEmpty()) {
			int node = st.pop();
			if (visited[node] == 0) {
				ans++;
				dfs2(node, graph, visited);
			}
		}
		return ans;

	}

}
