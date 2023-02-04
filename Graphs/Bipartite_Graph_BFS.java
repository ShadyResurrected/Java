package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// For a graph to be called bipartite, all its vertices must be colored with exactly
// two colours such that no two adjacent vertices have the same colour

public class Bipartite_Graph_BFS {
    public static void main(String[] args) {
        int vertices = 8;
        int edges = 8;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visited = new int[vertices + 1];
        Arrays.fill(visited,-1);
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int flag = -1;

        for(int i = 0;i <= vertices;i++){
            adj.add(new ArrayList<>());
        }

        // Graph 1
//        addEdge(1,2,adj);
//        addEdge(2,3,adj);
//        addEdge(3,4,adj);
//        addEdge(4,5,adj);
//        addEdge(5,6,adj);
//        addEdge(6,7,adj);
//        addEdge(2,8,adj);
//        addEdge(8,5,adj);

        // Graph 2
        addEdge(0,1,adj);
        addEdge(2,3,adj);

        for (int i = 0;i <= vertices;i++){
            if(visited[i] == -1){
                if(BipartiteCheck(i,adj,queue,visited)){
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == -1) System.out.println("Not Bipartite");
        else System.out.println("Bipartite");
    }

    private static boolean BipartiteCheck(int i, ArrayList<ArrayList<Integer>> adj, Queue<Integer> queue,int[] visited) {
        queue.offer(i);
        visited[i] = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for (int node : adj.get(current)){
                if(visited[node] == -1){
                    queue.offer(node);
                    visited[node] = setColour(visited[current]);
                }
                if(visited[node] == visited[current])   return false;
            }
        }
        return true;
    }

    static int setColour(int cureNodeColor){
        if (cureNodeColor == 1){
            return 0;
        }
        return 1;
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
