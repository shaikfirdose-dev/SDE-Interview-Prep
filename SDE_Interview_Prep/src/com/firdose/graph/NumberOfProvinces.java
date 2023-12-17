//Number of provinces problem


package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfProvinces {
	
	public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<isConnected.length;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean visited[] = new boolean[isConnected[0].length];
        Arrays.fill(visited, false);
        int count=0;

        for(int i=0;i<isConnected.length;i++){
            if(visited[i]==false){
                visited[i]=true;
                dfs(i, graph, visited);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited){
        
        List<Integer> neighbours = graph.get(node);
        for(int nbr : neighbours){
            if(visited[nbr]==false){
                visited[nbr]=true;
                dfs(nbr, graph, visited);
            }
        }
    }

}
