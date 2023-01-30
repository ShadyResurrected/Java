package com.company.LeetCode;

import java.util.*;

public class Unique_Paths_III {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int res = uniquePathsIII(grid);
        System.out.println(res);
    }

    static int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int sRow = 0;
        int sCol = 0;
        int dRow = 0;
        int dCol = 0;

        int emptySq = m * n - 2;
        for(int row = 0;row < n; row++){
            for(int col = 0;col < m; col++){
                int ele = grid[row][col];

                if(ele == 1){
                    sRow = row; sCol = col;
                }

                if(ele == 2){
                    dRow = row; dCol = col;
                }

                if(ele == -1){
                    emptySq--;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        int[][] visited = new int[n][m];
        for(int[] row : visited) Arrays.fill(row,-1);

        visited[sRow][sCol] = 0;

        int[] curSq = new int[1];

        int[][] dpArr = new int[n][m];
        for(int[] row : dpArr) Arrays.fill(row,-1);

        int res = HelperFunc(sRow,sCol,dRow,dCol,delRow,delCol,emptySq,curSq,grid,n,m,visited);
        return res;
    }

    static int HelperFunc(int curRow,int curCol,int dRow,int dCol,int[] delRow,int[] delCol,int emptySq,int[] curSq,int[][] grid,int n,int m,int[][] visited){
        if(grid[curRow][curCol] == 2){
            if(curSq[0] == emptySq) return 1;
            return 0;
        }

        // Exploring all the possibilities

        int count = 0;
        for(int i = 0;i < 4; i++){
            int newRow = curRow + delRow[i];
            int newCol = curCol + delCol[i];
            if(newRow < n && newCol < m && newRow >= 0 && newCol >= 0 && grid[newRow][newCol] != -1 && visited[newRow][newCol] == -1){
                visited[newRow][newCol] = 0;
                if(grid[newRow][newCol] != 2) curSq[0]++;
                count += HelperFunc(newRow,newCol,dRow,dCol,delRow,delCol,emptySq,curSq,grid,n,m,visited);
                if(grid[newRow][newCol] != 2)  curSq[0]--;
                visited[newRow][newCol] = -1;
            }
        }

        return count;
    }
}
