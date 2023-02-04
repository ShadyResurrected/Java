package com.company.Graphs;

public class Adjacency_Matrix {
    public static void main(String[] args) {
        int vertices = 5;
        int edges = 7;
        int[][] matrix = new int[edges+1][edges+1];

        // There exists a edge between edge 1 and 2
        matrix[1][2] = 1;
        matrix[2][1] = 1;
    }
}
