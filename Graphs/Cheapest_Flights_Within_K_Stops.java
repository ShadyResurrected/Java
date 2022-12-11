package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class FlightStop{
    int stops;
    int node;
    int cost;
    public FlightStop(int a,int b,int c){
        this.stops = a;
        this.node = b;
        this.cost = c;
    }
}

public class Cheapest_Flights_Within_K_Stops {
    public static void main(String[] args) {
        int vertices = 5;
        int k = 2;
        int src = 0;
        int dst = 2;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0;i <= vertices; i++){
            adj.add(new ArrayList<>());
        }

        addEdge(0,1,5,adj);
        addEdge(1,2,5,adj);
        addEdge(0,3,2,adj);
        addEdge(3,1,2,adj);
        addEdge(1,4,1,adj);
        addEdge(4,2,1,adj);

        int[] dist = new int[vertices];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        Queue<FlightStop> queue = new LinkedList<>();
        HelperFunc(adj,queue,dist,src,dst,k);
        System.out.println(dist[dst]);
    }

    private static void HelperFunc(ArrayList<ArrayList<Pair>> adj, Queue<FlightStop> queue, int[] dist, int src, int dst, int k) {
        queue.offer(new FlightStop(0,0,0));
        while (!queue.isEmpty()){
            FlightStop cur = queue.poll();
            int curStop = cur.stops;
            int curNode = cur.node;
            int curCost = cur.cost;

            // Visiting all its adjacent nodes
            for(Pair adjNode : adj.get(curNode)){
                int weight = adjNode.weight;
                if(curCost + weight < dist[adjNode.node] && curStop <= k){
                    dist[adjNode.node] = curCost + weight;
                    queue.offer(new FlightStop(curStop+1, adjNode.node, dist[adjNode.node]));
                }
            }
        }
    }

    static void addEdge(int u,int v,int weight,ArrayList<ArrayList<Pair>> adj){
        adj.get(u).add(new Pair(v,weight));
    }
}
