package com.company.Graphs;

import java.util.ArrayList;

public class Number_of_Provinces_Using_DSU {
    public static void main(String[] args) {

    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        DisjointSet dsu = new DisjointSet(V);
        for(int i = 0;i < adj.size(); i++){
            for(int j = 0;j < adj.get(0).size(); j++){
                if(adj.get(i).get(j) == 1){
                    dsu.unionByRank(i,j);
                }
            }
        }

        int count = 0;
        for(int i = 0;i < V; i++){
            if(dsu.parent.get(i) == i) count++;
        }

        return count;
    }
}
