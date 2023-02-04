package com.company.Miscellaneous;
// https://leetcode.com/problems/transpose-matrix/submissions/
import java.lang.reflect.Array;
import java.util.Arrays;

public class Transpose_of_Matrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int[][] ans = transpose(matrix);
        for (int row = 0; row < ans.length ; row++){
            System.out.println(Arrays.toString(ans[row]));
        }
    }

    static int[][] transpose(int[][] matrix){
        int[][] tMatrix = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < matrix.length ; row++){
            for (int col = 0; col < matrix[row].length ; col++){
                tMatrix[col][row] = matrix[row][col];
            }
        }
        return tMatrix;
    }
}
