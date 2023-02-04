package com.company.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Topological_Sort_BFS_Kahns_Algorithm {
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] InDegree = new int[vertices];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0;i < vertices;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(5,0,adj,InDegree);
        addEdge(4,0,adj,InDegree);
        addEdge(4,1,adj,InDegree);
        addEdge(3,1,adj,InDegree);
        addEdge(2,3,adj,InDegree);
        addEdge(5,2,adj,InDegree);

        TopologicalSort(queue,adj,InDegree,list);
    }

    static void TopologicalSort(Queue<Integer> queue,ArrayList<ArrayList<Integer>> adj,int[] InDegree,ArrayList<Integer> list){
        for (int i = 0; i < InDegree.length;i++){
            if(InDegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int Node = queue.poll();
            list.add(Node);
            for (int adjNode : adj.get(Node)){
                InDegree[adjNode] -= 1;
                if(InDegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }
        System.out.println(list);
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj,int[] InDegree){
        adj.get(u).add(v);
        InDegree[v] += 1;
    }
}
