package com.company.Graphs;

import java.util.ArrayList;

public class Cycle_Detection_Using_DFS {
    public static void main(String[] args) {
        int vertices = 8;
        // Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i <= vertices;i++){
            adj.add(new ArrayList<>());
        }

        // First Component
        addEdge(1,3,adj);
        addEdge(3,4,adj);

        // Second Component
        addEdge(2,5,adj);
        addEdge(5,6,adj);
        addEdge(6,7,adj);
        addEdge(7,8,adj);
        addEdge(8,5,adj);

        // Driver Code
        int flag = -1;
        int[] visited = new int[vertices + 1];
        for (int i = 1;i <= vertices;i++){
            if(visited[i] == 0){
                if(CheckCycleDFS(adj,visited,new Node(i,-1))){
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 1){
            System.out.println(true);
        }else
            System.out.println(false);
    }

    private static boolean CheckCycleDFS(ArrayList<ArrayList<Integer>> adj, int[] visited,Node node) {
        boolean res = false;
        int cur = node.currentNode;
        visited[cur] = 1;
        for (int j : adj.get(cur)){
            if(visited[j] != 0 && node.previousNode != j) return true;
            if(visited[j] == 0){
                res = CheckCycleDFS(adj,visited,new Node(j,cur));
            }
        }
        return res;
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
