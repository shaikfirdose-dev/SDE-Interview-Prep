//Number of provinces problem

//T.C:O(V+E)
//S.C:O(V)
package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvincesUsingDSU {
	/*
	 * This is solved by Disjoint Set Union method
	 */

	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		int[] parent = new int[n];
		int[] rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && isConnected[i][j] == 1) {
					union(i, j, parent, rank);
				}
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (i == parent[i]) {
				ans++;
			}

		}
		return ans;
	}

	public void union(int x, int y, int[] parent, int[] rank) {
		int px = find(x, parent);
		int py = find(y, parent);
		if (px == py) {
			return;
		}
		if (rank[px] > rank[py]) {
			parent[py] = px;
		} else if (rank[px] < rank[py]) {
			parent[px] = py;
		} else {
			parent[px] = py;
			rank[py]++;
		}
		return;
	}

	public int find(int x, int[] parent) {
		if (x == parent[x]) {
			return x;
		}

		int temp = find(parent[x], parent);
		parent[x] = temp;
		return temp;
	}

	/*
	 * This is solved by dfs
	 */
//	public int findCircleNum(int[][] isConnected) {
//        List<List<Integer>> graph = new ArrayList<>();
//        for(int i=0;i<isConnected.length;i++){
//            graph.add(new ArrayList<>());
//        }
//        for(int i=0;i<isConnected.length;i++){
//            for(int j=0;j<isConnected[0].length;j++){
//                if(isConnected[i][j]==1 && i!=j){
//                    graph.get(i).add(j);
//                    graph.get(j).add(i);
//                }
//            }
//        }
//
//        boolean visited[] = new boolean[isConnected[0].length];
//        Arrays.fill(visited, false);
//        int count=0;
//
//        for(int i=0;i<isConnected.length;i++){
//            if(visited[i]==false){
//                visited[i]=true;
//                dfs(i, graph, visited);
//                count++;
//            }
//        }
//        return count;
//    }
//
//    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited){
//        
//        List<Integer> neighbours = graph.get(node);
//        for(int nbr : neighbours){
//            if(visited[nbr]==false){
//                visited[nbr]=true;
//                dfs(nbr, graph, visited);
//            }
//        }
//    }

}
