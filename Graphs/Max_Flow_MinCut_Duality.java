package com.company.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Max_Flow_MinCut_Duality {
    public static void main(String[] args) {
        int vertices = 6;
        int[][] adj = { {0, 16, 13, 0, 0, 0},
                {0, 0, 10, 12, 0, 0},
                {0, 4, 0, 0, 14, 0},
                {0, 0, 9, 0, 0, 20},
                {0, 0, 0, 7, 0, 4},
                {0, 0, 0, 0, 0, 0}
        };
//        addEdge(0,1,16,adj);
//        addEdge(0,2,13,adj);
//        addEdge(1,2,10,adj);
//        addEdge(2,1,4,adj);
//        addEdge(1,3,12,adj);
//        addEdge(2,4,14,adj);
//        addEdge(3,2,9,adj);
//        addEdge(4,3,7,adj);
//        addEdge(3,5,20,adj);
//        addEdge(4,5,4,adj);

        int source = 0;
        int destination = 5;
        int res = Max_flow(source,destination,adj,vertices);

        boolean[] isVisited = new boolean[adj.length];
        ReachableVertex(adj,source,isVisited);

        for (int i = 0;i < adj.length;i++){
            for (int j = 0;j < adj.length;j++){
                if(adj[i][j] > 0 && isVisited[i] && !isVisited[j]){
                    System.out.println(i + " " + j);
                }
            }
        }
        System.out.println(res);
    }

    private static void ReachableVertex(int[][] adj, int source, boolean[] isVisited) {
        isVisited[source] = true;
        for (int i = 0;i < adj.length;i++){
            if(adj[source][i] > 0 && !isVisited[i]){
                ReachableVertex(adj,i,isVisited);
            }
        }
    }

    private static int Max_flow(int source, int destination, int[][] adj,int vertices) {
        int max_flow = 0;
        int[] parent = new int[vertices];
        Arrays.fill(parent,-1);
        while(pathExists(source,destination,adj,vertices,parent)){
            int flow = Integer.MAX_VALUE;

            // finding the minimum residual capacity of the edges in
            // augmenting path
            for (int i = destination;i != source;i = parent[i]){
                int currentEdge = parent[i];
                flow = Math.min(flow,adj[currentEdge][i]);
            }

            for (int i = destination;i != source;i = parent[i]){
                int currentEdge = parent[i];
                adj[currentEdge][i] -= flow;
                adj[i][currentEdge] += flow;
            }

            max_flow += flow;
        }
        return max_flow;
    }

    private static boolean pathExists(int source, int destination, int[][] adj,int vertices,int[] parent) {
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[vertices];
        queue.offer(source);
        visited[source] = 1;
        parent[source] = -1;
        while(!queue.isEmpty()){
            int curNode = queue.poll();
            for (int adjNode = 0; adjNode < adj[curNode].length;adjNode++){
                if(visited[adjNode] != 1 && adj[curNode][adjNode] > 0){
                    visited[adjNode] = 1;
                    queue.offer(adjNode);
                    parent[adjNode] = curNode;

                    // if we are able to find a connection
                    // to destination from any of the nodes then a path exists
                    if(adjNode == destination) {
                        parent[adjNode] = curNode;
                        return true;
                    }

                }
            }
        }
        return false;
    }

    static void addEdge(int u,int v,int capacity,int[][] adj){
        adj[u][v] = capacity;
    }
}
