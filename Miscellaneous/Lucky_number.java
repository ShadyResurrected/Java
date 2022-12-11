package com.company.Miscellaneous;
// https://leetcode.com/problems/lucky-numbers-in-a-matrix/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lucky_number {
    public static void main(String[] args) {
        int[][] matrix = {
                {7,8},
                {15,16,17,12}
        };
        System.out.println(lucky_Number(matrix));
    }

    static List<Integer> lucky_Number(int[][] matrix){
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int row = 0; row < matrix.length; row++){
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            int check = 0;
//            for(int col = 0; col < matrix[row].length; col++){
//                if(matrix[row][col] < min){
//                    min = matrix[row][col];
//                    check = col;
//                }
//            }
//            for(int row1 = 0; row1 < matrix.length; row1++){
//                if(matrix[row1][check] > max){
//                    max = matrix[row1][check];
//                }
//            }
//
//            if(max == min){
//                list.add(max);
//            }
//        }
//
//        return list;
        ArrayList<Integer> min_list = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int row = 0; row < matrix.length ; row++){
            int min = Integer.MAX_VALUE;
            for(int col = 0; col < matrix[row].length; col++){
//                min = Math.min(matrix[row][col],min);
                if(matrix[row][col] < min){
                    min = matrix[row][col];
                }
            }
            min_list.add(min);
        }

        int max = Integer.MIN_VALUE;
        for(int k : min_list){
            if(k > max){
                max = k;
            }
        }
        list.add(max);
        return list;
    }
}
