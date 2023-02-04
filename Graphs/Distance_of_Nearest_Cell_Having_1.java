package com.company.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class dist{
    int row;
    int col;
    int distance;
    public dist(int row,int col,int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}

public class Distance_of_Nearest_Cell_Having_1 {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{1,0,1}};
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] clone = new int[grid.length][grid[0].length];
        Queue<dist> queue = new LinkedList<>();
        for(int row = 0;row < grid.length;row++){
            for(int col = 0;col < grid[row].length;col++){
                if(grid[row][col] == 1){
                    visited[row][col] = 1;
                    queue.offer(new dist(row,col,0));
                }
            }
        }
        HelperFunc(grid,clone,visited,queue);
    }

    static void HelperFunc(int[][] grid,int[][] clone,int[][] visited,Queue<dist> queue){
        while(!queue.isEmpty()){
            dist ele = queue.poll();
            int row = ele.row;
            int col = ele.col;
            int distance = ele.distance;
            clone[row][col] = distance;

            // Moving down
            if(row+1 < grid.length && visited[row+1][col] == 0){
                visited[row+1][col] = 1;
                queue.offer(new dist(row+1,col,distance+1));
            }

            // Moving up
            if(row-1 >= 0 && visited[row-1][col] == 0){
                visited[row-1][col] = 1;
                queue.offer(new dist(row-1,col,distance+1));
            }

            // Moving left
            if(col-1 >= 0 && visited[row][col-1] == 0){
                visited[row][col-1] = 1;
                queue.offer(new dist(row,col-1,distance+1));
            }

            // Moving right
            if(col+1 < grid[0].length && visited[row][col+1] == 0){
                visited[row][col+1] = 1;
                queue.offer(new dist(row,col+1,distance+1));
            }
        }
    }
}
