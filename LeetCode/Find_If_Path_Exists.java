package com.company.LeetCode;

import java.util.ArrayList;

public class Find_If_Path_Exists {
    public static void main(String[] args) {
        int n = 10;
        int source = 5;
        int destination = 9;
        int[][] edges = {{4,3},{1,4},{4,8},{1,7},{6,4},{4,2},{7,4},{4,0},{0,9},{5,4}};

        // Edge Case
        // if(source == destination) System.out.println(true);
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            addEdge(edge[0], edge[1], adj);
        }
        int[] visited = new int[n];
        if(!PathExists(source,destination,visited,adj)){
            System.out.println(false);
        }
        // System.out.println(true);
    }

    static boolean PathExists(int source,int destination,int[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[source] = 1;
        for(int adjEle : adj.get(source)){
            if(visited[adjEle] == 0){
                if(PathExists(adjEle,destination,visited,adj)) return true;
            }
            if(adjEle == destination) return true;
        }
        return false;
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
