//226 Lab 5 June 2023

//This java file contains a template for a bipartite checker.
//Your task is to complete the code, and test your solution using the testing harness in main().
import java.util.*;

import org.w3c.dom.Node;

public class BipartiteChecker {
    /**
     * Checks whether or not a graph is bipartite.
     * This function should use the fact that a graph is bipartite iff it contains no odd cycles, 
     * and that odd cycles can be detected by investigating cross edges in BFS. 
     * No other solutions will be accepted.
     * Run time requirement: O(v+e)
     * Space requirement: O(v)
     * @param graph the graph G, represented as an adjacency list
     * @return whether G is bipartite
     */
    
    
    public static boolean isBipartite(List<List<Integer>> graph) throws IllegalArgumentException {


         if (!(graph instanceof List<List<Integer>>)) {
            throw new IllegalArgumentException("Graph is not of type List<List<Integer>>");
        }

        int size = graph.size();

        if((graph.isEmpty())||(size==1)){
            return false;
        } 
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int [] depth = new int[size];
        HashMap<Integer, Integer> visited = new HashMap<>();
        int level = 0;
        int levelSize = 0;
        int count = 0;
        

        q.add(0);
        visited.put(0,1);
        depth[0] = level;

        while(!q.isEmpty()){
            if(count == levelSize){
                levelSize = q.size();
                level++;
                count = 0;
            }
            Integer i = q.remove();
            List<Integer> neighbours = graph.get(i);
            for(Integer cur : neighbours){
                if(!visited.containsKey(cur)){
                    depth[cur] = level;
                    q.add(cur);
                    visited.put(cur, 1);
                } else if(depth[cur] == depth[i]){
                        return false;
                }
            }
            count++;
         }
        return true;
        
    }

    public static void main(String[] args) {
        // Empty graph - T
        List<List<Integer>> graph = new ArrayList<>();
        
        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The empty graph is bipartite.");
            } else {
                System.out.println("The empty graph is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }
        

        // Single vertex - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList());

        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The single vertex graph is bipartite.");
            } else {
                System.out.println("The single vertex is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }
        
        
        // Line graph - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1));
        graph.add(Arrays.asList(0,2));
        graph.add(Arrays.asList(1));

        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The line graph is bipartite.");
            } else {
                System.out.println("The line graph is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }

        // Square graph - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(0, 2));
        graph.add(Arrays.asList(1, 3));
        graph.add(Arrays.asList(0, 2));

       
        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The square graph is bipartite.");
            } else {
                System.out.println("The square graph is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }

        // Connected bipartite graph - T
        graph = new ArrayList<>();
        graph.add(Arrays.asList(3, 4, 5, 6));
        graph.add(Arrays.asList(3, 4, 5, 6));
        graph.add(Arrays.asList(3, 4, 5, 6));
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 1, 2));
        graph.add(Arrays.asList(0, 1, 2));

        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The fully connected graph is bipartite.");
            } else {
                System.out.println("The fully connected graph is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }


        // Pentagon graph - F
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1,4));
        graph.add(Arrays.asList(0,2));
        graph.add(Arrays.asList(1,3));
        graph.add(Arrays.asList(2,4));
        graph.add(Arrays.asList(0,3));

        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The pentagon graph is bipartite.");
            } else {
                System.out.println("The pentagon graph is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }
        // Petersen graph - F
        graph = new ArrayList<>();
        graph.add(Arrays.asList(1, 2, 3));
        graph.add(Arrays.asList(0, 4, 5));
        graph.add(Arrays.asList(0, 4, 6));
        graph.add(Arrays.asList(0, 6, 7));
        graph.add(Arrays.asList(1, 2, 8));
        graph.add(Arrays.asList(1, 7, 8));
        graph.add(Arrays.asList(2, 3, 9));
        graph.add(Arrays.asList(3, 5, 9));
        graph.add(Arrays.asList(4, 5, 9));
        graph.add(Arrays.asList(6, 7, 8));

        try{
            boolean isBipartite = isBipartite(graph);
            if (isBipartite) {
                System.out.println("The Petersen graph is bipartite.");
            } else {
                System.out.println("The Petersen graph is not bipartite.");
            }
        } catch(IllegalArgumentException e){
            System.out.println("Graph is not of type 'Integer'");
        }

       

    }
}