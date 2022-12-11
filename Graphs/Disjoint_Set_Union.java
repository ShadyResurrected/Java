package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Disjoint_Set_Union {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = 7;
        int[] rank = new int[n+1];
        int[] parent = new int[n+1];
        for (int i = 0;i < parent.length;i++){
            parent[i] = i;
        }
        for (int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }

        // Performing the Union operation

        Union(1,2,rank,adj,parent);
        Union(2,3,rank,adj,parent);
        Union(4,5,rank,adj,parent);
        Union(6,7,rank,adj,parent);
        Union(5,6,rank,adj,parent);
        Union(3,7,rank,adj,parent);

        // Performing the Find operation i.e. path compression
        Find(2,parent,adj);
        Find(3,parent,adj);
        Find(7,parent,adj);

        // have to update the adjacency list

        System.out.println(Arrays.toString(parent));
        System.out.println(adj);
    }

    static void Find(int u,int[] parent,ArrayList<ArrayList<Integer>> adj){
        int copyParent = u;
        while(parent[copyParent] != copyParent){
            copyParent = parent[copyParent];
        }
        parent[u] = copyParent;
    }

    static void Union(int u,int v,int[] rank,ArrayList<ArrayList<Integer>> adj,int[] parent){
        int uParent = u;
        int vParent = v;
        // Finding the root node
        while(parent[uParent] != uParent){
            uParent = parent[uParent];
        }
        while(parent[vParent] != vParent){
            vParent = parent[vParent];
        }
        // Finding the rank of parent node i.e. height of the tree
        int uRank = rank[uParent];
        int vRank = rank[vParent];
        // If the height of both the parent nodes are equal then increase its height by 1
        // else attach the smaller disjoint tree to the larger height tree
        if (uRank == vRank){
            adj.get(uParent).add(v);
            rank[uParent] += 1;
            parent[vParent] = uParent;
        }else{
            if(uRank > vRank){
                adj.get(uParent).add(v);
                parent[vParent] = uParent;
            }else{
                adj.get(vParent).add(u);
                parent[uParent] = vParent;
            }
        }
    }
}
