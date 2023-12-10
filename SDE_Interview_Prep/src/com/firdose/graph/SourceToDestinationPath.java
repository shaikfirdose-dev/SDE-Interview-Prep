

//You have been given edges of a graph and a source node(sn) and destination node(dn).
//Return true if there is a path from source node to destination node or false otherwise.


package com.firdose.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SourceToDestinationPath {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();				// no.of nodes
		int m = sc.nextInt();				// no.of edges

		List<List<Integer>> graph = new ArrayList<>();		// adjacency list  (graph construction)
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int src = sc.nextInt();				// source location
		int dst = sc.nextInt();				// destination location

		System.out.println(sourceToDestination(graph, n, src, dst));

	}

	private static boolean sourceToDestination(List<List<Integer>> graph, int n, int src, int dst) {
		Queue<Integer> queue = new LinkedList<>();
		boolean visited[] = new boolean[n];			// visited array used to update the visited nodes
		Arrays.fill(visited, false);

		queue.add(src);
		visited[src] = true;
		while (queue.size() > 0) {
			int rem = queue.remove();
			if (rem < graph.size()) {
				List<Integer> neighbours = graph.get(rem);    // taking neighbours of the node
				for (int nbr : neighbours) {
					if (visited[nbr] == false) {    // if node is not visited then only we can add the node in to the queue
						queue.add(nbr);
						visited[nbr] = true;		// then update it as visited(true)
					}
				}
			}
		}
		if (visited[dst] == true) {    // check if node reaches at destination or not 
			return true;				// if reached then return true
		}
		return false;					// return false

	}

}
