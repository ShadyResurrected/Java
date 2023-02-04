package com.company.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cycle_Detection_Directed_Graph_BFS {
    public static void main(String[] args) {
        int vertices = 4;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] InDegree = new int[vertices + 1];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0;i <= vertices;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(1,2,adj,InDegree);
        addEdge(2,3,adj,InDegree);
        addEdge(3,4,adj,InDegree);
        addEdge(4,2,adj,InDegree);

        CheckCycle(adj,queue,list,InDegree);

        if(list.size() != vertices) System.out.println("Cycle Detected");
        else System.out.println("No Cycle Detected");
    }

    static void CheckCycle(ArrayList<ArrayList<Integer>> adj,Queue<Integer> queue,ArrayList<Integer> list,int[] InDegree){
        for (int i = 0;i < InDegree.length;i++){
            if(InDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int Node = queue.poll();
            list.add(Node);
            for (int adjNode : adj.get(Node)){
                InDegree[adjNode] -= 1;
                if(InDegree[adjNode] == 0){
                    queue.offer(adjNode);
                }
            }
        }
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj,int[] InDegree){
        adj.get(u).add(v);
        InDegree[v] += 1;
    }
}
