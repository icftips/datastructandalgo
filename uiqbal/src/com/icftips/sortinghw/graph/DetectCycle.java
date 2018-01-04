
package com.icftips.sortinghw.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
* Detecting Cycle in a graph
* Given a directed graph, check whether there is a cycle in it.
* There can be multiple cycles
* We don't need to print all the cycles. Just return a boolean true/false if there is/isnot
* at least one cycle respectively
* Solution: http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
* Suggested time: 45 minutes max.
* @author Umair Iqbal
*/
public class DetectCycle {
    
    
    
    /**
     * Using DFS to find the loop
     * @param adjMap
     * @return 
     */
    public static boolean detectCycle(Map<Integer,LinkedList<Integer>> adjMap){
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, LinkedList<Integer>> entry : adjMap.entrySet()) {
            
            Integer edge= entry.getKey();
            boolean isCycle = detectCycleUtils(adjMap, visited, edge);
            if(isCycle){
                return true;
            }
            
        }
        return false;
    }
    
    public static boolean detectCycleUtils(Map<Integer,LinkedList<Integer>> adjMap, Set<Integer> visited, Integer edge){
        if(visited.contains(edge)) {
            System.out.println("Detected Cycle : "+edge + "\tvisited : "+visited);
            return true;
        }
        visited.add(edge);
//        for(Integer v: adjMap.getOrDefault(edge, new LinkedList<>())){
//            boolean isCycle =detectCycleUtils(adjMap, visited, v);
//            if(isCycle ) return true;
//        }
        
        boolean isCycle = adjMap.getOrDefault(edge, new LinkedList<>()).stream().map((t) -> {
            return detectCycleUtils(adjMap, visited, t);
        }).anyMatch((t) -> {return t==true;});
        if(isCycle ) return true;
        
        visited.remove(edge);
        
        return false;
    }
    
    public static boolean detectCycle(LinkedList<Integer>[] adjList){
        HashSet<Integer> visited = new HashSet<>();
        for(int i=0;i<adjList.length;i++){
            boolean isCycle = detectCycleUtils(adjList, visited, i);
            if(isCycle) return true;
        }
        return false;
    }
    public static boolean detectCycleUtils(LinkedList<Integer>[] adjList,HashSet<Integer> visited, Integer edge){
        if(visited.contains(edge)) {
            System.out.println("Detected Cycle : "+edge + "\tvisited : "+visited);
            return true;
        }
        visited.add(edge);
        if(adjList[edge] != null){
            for(Integer edge2: adjList[edge]){
                boolean isCycle = detectCycleUtils(adjList, visited, edge2);
                if(isCycle) return true;
            }
        }
        visited.remove(edge);
        return false;
    }

}
