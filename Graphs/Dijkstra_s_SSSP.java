package com.company.Graphs;

import java.util.*;

class NewNode implements Comparator<NewNode> {
    int distance;
    int node;
    public NewNode(int distance,int node){
        this.distance = distance;
        this.node = node;
    }

    public NewNode(){}

    @Override
    public int compare(NewNode o1, NewNode o2) {
        if(o1.distance < o2.distance) return -1;
        if(o1.distance > o2.distance) return 1;
        return 0;
    }
}

public class Dijkstra_s_SSSP {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        PriorityQueue<NewNode> Pq = new PriorityQueue<NewNode>(vertices,new NewNode());

        int[] distance = new int[vertices+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;

        for (int i = 0;i <= vertices;i++){
            adj.add(new ArrayList<>());
        }

        addEdge(1,2,2,adj);
        addEdge(1,4,1,adj);
        addEdge(2,5,5,adj);
        addEdge(2,3,4,adj);
        addEdge(4,3,3,adj);
        addEdge(3,5,1,adj);

        DijkstraShortestPath(adj,Pq,distance);
    }

    private static void DijkstraShortestPath(ArrayList<ArrayList<Pair>> adj, PriorityQueue<NewNode> pq, int[] distance) {
        pq.offer(new NewNode(distance[1],1));
        while(!pq.isEmpty()){
            NewNode node = pq.poll();
            for (Pair adjNode : adj.get(node.node)){
                if(adjNode.weight + distance[node.node] < distance[adjNode.node]){ // Relaxation
                    distance[adjNode.node] = adjNode.weight + distance[node.node];
                    pq.offer(new NewNode(distance[adjNode.node], adjNode.node));
                }
            }
        }
    }

    static void addEdge(int u,int v,int weight,ArrayList<ArrayList<Pair>> adj){
        adj.get(u).add(new Pair(v,weight));
        adj.get(v).add(new Pair(u,weight));
    }
}
