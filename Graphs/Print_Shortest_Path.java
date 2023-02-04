package com.company.Graphs;

import java.util.*;

public class Print_Shortest_Path {
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

        int[] parent = new int[vertices+1];
        for(int i = 0;i < parent.length; i++){
            parent[i] = i;
        }
        DijkstraShortestPath(adj,Pq,distance,parent);

        List<Integer> list = new ArrayList<>();
        int node = vertices;
        int src = 1;
        while(parent[node] != node){
            list.add(node);
            node = parent[node];
        }
        list.add(src);
        Collections.reverse(list);
        System.out.println(list);
    }


    private static void DijkstraShortestPath(ArrayList<ArrayList<Pair>> adj, PriorityQueue<NewNode> pq, int[] distance,int[] parent) {
        pq.offer(new NewNode(distance[1],1));
        while(!pq.isEmpty()){
            NewNode node = pq.poll();
            for (Pair adjNode : adj.get(node.node)){
                if(adjNode.weight + distance[node.node] < distance[adjNode.node]){ // Relaxation
                    distance[adjNode.node] = adjNode.weight + distance[node.node];
                    parent[adjNode.node] = node.node;
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
