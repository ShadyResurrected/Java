package com.company.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Articulation_Point {
    public static void main(String[] args) {
        int vertices = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        ArrayList<Integer> points = new ArrayList<>();

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

//        addEdge(5,0,adj);
//        addEdge(4,6,adj);
//        addEdge(1,3,adj);
//        addEdge(5,2,adj);
//        addEdge(0,4,adj);
//        addEdge(4,3,adj);

        addEdge(0,1,adj);
        addEdge(4,1,adj);
        addEdge(4,2,adj);
        addEdge(4,3,adj);
        addEdge(2,3,adj);

        int[] InsertionTime = new int[vertices+1];
        int[] LowestTime = new int[vertices+1];
        int[] visited = new int[vertices+1];

        int[] timer = new int[1];
        int child = 0;

        HashMap<Integer,Integer> hMap = new HashMap<>();
        for(int i = 0;i < vertices;i++){
            if(visited[i] == 0){
                FindComponents(0,-1,InsertionTime,LowestTime,visited,timer,child,adj,hMap);
            }
        }

        ArrayList<Integer> ArtPoints = new ArrayList<>(hMap.keySet());
        if(ArtPoints.size() == 0){
            ArtPoints.add(-1);
        }
        Collections.sort(ArtPoints);
        System.out.println(ArtPoints);
    }
    static void FindComponents(int vertex,int parent,int[] InsertionTime,int[] LowestTime,int[] visited,int[] timer,int child,ArrayList<ArrayList<Integer>> adj,HashMap<Integer,Integer> hMap){
        visited[vertex] = 1;
        InsertionTime[vertex] = LowestTime[vertex] = ++timer[0];
        for(int adjEle : adj.get(vertex)){
            if(adjEle == parent) continue;
            if(visited[adjEle] == 0){
                FindComponents(adjEle,vertex,InsertionTime,LowestTime,visited,timer,child,adj,hMap);
                LowestTime[vertex] = Math.min(LowestTime[vertex],LowestTime[adjEle]);
                if(LowestTime[adjEle] >= InsertionTime[vertex] && parent != -1) {
                    hMap.put(vertex,1);
                }
                child++;
            }else
                LowestTime[vertex] = Math.min(LowestTime[vertex],InsertionTime[adjEle]);
        }
        if(child > 1 && parent == -1) hMap.put(vertex,1);
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
