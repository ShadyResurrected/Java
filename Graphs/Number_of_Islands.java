package com.company.Graphs;

import java.util.Objects;

class IslandArea{
    int row;
    int col;

    public IslandArea(int row,int col){
        this.row = row;
        this.col = col;
    }
}

public class Number_of_Islands {
    public static void main(String[] args) {
//      char[][] grid = {{'0'},{'1'}};
        String[][] grid = {{"1","1","0","0","0"},{"1","1","0","0","0"},{"0","0","1","0","0"},{"0","0","0","1","1"}};
        int ans = numIslands(grid);
        System.out.println(ans);
    }

    public static int numIslands(String[][] grid) {
        int vertices = grid.length;
        int[][] visited = new int[grid.length][grid[0].length];
        int islands = 0;
        for(int i = 0;i < visited.length; i++){
            for(int j = 0;j < visited[i].length;j++){
                if(visited[i][j] == 0 && Objects.equals(grid[i][j], "1")){
                    HelperFunc(new IslandArea(i,j),grid,vertices,visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    static void HelperFunc(IslandArea node,String[][] grid,int vertices,int[][] visited){
        int row = node.row;
        int col = node.col;
        visited[row][col] = 1;

        if(row-1 >= 0 && Objects.equals(grid[row - 1][col], "1") && visited[row-1][col] == 0){
            HelperFunc(new IslandArea(row-1,col),grid,vertices,visited);
        }

        if(row+1 < grid.length && Objects.equals(grid[row + 1][col], "1") && visited[row+1][col] == 0){
            HelperFunc(new IslandArea(row+1,col),grid,vertices,visited);
        }

        if(col+1 < grid[0].length && Objects.equals(grid[row][col+1], "1") && visited[row][col+1] == 0){
            HelperFunc(new IslandArea(row,col+1),grid,vertices,visited);
        }

        if(col-1 >= 0 && Objects.equals(grid[row][col-1], "1") && visited[row][col-1] == 0){
            HelperFunc(new IslandArea(row,col-1),grid,vertices,visited);
        }
    }
}
