package com.company.Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort_DFS {
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visited = new int[vertices];

        for (int i = 0; i <= vertices;i++){
            adj.add(new ArrayList<>());
        }

        // Topological sort is only applicable on directed acyclic graph
        addEdge(5,0,adj);
        addEdge(4,0,adj);
        addEdge(4,1,adj);
        addEdge(3,1,adj);
        addEdge(2,3,adj);
        addEdge(5,2,adj);

        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < visited.length;i++){
            if(visited[i] == 0){
                TopologySort(i,adj,visited,stack);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        System.out.println(list);
    }

    static void TopologySort(int node,ArrayList<ArrayList<Integer>> adj,int[] visited,Stack<Integer> stack){
        if(visited[node] == 0) visited[node] = 1;
        for (int adjNode : adj.get(node)){
            if(visited[adjNode] == 0){
                TopologySort(adjNode,adj,visited,stack);
            }
        }
        stack.push(node);
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
    }
}
