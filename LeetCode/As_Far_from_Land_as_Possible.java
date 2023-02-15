package com.company.LeetCode;

import java.util.*;

public class As_Far_from_Land_as_Possible {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
//        System.out.println(maxDistance(grid));

    }
//    public static int maxDistance(int[][] grid) {
//        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
//
//        int res = -1;
//
//        for(int row = 0;row < grid.length; row++){
//            for(int col = 0;col < grid[row].length; col++){
//                if(grid[row][col] == 1){
//                    queue.offer(new Pair<>(row,col));
//                }
//            }
//        }
//
//        if(queue.isEmpty() || queue.size() == grid.length * grid.length) return -1;
//
//        int[] delRow = {-1,0,1,0};
//        int[] delCol = {0,1,0,-1};
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            res++;
//            while(size-- > 0){
//                Pair<Integer,Integer> pr = queue.poll();
//                int x = pr.getKey();
//                int y = pr.getValue();
//                for(int i = 0;i < 4; i++){
//                    int newRow = x + delRow[i];
//                    int newCol = y + delCol[i];
//                    if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[x].length && grid[newRow][newCol] == 0){
//                        grid[newRow][newCol] = 1;
//                        queue.offer(new Pair<>(newRow,newCol));
//                    }
//                }
//            }
//        }
//
//        return res;
//    }
}
