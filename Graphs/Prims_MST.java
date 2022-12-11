package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Nodes{
    int v;
    int weight;
    public Nodes(int v,int weight){
        this.v = v;
        this.weight = weight;
    }
}
public class Prims_MST {
    public static void main(String[] args) {
        int vertices = 5;
        int edges = 6;
        ArrayList<ArrayList<Nodes>> adj = new ArrayList<>();
        for (int i = 0;i < vertices;i++){
            adj.add(new ArrayList<>());
        }
        int[] key = new int[vertices];
        boolean[] MST = new boolean[vertices];
        int[] parent = new int[vertices];
        Arrays.fill(key,Integer.MAX_VALUE);
        key[0] = 0;
        Arrays.fill(parent,-1);

        addEdge(0,1,2,adj);
        addEdge(0,3,6,adj);
        addEdge(1,3,8,adj);
        addEdge(1,4,5,adj);
        addEdge(1,2,3,adj);
        addEdge(4,2,7,adj);


        while(vertices-- > 0){
            int minNode = CheckMin(key,MST,adj);
            for(Nodes adjNode : adj.get(minNode)){
                if(!MST[adjNode.v]){
                    if(adjNode.weight < key[adjNode.v]){
                        // Replacing the weight of node if it is less than the previous one
                        key[adjNode.v] = adjNode.weight;
                        // Change its parent value
                        parent[adjNode.v] = minNode;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(key));
    }

    private static int CheckMin(int[] key, boolean[] mst, ArrayList<ArrayList<Nodes>> adj) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < key.length; i++){
            if(key[i] < min && !mst[i]){
                min = i;
            }
        }
        mst[min] = true;
        return min;
    }

    static void addEdge(int v,int u,int weight,ArrayList<ArrayList<Nodes>> adj){
        adj.get(v).add(new Nodes(u,weight));
        adj.get(u).add(new Nodes(v,weight));
    }
}
