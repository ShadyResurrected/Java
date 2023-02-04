package com.company.Graphs;

public class Connecting_The_Graph {
    public static void main(String[] args) {

    }

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet dsu = new DisjointSet(n);

        int extraEdges = 0;

        for(int i = 0;i < edge.length; i++){
            int u = edge[i][0];
            int v = edge[i][1];
            if(dsu.findUPar(u) == dsu.findUPar(v)) extraEdges++;
            else dsu.unionByRank(u,v);
        }

        int components = 0;

        for(int i = 0;i < n; i++){
            if(dsu.parent.get(i) == i) components++;
        }

        if(extraEdges >= components-1) return components - 1;
        return -1;
    }
}
