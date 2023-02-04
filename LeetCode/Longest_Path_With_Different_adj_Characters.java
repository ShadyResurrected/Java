package com.company.LeetCode;

import java.util.*;

public class Longest_Path_With_Different_adj_Characters {
    public static void main(String[] args) {
        int[] parent = {-1,0,0,1,1,2};
        String s = "abcdee";
        System.out.println(longestPath(parent,s));
    }

    static int longestPath(int[] parent, String s) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i < parent.length; i++) adj.add(new ArrayList<>());

        for(int i = 1;i < parent.length; i++){
            int u = i;
            int v = parent[i];
            addEdge(u,v,adj);
        }

        HashMap<Integer,Character> hMap = new HashMap<>();

        for(int i = 0;i < s.length(); i++) hMap.put(i,s.charAt(i));

        int[] visited = new int[parent.length];

        return HelperFunc(0,s.charAt(0),adj,hMap,visited);
    }

    static int HelperFunc(int vertex,char label,List<List<Integer>> adj,HashMap<Integer,Character> hMap,int[] visited){
        int included = 1;
        int notIncluded = 1;
        visited[vertex] = 1;
        for(int adjNode : adj.get(vertex)){
            char adjLabel = hMap.get(adjNode);
            if(visited[adjNode] == 0){
                if(adjLabel == label) included += HelperFunc(adjNode,adjLabel,adj,hMap,visited);
                else notIncluded += HelperFunc(adjNode,adjLabel,adj,hMap,visited);
            }
        }
        return Math.max(included,notIncluded);
    }

    static void addEdge(int u,int v,List<List<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
