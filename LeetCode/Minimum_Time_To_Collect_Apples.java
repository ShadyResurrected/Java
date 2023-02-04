package com.company.LeetCode;

import java.util.*;


class Apple{
    int vertex;
    int parent;
    public Apple(int x,int y){
        this.vertex = x;
        this.parent = y;
    }
}

public class Minimum_Time_To_Collect_Apples {
    public static void main(String[] args) {
//        int n = 7;
//        int[][] edges = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
//        List<Boolean> hasApple = Arrays.asList(false, false, true, false, true, true, false);
        int n = 4;
        int[][] edges = {{0,1},{1,2},{0,3}};
        List<Boolean> hasApple = Arrays.asList(true,true,true,true);
        System.out.println(minTime(n,edges,hasApple));
    }

    static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i <= n; i++) adj.add(new ArrayList<>());

        for(int i = 0;i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            addEdge(u,v,adj);
        }

        return HelperFunc(0,adj,hasApple,0);
    }

    static int HelperFunc(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent){
        int total = 0;

        for(int nbr : adj.get(index)){
            // if the neighbor is the parent node, then we skip
            if (nbr == parent)
                continue;

            total += HelperFunc(nbr, adj, hasApple, index);
        }
        // If current node is not the root (0th) node, and it has an apple or any of its descendant has
        //  then we need to add 2 time for moving to and from it
        if( index != 0 && (hasApple.get(index) || total > 0)) total += 2;

        return total;
    }

    static void addEdge(int u,int v,List<List<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}