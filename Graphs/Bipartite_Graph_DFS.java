package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bipartite_Graph_DFS {
    public static void main(String[] args) {
        int vertices = 8;
        int edges = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] colors = new int[vertices+1];
        Arrays.fill(colors,-1);
        int flag = 1;

        for(int i = 0;i <= vertices; i++){
            adj.add(new ArrayList<>());
        }

//        addEdge(1,2,adj);
//        addEdge(2,3,adj);
//        addEdge(3,4,adj);
//        addEdge(2,6,adj);
//        addEdge(4,5,adj);
//        addEdge(6,5,adj);
//        addEdge(7,5,adj);
//        addEdge(7,8,adj);

//            addEdge(0,6,adj);
//            addEdge(0,5,adj);
//            addEdge(1,0,adj);
//            addEdge(1,2,adj);
//            addEdge(2,4,adj);
//            addEdge(3,5,adj);
//            addEdge(3,6,adj);
//            addEdge(4,9,adj);
//            addEdge(4,5,adj);
//            addEdge(7,1,adj);
//            addEdge(7,4,adj);
//            addEdge(8,6,adj);
//            addEdge(9,2,adj);

        addEdge(0,7,adj);
        addEdge(1,5,adj);
        addEdge(2,4,adj);
        addEdge(3,1,adj);
        addEdge(4,3,adj);
        addEdge(5,2,adj);
        addEdge(6,0,adj);
        addEdge(7,5,adj);

        for (int i = 0; i < colors.length; i++){
            if(colors[i] == -1){
                if(!CheckBipartite(i,colors,adj)){
                    flag = -1;
                    break;
                }
            }
        }

        if(flag == -1) System.out.println("Not Bipartite");
        else System.out.println("Bipartite");
    }

    private static boolean CheckBipartite(int i, int[] colors, ArrayList<ArrayList<Integer>> adj) {
        if(colors[i] == -1) colors[i]= 1;
        for (int node : adj.get(i)){
            if(colors[node] == -1){
                colors[node] = 1 - colors[i];
                if(!CheckBipartite(node,colors,adj)) return false;
            }
            if(colors[node] == colors[i]) return false;
        }
        return true;
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
