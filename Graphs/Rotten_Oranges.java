package com.company.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class cell{
    int i;
    int j;
    int time;
    public cell(int i,int j,int time){
        this.i = i;
        this.j = j;
        this.time = time;
    }
}

public class Rotten_Oranges {
    public static void main(String[] args) {
//        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{0,2}};
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        for(int[] row : visited){
            Arrays.fill(row,-1);
        }
        Queue<cell> queue = new LinkedList<>();
        int countFresh = 0;
        for(int row = 0; row < grid.length;row++){
            for(int col = 0;col < grid[row].length;col++){
                if(grid[row][col] == 2) {
                    queue.offer(new cell(row, col, 0));
                    visited[row][col] = 2;
                }else if(grid[row][col] == 0) visited[row][col] = 0;
                else countFresh++;
            }
        }
        int time = FindMinTime(m,n,grid,visited,queue,countFresh);
        System.out.println(time);
    }

    private static int FindMinTime(int m,int n,int[][] grid, int[][] visited, Queue<cell> queue,int countFresh) {
        int minTime = 0;
        int count = 0;
        while(!queue.isEmpty()){
            cell current = queue.poll();
            int row = current.i;
            int col = current.j;
            int time = current.time;
            minTime = Math.max(minTime,time);
            // Change in row and column values
            // Moving clockwise
            int[] ChangeRow = {-1,0,1,0};
            int[] ChangeCol = {0,1,0,-1};

            // Traversing the neighbours in the four directions
            for(int i = 0;i < 4;i++){
                int newRow = row + ChangeRow[i];
                int newCol = col + ChangeCol[i];
                // check for the validity of the coordinates and then for the unvisited fresh orange
                if(newRow >=0 && newRow < m && newCol >= 0 && newCol < n && visited[newRow][newCol] == -1 && grid[newRow][newCol] == 1){
                    queue.offer(new cell(newRow,newCol,time+1));
                    visited[newRow][newCol] = 2;
                    count++;
                }
            }
        }
        if(count != countFresh) return -1;
        return minTime;
    }
}
