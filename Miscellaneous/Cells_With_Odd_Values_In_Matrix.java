package com.company.Miscellaneous;

import java.util.Arrays;

// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
public class Cells_With_Odd_Values_In_Matrix {
    public static void main(String[] args) {
        int m = 2;
        int n = 1;
        int[][] indices = {
                {1,1},
                {0,0}
        };
//        oddValues(m,n,indices);
        System.out.println(oddValues(m,n,indices));
    }


//    int [][] matrix = {
//            {0,0,0},
//            {0,0,0}
//    };

    static int oddValues(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        int odd = 0;

        for(int rowOfIndices = 0; rowOfIndices < indices.length ; rowOfIndices++){
            int updateRow = indices[rowOfIndices][0];
            int updateCol = indices[rowOfIndices][1];
            for(int rowOfMatrix = 0; rowOfMatrix < matrix[updateRow].length; rowOfMatrix++){
                matrix[updateRow][rowOfMatrix] += 1;
            }
            for(int colOfMatrix = 0; colOfMatrix < matrix.length ; colOfMatrix++){
                matrix[colOfMatrix][updateCol] += 1;
            }
        }

        for(int row = 0; row < matrix.length ; row++){
            for (int col = 0; col < matrix[row].length; col++){
                if(matrix[row][col] % 2 == 1){
                    odd++;
                }
            }
        }


        return odd;
    }
}

