package com.company.Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Floyd_Warshall {
    public static void main(String[] args) {
        int vertices = 4;
        int[][] matrix = new int[vertices][vertices];
        for (int[] row : matrix) Arrays.fill(row,(int)(1e9));

        addEdge(0,1,2,matrix);
        addEdge(1,0,1,matrix);
        addEdge(3,0,3,matrix);
        addEdge(3,1,5,matrix);
        addEdge(3,2,4,matrix);
        addEdge(1,2,3,matrix);

        for(int viaVertex = 0;viaVertex < vertices;viaVertex++){
            for (int row = 0;row < matrix.length;row++){
                for(int col = 0;col < matrix[row].length;col++){
                    if(row == col){
                        matrix[row][col] = 0;
                    }else
                        matrix[row][col] = Math.min(matrix[row][col],(matrix[row][viaVertex] + matrix[viaVertex][col]));
                }
            }
        }

        for (int row = 0;row < matrix.length;row++){
            for(int col = 0;col < matrix[row].length;col++){
                if(matrix[row][col] >= (int)(1e9)) System.out.print("INF" + " ");
                else System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    static void addEdge(int u,int v,int weight,int[][] adj){
        adj[u][v] = weight;
    }
}
