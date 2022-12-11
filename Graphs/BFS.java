package com.company.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        int n = 7;
        int m = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }

        // Adding the edges in the graph

        // First Component
        addEdge(1,2,adj);
        addEdge(2,3,adj);
        addEdge(2,7,adj);
        addEdge(3,5,adj);
        addEdge(7,5,adj);

        // Second Component
        addEdge(4,6,adj);

        // visited array
        int[] visited = new int[n+1];

        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // Driver Code
        for (int i = 1; i <= n; i++){
            if(visited[i] == 0){
                BFS_Traversal(i,adj,list,queue,visited);
            }
        }
        System.out.println(list);
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void Display(ArrayList<ArrayList<Integer>> adj){
        for (int i = 1;i < adj.size();i++){
            System.out.print("Vertex " + i);
            for (int j = 0;j < adj.get(i).size();j++){
                System.out.print(" --> ");
                System.out.print(adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    static void BFS_Traversal(int node,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list,Queue<Integer> queue,int[] visited){
        queue.offer(node);
        visited[node] = 1;
        while(!queue.isEmpty()){
            int Node = queue.poll();
            list.add(Node);
            for (int adjEle : adj.get(Node)){
                if(visited[adjEle] == 0){
                    visited[adjEle] = 1;
                    queue.offer(adjEle);
                }
            }
        }
    }
}
