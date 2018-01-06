
package com.icftips.graph.homework;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *   Topological Sort (alien dictionary problem)
 *   Given a sorted dictionary of an alien language, find order of characters.
 *   Example-1:
 *   Input: words[] = {"baa", "abcd", "abca", "cab", "cad"}
 *   Output: Order of characters is 'b', 'd', 'a', 'c'
 *   Note that words are sorted and in the given language. "baa" comes before "abcd", therefore 'b'
 *   is before 'a' in output.
 *   Example-2:
 *   Input: words[] = {"caa", "aaa", "aab"}
 *   Output: Order of characters is 'c', 'a', 'b'
 *   Solution:
 *   http://www.geeksforgeeks.org/topological-sorting/
 *   http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * @author Umair Iqbal
 */
public class AlienLanguage {
    
    /**
     * Assumption is all alphabets are lowercase 
     * @param words
     * @param v
     * @return Graph&lt;Character&gt;
     */
    public static void registerWords(String[] words, int v){
        Graph graph = new Graph(v);
        for(int i=0;i<graph.adjList.length;i++){
            graph.adjList[i]=new LinkedList<>();
        }
        
        for(int i = 0; i < words.length-1; i++){
            String first = words[i];
            String second = words[i+1];
            int comparsion=Math.min(first.length(), second.length());
            
            for(int index =0;index < comparsion; index++){
                if(first.charAt(index)!= second.charAt(index)){
                    Integer f=(first.charAt(index)-'a');
                    Integer s=(second.charAt(index)-'a');
                    
                    if( ! (graph.isPathBetweenEdges(f, s) || graph.isPathBetweenEdges(s, f)) ){
                        System.out.println((first.charAt(index))+" -> "+ (second.charAt(index)));
                        graph.addEdge(f, s);
                    }
                }
            }
        }
                
        topologicalSort(graph);
        
    }
    
    public static Stack<Integer> topologicalSort(Graph graph){
        Stack<Integer> ret = new Stack<>();
        boolean[] visited = new boolean[graph.v];
        for(int i=0;i<visited.length;i++){
            visited[i]=false;
        }
        
        for(int i=0;i<graph.adjList.length;i++){
            if(! visited[i] ){
                topologicalSortUtils(graph, visited, i, ret);
            }
        }
        while(!ret.isEmpty()){
                System.out.println((char)(ret.pop()+'a') );
        }
        
        return ret;
    }
    private static void topologicalSortUtils(Graph graph, boolean[] visited, Integer v, Stack stack){
        visited[v]=true;
        if(graph.adjList[v]!=null ){
            for(Integer node: graph.adjList[v]){
                if(!visited[node])
                    topologicalSortUtils(graph, visited, node, stack);
            }
            stack.push(v);
        }
        
    }

}
