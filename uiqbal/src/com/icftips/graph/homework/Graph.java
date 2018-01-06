
package com.icftips.graph.homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * This graph class maintain both Adjacency Matrix and Adjacency List 
 * @author Umair Iqbal
 */
public class Graph {
    
    LinkedList<Integer>[] adjList ;
    int v;
    
    Map<Integer, LinkedList<Integer>> adjMap;
    
    Graph(int v){
        this.v=v;
        adjList =  new LinkedList[v];
        adjMap = new HashMap<>();
    }
    
    
    public void addEdge(Integer start, Integer end){
        addAdjMap(start, end);
        addAdjList(start,end);
    }
    private void addAdjList(Integer start, Integer end){
        if(adjList[start] == null){
            adjList[start]=new LinkedList<>();
        }
        adjList[start].addLast(end);
    }
    private void addAdjMap(Integer start, Integer end){
        LinkedList<Integer> list = adjMap.getOrDefault(start, new LinkedList<>());
        list.addLast(end);
        adjMap.put(start, list);
    }
    
    public boolean isPathBetweenEdges(Integer start,Integer end){
        boolean [] visited=new boolean[v];
        
        return isPathBetweenEdgesUtils(start, end, visited);
        
    }
    
    private boolean isPathBetweenEdgesUtils(Integer start,Integer end, boolean [] visited){
        if(visited[start])return false;
        visited[start]=true;
        if(adjList[start]!=null){
        for(Integer v:adjList[start]){
                if(v.compareTo(end) ==0) return true;
                boolean detected =isPathBetweenEdgesUtils(v, end, visited);
                if(detected) return true;
            }
        }
        
        return false;
    }

    @Override
    public String toString() {
        return "Map: "+adjMap.toString()+"\nList: "+Arrays.asList(adjList).toString(); 
    }
    
    
    
    
    

}
