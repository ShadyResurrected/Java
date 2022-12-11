package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Here it is considered that every edge has unit weight
public class Shortest_Path_Undirected_Graph {
    public static void main(String[] args) {
        int vertices = 9;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[vertices];
        Arrays.fill(distance,Integer.MAX_VALUE);

        for (int i = 0;i < vertices;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0,3,adj);
        addEdge(0,1,adj);
        addEdge(1,3,adj);
        addEdge(1,2,adj);
        addEdge(2,6,adj);
        addEdge(3,4,adj);
        addEdge(4,5,adj);
        addEdge(5,6,adj);
        addEdge(6,7,adj);
        addEdge(6,8,adj);
        addEdge(7,8,adj);

        ShortestPath(distance,queue,adj);

        System.out.println(Arrays.toString(distance));
    }

    private static void ShortestPath(int[] distance, Queue<Integer> queue, ArrayList<ArrayList<Integer>> adj) {
        queue.offer(0);
        distance[0] = 0;
        while (!queue.isEmpty()){
            int Node = queue.poll();
            for (int adjNode : adj.get(Node)){
                int NewDistance = distance[Node] + 1;
                if(NewDistance < distance[adjNode]){
                    queue.offer(adjNode);
                    distance[adjNode] = NewDistance;
                }
            }
        }
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
