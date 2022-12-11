package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node1{
    int u;
    int v;
    int weight;
    public Node1(int u,int v,int weight){
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class Bellman_Ford_Algorithm {
    public static void main(String[] args) {
        int vertices = 6;
        ArrayList<Node1> adj = new ArrayList<>();
        addEdge(3,2,6,adj);
        addEdge(5,3,1,adj);
        addEdge(0,1,5,adj);
        addEdge(1,5,-3,adj);
        addEdge(1,2,-2,adj);
        addEdge(3,4,-2,adj);
        addEdge(2,4,3,adj);

        int[] distance = new int[vertices];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0] = 0;
        Queue<Node1> queue = new LinkedList<>();

        // Performing N-1 iterations
        for(int i = 0;i < vertices;i++){
            BellmanFord(0,adj,distance,queue,vertices);
        }
        System.out.println(Arrays.toString(distance));
    }

    private static void BellmanFord(int i, ArrayList<Node1> adj, int[] distance, Queue<Node1> queue,int vertices) {
        for(Node1 adjNode : adj){
        //  Relaxing the node
            if(distance[adjNode.u] != Integer.MAX_VALUE && distance[adjNode.u] + adjNode.weight < distance[adjNode.v]){
                distance[adjNode.v] = distance[adjNode.u] + adjNode.weight;
            }
        }
    }

    static void addEdge(int u,int v,int weight,ArrayList<Node1> adj){
        adj.add(new Node1(u,v,weight));
    }
}
