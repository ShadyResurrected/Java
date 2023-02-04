package com.company.LeetCode.Arrays;

import java.util.ArrayList;

// Incomplete
public class Spiral_Matrix {
    public static void main(String[] args) {

        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> list = new ArrayList<>();
        int col = 0; int row = 0; int rowFinal = matrix.length-1; int colFinal = matrix[0].length-1;
        while(row <= rowFinal && col <= colFinal){

            for(int i = row; i <= colFinal; i++){
                list.add(matrix[i][col]);
            }
            row++;

            for (int i = row; i <= rowFinal; i++){
                list.add(matrix[row][colFinal]);
            }
            colFinal--;

            if(row <= rowFinal){
                for (int i = colFinal; i >= col; i--){
                    list.add(matrix[rowFinal][i]);
                }
            }
            rowFinal--;

            if(col <= colFinal){
                for (int i = rowFinal; i >= row; i--){
                    list.add(matrix[i][row]);
                }
            }
            col++;
        }
        System.out.println(list);
    }
}
