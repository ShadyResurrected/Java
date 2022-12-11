package com.company.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int currentNode;
    int previousNode;

    public Node(int x,int y){
        this.currentNode = x;
        this.previousNode = y;
    }
}

public class Cycle_Detection_Using_BFS {
    public static void main(String[] args) {
        int vertices = 11;

        // Adjacency List
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= vertices; i++){
            adj.add(new ArrayList<>());
        }

        // Adding edges in the graph

        // First Component
        addEdge(1,2,adj);
        addEdge(2,4,adj);

        // Second Component
        addEdge(3,5,adj);
        addEdge(5,6,adj);
        addEdge(6,7,adj);
        addEdge(7,8,adj);
        addEdge(8,11,adj);
        addEdge(8,9,adj);
        addEdge(9,10,adj);
        addEdge(10,5,adj);

        // Visited array
        int[] visited = new int[vertices+1];

        // Driver Code
        int flag = -1;
        Queue<Node> queue = new LinkedList<>();
        for (int i = 1;i <= vertices;i++){
            if(visited[i] == 0){
                if(CheckCycle(i,queue,adj,visited)){
                    System.out.println(true);
                    flag = 0;
                    break;
                }
            }
        }
        if (flag == -1) System.out.println(false);
    }

    private static boolean CheckCycle(int i, Queue<Node> queue, ArrayList<ArrayList<Integer>> adj,int[] visited) {
        // If new node is visited then its previous node is -1
        queue.offer(new Node(i,-1));
        visited[i] = 1;
        while(!queue.isEmpty()){
            Node Current = queue.poll();
            int first = Current.currentNode;
            int second = Current.previousNode;
            ArrayList<Integer> currentAdj = adj.get(first);
            for (int j : currentAdj){
                // if the adjacent node is visited again , it won't ensure a cycle
                // so the visited node must not be the previous node
                if(visited[j] != 0 && second != j) return true;
                if(visited[j] == 0){
                    queue.offer(new Node(j,first));
                    visited[j] = 1;
                }
            }
        }
        return false;
    }

    static void addEdge(int u,int v,ArrayList<ArrayList<Integer>> adj){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
