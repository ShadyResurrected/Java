package com.company.Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bridges_In_A_Graph {
    public static void main(String[] args) {
        int vertices = 6;
        List<List<Integer>> adj = new ArrayList<>();
        List<List<Integer>> bridges = new ArrayList<>();

        for (int i = 0;i <= vertices;i++){
            adj.add(new ArrayList<>());
        }

//        addEdge(1,2,adj);
//        addEdge(1,4,adj);
//        addEdge(2,3,adj);
//        addEdge(4,3,adj);
//        addEdge(4,5,adj);
//        addEdge(5,6,adj);
//        addEdge(6,7,adj);
//        addEdge(6,9,adj);
//        addEdge(7,8,adj);
//        addEdge(9,8,adj);
//        addEdge(8,10,adj);
//        addEdge(10,11,adj);
//        addEdge(10,12,adj);
//        addEdge(11,12,adj);

        addEdge(2,3,adj);
        addEdge(2,4,adj);
        addEdge(0,4,adj);
        addEdge(5,4,adj);
        addEdge(1,4,adj);
        addEdge(0,5,adj);
        addEdge(1,5,adj);

        int[] InsertionTime = new int[vertices];
        int[] LowestTime = new int[vertices];
        int[] visited = new int[vertices];

        int Bridges = 0;
        int[] timer = new int[1];
        for (int i = 0;i < vertices;i++){
            if(visited[i] == 0){
                Bridges = FindComponents(0,-1,InsertionTime,LowestTime,adj,visited,bridges,timer);
            }
        }
        System.out.println(Bridges);
        System.out.println(bridges);
    }

    private static int FindComponents(int vertex,int parent, int[] insertionTime, int[] lowestTime, List<List<Integer>> adj, int[] visited,List<List<Integer>> bridges,int[] timer) {
        int count = 0;
        insertionTime[vertex] = lowestTime[vertex] = timer[0]++ ;
        visited[vertex] = 1;
        for (int adjEle : adj.get(vertex)){
            if(adjEle == parent) continue;
            if(visited[adjEle] == 0){
                count += FindComponents(adjEle,vertex,insertionTime,lowestTime,adj,visited,bridges,timer);
                lowestTime[vertex] = Math.min(lowestTime[vertex],lowestTime[adjEle]);
                if(lowestTime[adjEle] > insertionTime[vertex]) {
                    List<Integer> row = new ArrayList<>();
                    row.add(adjEle);
                    row.add(vertex);
                    bridges.add(row);
                    count++;
                }
            }else
                lowestTime[vertex] = Math.min(lowestTime[vertex],insertionTime[adjEle]);
        }
        return count;
    }

    static void addEdge(int u,int v,List<List<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
