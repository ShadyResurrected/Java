package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair{
    int node;
    int weight;

    public Pair(int node,int weight){
        this.node = node;
        this.weight = weight;
    }
}

public class Shortest_Path_DAG{
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[vertices];
        int[] distance = new int[vertices];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;

        for (int i = 0;i < vertices;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0,1,2,adj);
        addEdge(0,4,1,adj);
        addEdge(1,2,3,adj);
        addEdge(4,2,2,adj);
        addEdge(2,3,6,adj);
        addEdge(4,5,4,adj);
        addEdge(5,3,1,adj);

         for (int i = 0;i < vertices;i++){
            if(visited[i] == 0){
                TopologicalOrder(i,adj,stack,visited);
            }
        }

         while(!stack.isEmpty()){
             int Node = stack.pop();
             if(distance[Node] != Integer.MAX_VALUE){
                 ShortestPath(Node,adj,distance);
             }
         }
    }

    private static void ShortestPath(int node, ArrayList<ArrayList<Pair>> adj, int[] distance) {
        for (Pair adjNode : adj.get(node)){
            int weight = adjNode.weight;
            if(distance[node] + weight < distance[adjNode.node]){ // Relaxation of edge
                distance[adjNode.node] = distance[node] + weight;
            }
        }
    }

    private static void TopologicalOrder(int i, ArrayList<ArrayList<Pair>> adj, Stack<Integer> stack, int[] visited) {
        visited[i] = 1;
        for (Pair adjNode : adj.get(i)){
            int Node = adjNode.node;
            if(visited[Node] == 0){
                TopologicalOrder(Node,adj,stack,visited);
            }
        }
        stack.push(i);
    }

    static void addEdge(int u,int v,int weight,ArrayList<ArrayList<Pair>> adj){
        adj.get(u).add(new Pair(v,weight));
    }
}
