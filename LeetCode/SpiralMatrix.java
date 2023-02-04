package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

// Incomplete

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(printSpiralMatrix(arr));
    }

    static List<Integer> printSpiralMatrix(int[][] matrix){
        List<Integer> list = new ArrayList<>();

        //Traversing row 1
        for (int row = 0; row < 1; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                list.add(matrix[row][col]);
            }
        }
        //Traversing last column
        for (int row = 0; row < matrix.length; row++) {
            list.add(matrix[row][matrix[row].length-1]);
        }
        //Traversing last row
        for (int col = matrix[matrix.length-1].length-1; col >= 0; col--) {
            list.add(matrix[matrix.length-1][col]);
        }



        return list;
    }
}
