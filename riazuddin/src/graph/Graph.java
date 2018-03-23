package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
/*
 * https://www.geeksforgeeks.org/topological-sorting/
 * 
 */
public class Graph {
	
	private Map<Integer, LinkedList<Integer>> adj;
	
	Graph(){
		this.adj = new HashMap<>();
	}
	
	void addEdge(int v, int w) {
		this.adj.computeIfAbsent(v, k -> (new LinkedList<>())).add(w);
	}
	
	void topologicalSort() {
		Set<Integer> visited = new HashSet<>();
		Stack<Integer> s = new Stack<>();
		this.adj.keySet().forEach((k) -> {
			if(!visited.contains(k))
				tsUtil(k, visited, s);
		});
		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
	}
	
	void tsUtil(int k, Set<Integer> visited, Stack<Integer> s) {
		visited.add(k);
//		System.out.println(k+" : "+visited);
		if(this.adj.get(k) != null) {
			this.adj.get(k).forEach(e -> {
				if(!visited.contains(e))
					tsUtil(e, visited, s);
			});
		}
//		System.out.println("Pushing: "+k);
		s.push(k);
	}

	public static void main(String[] args) {
        // Create a graph given in the above diagram
		Graph g = new Graph();
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        g.topologicalSort();
    }
}
