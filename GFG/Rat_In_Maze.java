package com.company.GFG;

import java.util.ArrayList;

public class Rat_In_Maze {
    public static void main(String[] args) {
        int[][] m = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        int n = 4;
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 0){
            ans.add("-1");
            System.out.println(ans);
        }
        int[][] visited = new int[n][n];
        StringBuilder res = new StringBuilder();
        FindAllPaths(0,0,n,m,ans,visited,res);
        if(ans.size() == 0) ans.add("-1");
        System.out.println(ans);
    }

    static void FindAllPaths(int row,int col,int n,int[][] m,ArrayList<String> ans,int[][] visited, StringBuilder res){
        if(row == n-1 && col == n-1){
            visited[row][col] = 0;
            ans.add(res.toString());
            return;
        }

        // Moving Down
        if(row < n-1 && m[row+1][col] != 0 && visited[row+1][col] == 0){
            visited[row][col] = 1;
            res.append('D');
            FindAllPaths(row+1,col,n,m,ans,visited,res);
            visited[row][col] = 0;
            res.deleteCharAt(res.length()-1);
        }
        // Moving Left
        if(col > 0 && m[row][col-1] != 0 && visited[row][col-1] == 0){
            visited[row][col] = 1;
            res.append('L');
            FindAllPaths(row,col-1,n,m,ans,visited,res);
            visited[row][col] = 0;
            res.deleteCharAt(res.length()-1);
        }
        // Moving Right
        if(col < n-1 && m[row][col+1] != 0 && visited[row][col+1] == 0){
            visited[row][col] = 1;
            res.append('R');
            FindAllPaths(row,col+1,n,m,ans,visited,res);
            visited[row][col] = 0;
            res.deleteCharAt(res.length()-1);
        }
        // Moving Up
        if(row > 0 && m[row-1][col] != 0 && visited[row-1][col] == 0){
            visited[row][col] = 1;
            res.append('U');
            FindAllPaths(row-1,col,n,m,ans,visited,res);
            visited[row][col] = 0;
            res.deleteCharAt(res.length()-1);
        }
    }
}
