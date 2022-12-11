package com.company.Backtracking;

import java.util.Arrays;

public class Backtracking_problems {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
//        backtracking("",maze,0,0);
        allPathPrint("",maze,0,0,new int[maze.length][maze[0].length],1);

    }
    static void backtracking(String p, boolean[][] maze, int row,int col){
//        Here Up,Down,Left,Right are allowed
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }

//        If i am considering this index for path then set this as true
        //It means visited
        maze[row][col] = false;
//        Moving Down
        if(row < maze.length-1){
            backtracking(p+'D',maze,row+1,col);
        }
//        Moving Right
        if(col < maze[0].length-1){
            backtracking(p+'R',maze,row,col+1);
        }
//        Moving Up
        if(row > 0){
            backtracking(p+'U',maze,row-1,col);
        }
//        Moving Left
        if(col > 0){
            backtracking(p+'L',maze,row,col-1);
        }

        //this line is where the function gets over
        //so before the function gets removed,revert the changes back to their original state
        maze[row][col] = true;
    }
    static void allPathPrint(String p, boolean[][] maze, int row,int col,int[][] path, int step){
//        Here Up,Down,Left,Right are allowed
        if(row == maze.length-1 && col == maze[0].length-1){
            path[row][col] = step;
//            Since this is the last step
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[row][col]){
            return;
        }

//        If i am considering this index for path then set this as true
        //It means visited
        maze[row][col] = false;
        path[row][col] = step;
//        Moving Down
        if(row < maze.length-1){
            allPathPrint(p+'D',maze,row+1,col,path,step+1);
        }
//        Moving Right
        if(col < maze[0].length-1){
            allPathPrint(p+'R',maze,row,col+1,path,step+1);
        }
//        Moving Up
        if(row > 0){
            allPathPrint(p+'U',maze,row-1,col,path,step+1);
        }
//        Moving Left
        if(col > 0){
            allPathPrint(p+'L',maze,row,col-1,path,step+1);
        }

        //this line is where the function gets over
        //so before the function gets removed,revert the changes back to their original state
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
