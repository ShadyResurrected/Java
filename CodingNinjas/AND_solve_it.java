package com.company.CodingNinjas;

// Not Complete

public class AND_solve_it {
    public static void main(String[] args) {
        int[][] v = {{1,0},{0,1}};
        int ans = goodCells(v);
        System.out.println(ans);
    }

    public static int goodCells(int[][] v) {
        // Write your code here.
        int count = 0;
        int[] rowX = new int[v.length];
        int[] colX = new int[v[0].length];
        for(int row = 0; row < v[0].length; row++){
            // Finding the xor of all row elements
            for(int j = 0;j < v[row].length; j++){
                rowX[row] ^= v[row][j];
            }

            // Finding the xor of all column elements
            for(int j = 0;j < v.length; j++){
                colX[row] ^= v[j][row];
            }
        }

        for(int row : rowX){
            for(int col : colX){
                if(row == col) count++;
            }
        }
        return count;
    }
}
