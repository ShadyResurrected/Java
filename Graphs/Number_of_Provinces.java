package com.company.Graphs;

public class Number_of_Provinces {
    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int num = findCircleNum(isConnected);
        System.out.println(num);
    }

    public static int findCircleNum(int[][] isConnected) {
        int vertices = isConnected.length;
        int[] visited = new int[vertices+1];
        int[] provinces = new int[1];
        for(int i = 1;i < visited.length; i++){
            if(visited[i] == 0){
                DFS_Traversal(i,visited,isConnected,vertices);
                provinces[0]++;
            }
        }
        return provinces[0];
    }

    static void DFS_Traversal(int node,int[] visited,int[][] isConnected,int vertices){
        visited[node] = 1;
        for(int i = 0;i < vertices; i++){
            if(node-1 != i && isConnected[node-1][i] == 1 && visited[i+1] == 0){
                DFS_Traversal(i+1,visited,isConnected,vertices);
            }
        }
    }
}
