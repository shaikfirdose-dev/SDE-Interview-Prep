package com.firdose.graph;

import java.util.ArrayList;

public class DFSNumberofProvinces {
	
	public static void DFS(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visit) {
        visit[node] = true;
        for (Integer it : graph.get(node)) {
            if (!visit[it]) {
                DFS(it, graph, visit);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // Convert matrix to adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        int provinces = 0;
        boolean[] visit = new boolean[isConnected[0].length];

        // DFS on each unvisited node
        for (int i = 0; i < isConnected[0].length; i++) {
            if (!visit[i]) {
                DFS(i, graph, visit);
                provinces++;
            }
        }

        // Return the total number of provinces
        return provinces;
    }

}
