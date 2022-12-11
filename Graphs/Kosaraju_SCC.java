package com.company.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju_SCC {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<ArrayList<Integer>> TransposeAdj = new ArrayList<>();

        for (int i = 0;i <= vertices;i++){
            adj.add(new ArrayList<>());
            TransposeAdj.add(new ArrayList<>());
        }

        addEdge(1,2,adj,TransposeAdj);
        addEdge(2,3,adj,TransposeAdj);
        addEdge(3,1,adj,TransposeAdj);
        addEdge(2,4,adj,TransposeAdj);
        addEdge(4,5,adj,TransposeAdj);

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[vertices+1];

        // Performing topological sort to sort the nodes as per their finishing time
        for(int i = 1;i <= vertices;i++){
            if(visited[i] == 0){
                TopoSort(i,adj,stack,visited);
            }
        }
        List<Integer> list = new ArrayList<>();
        int[] visitedSCC = new int[vertices+1];
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(visitedSCC[node] == 0){
                list.add(node);
                SccKosaraju(node,visitedSCC,TransposeAdj,list);
            }
        }
        System.out.println(list);
    }

    private static void SccKosaraju(int node, int[] visitedSCC, ArrayList<ArrayList<Integer>> transposeAdj, List<Integer> list) {
        visitedSCC[node] = 1;
        for (int adjNode : transposeAdj.get(node)){
            if(visitedSCC[adjNode] == 0){
                list.add(adjNode);
                SccKosaraju(adjNode,visitedSCC,transposeAdj,list);
            }
        }
    }

    private static void TopoSort(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack,int[] visited) {
        visited[i] = 1;
        for(int adjNode : adj.get(i)){
            if(visited[adjNode] == 0){
                TopoSort(adjNode,adj,stack,visited);
            }
        }
        stack.push(i);
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj,ArrayList<ArrayList<Integer>> TransposeAdj){
        adj.get(u).add(v);
        addTransposeEdge(u,v,TransposeAdj);
    }

    static void addTransposeEdge(int u,int v,ArrayList<ArrayList<Integer>> TransposeAdj){
        TransposeAdj.get(v).add(u);
    }
}
