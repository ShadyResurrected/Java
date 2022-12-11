package com.company.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFS {
    public static void main(String[] args) {
        int n = 7;
        int m = 6;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        // Adding edges in the graph

        // First Component
        AddEdge(1,2,adj);
        AddEdge(2,7,adj);
        AddEdge(7,5,adj);
        AddEdge(3,5,adj);
        AddEdge(2,3,adj);

        // Second Component
        AddEdge(4,6,adj);

        // visited array
        int[] visited = new int[n+1];

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Driver Code
        for (int i = 1; i <= n; i++){
            if(visited[i] == 0){
                DFS_Traversal(i,adj,list,visited);
            }
        }
        System.out.println(list);
    }

    private static void DFS_Traversal(int node, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> list, int[] visited) {
        list.add(node);
        visited[node] = 1;
        for (int i : adj.get(node)){
            if(visited[i] == 0){
                DFS_Traversal(i,adj,list,visited);
            }
        }
    }

    static void AddEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
