package com.company.Graphs;

import java.util.ArrayList;
import java.util.List;

public class Eventual_Safe_States {
    public static void main(String[] args) {
        int edges = 10;
        int vertices = 9;
        int[] visited = new int[vertices+1];
        int[] DFS_visited = new int[vertices+1]; // keeps track of the vertices visited during the current traversal
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int flag = 1;

        for (int i = 0; i <= vertices; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(1,2,adj);
        addEdge(2,3,adj);
        addEdge(3,4,adj);
        addEdge(4,5,adj);
        addEdge(3,6,adj);
        addEdge(6,5,adj);
        addEdge(7,2,adj);
        addEdge(7,8,adj);
        addEdge(8,9,adj);
        addEdge(9,7,adj);

        int[] check = new int[vertices+1];
        for (int i = 1;i < visited.length;i++){
            if(visited[i] == 0){
                CheckCycle(i,visited,DFS_visited,adj,check);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < check.length; i++){
            if(check[i] == 1){
                list.add(i);
            }
        }
        System.out.println(list);
    }


    private static boolean CheckCycle(int i, int[] visited, int[] dfs_visited, ArrayList<ArrayList<Integer>> adj,int[] check) {
        visited[i] = 1;
        dfs_visited[i] = 1;
        for (int adjNode : adj.get(i)){
            if(visited[adjNode] == 0){
                if(CheckCycle(adjNode,visited,dfs_visited,adj,check)) {
                    check[adjNode] = 0; // This means this node is included in the cycle
                    return true;
                }
            }
            if(visited[adjNode] == dfs_visited[adjNode]) {
                check[adjNode] = 0; // This means this node is included in the cycle
                return true;
            }
        }
        check[i] = 1;
        dfs_visited[i] = 0;
        return false;
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
    }
}
