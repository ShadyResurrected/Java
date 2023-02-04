package com.company.LeetCode.Recursion;

import java.util.ArrayList;

public class Rat_In_A_Maze_All_Paths {
    public static void main(String[] args) {
//        int[][] maze = {{1 ,0 ,1},{1 ,0 ,1},{1, 1 ,1}};
        int[][] maze = {{1 ,0 ,0, 0},{1 ,1 , 0, 1},{1, 1 ,0, 0},{0,1,1,1}};
        int[][] visited = new int[maze.length][maze.length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        FindAllPaths(0,0,maze,ans,visited);
        System.out.println(ans);
    }

    static void FindAllPaths(int row,int col,int[][] maze,ArrayList<ArrayList<Integer>> ans,int[][] visited){
        if(row == maze.length-1 && col == maze[row].length-1){
            visited[row][col] = 1;
            ArrayList<Integer> list = new ArrayList<>();
            for (int[] ele: visited){
                for (int e : ele){
                    list.add(e);
                }
            }
            visited[row][col] = 0;
            ans.add(list);
            return;
        }
        // Going down
        if(row < maze.length-1 && maze[row+1][col] != 0 && visited[row+1][col] == 0){
            visited[row][col] = 1;
            FindAllPaths(row+1,col,maze,ans,visited);
            visited[row][col] = 0;
        }
        // Going left
        if(col > 0 && maze[row][col-1] != 0 && visited[row][col-1] == 0){
            visited[row][col] = 1;
            FindAllPaths(row,col-1,maze,ans,visited);
            visited[row][col] = 0;
        }
        // Going right
        if(col < maze.length-1 && maze[row][col+1] != 0 && visited[row][col+1] == 0){
            visited[row][col] = 1;
            FindAllPaths(row,col+1,maze,ans,visited);
            visited[row][col] = 0;
        }
        // Going up
        if(row > 0 && maze[row-1][col] != 0 && visited[row-1][col] == 0){
            visited[row][col] = 1;
            FindAllPaths(row-1,col,maze,ans,visited);
            visited[row][col] = 0;
        }

        return;
    }
}
