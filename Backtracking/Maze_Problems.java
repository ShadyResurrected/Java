package com.company.Backtracking;

import java.util.ArrayList;

public class Maze_Problems {
    public static void main(String[] args) {
//        System.out.println(Maze(3,3));
//        PrintPaths("",3,3);
//        System.out.println(PrintPatsRet("",3,3));
//        System.out.println(PrintPathsDiagonal("",3,3));
            boolean[][] maze = {
                    {true,true,true},
                    {true,false,true},
                    {true,true,true}
            };
            pathRestrictions("",maze,0,0);

    }

    static int Maze(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int left = Maze(row-1,col);
        int right = Maze(row,col-1);
        return left + right;
    }

    static void PrintPaths(String p,int row,int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }
        if(row>1){
            PrintPaths(p+"D",row-1,col);
        }
        if(col > 1){
            PrintPaths(p+"R",row,col-1);
        }
    }

    static ArrayList<String> PrintPatsRet(String p,int row,int col){
        if(col == 1 && row == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if(row > 1){
            ans.addAll(PrintPatsRet(p+"D",row-1,col));
        }
        if(col > 1){
            ans.addAll(PrintPatsRet(p+"R",row,col-1));
        }
        return ans;
    }
    static ArrayList<String> PrintPathsDiagonal(String p, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        if (row > 1 && col > 1) {
            ans.addAll(PrintPathsDiagonal(p + "D", row - 1, col - 1));
        }
        if (row > 1) {
            ans.addAll(PrintPathsDiagonal(p + "V", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(PrintPathsDiagonal(p + "H", row, col - 1));
        }
        return ans;
    }

    static void pathRestrictions(String p, boolean[][] maze, int row,int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        if(row < maze.length-1){
            pathRestrictions(p+'D',maze,row+1,col);
        }
        if(col < maze[0].length-1){
            pathRestrictions(p+'R',maze,row,col+1);
        }
    }

}
