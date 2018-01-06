
package com.icftips.graph.homework;

import java.util.LinkedList;


/**
 *
 * @author Umair Iqbal
 */
public class GraphTest {
    
    public static void main(String args[]){
        System.out.println("############################");
        System.out.println("Alien Language");
        System.out.println("############################");
        alienLanguageTest();
        System.out.println("############################");
        System.out.println("Detect Cycle");
        System.out.println("############################");
        detectCycleTest();
    }
    
    public static void alienLanguageTest(){
        String arr[]=new String[]{"baa", "abcd", "abca", "cab", "cad"};int v=4;
//        String arr[]=new String[]{"caa", "aaa", "aab"};int v=3;
        AlienLanguage.registerWords(arr,v);

    }
    
    public static void detectPath(){
        Graph graph = new Graph(5);// consider 0 as first element
        graph.addEdge(0, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        
        System.out.println( "--> "+graph.isPathBetweenEdges(0, 1));
    }
    
    public static void detectCycleTest(){
        Graph graph = new Graph(9);// consider 0 as first element
        graph.addEdge(1, 8);
        graph.addEdge(2, 8);
        graph.addEdge(1, 2);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 1);
        
        System.out.println("Graph doesn't have cycle ");
        System.out.println("Cycle Detected in adjMap: "+DetectCycle.detectCycle(graph.adjMap));
        
        System.out.println("Cycle Detected in adjList: "+DetectCycle.detectCycle(graph.adjList));
        
        System.out.println("\nGraph does have cycle ");
        System.out.println("\t Cycle Detected in adjMap: "+DetectCycle.detectCycle(graph.adjMap));
        
        System.out.println("\t Cycle Detected in adjList: "+DetectCycle.detectCycle(graph.adjList));
        graph.addEdge(5, 3);

        
    }

}
