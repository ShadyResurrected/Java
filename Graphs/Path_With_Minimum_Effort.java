package com.company.Graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class PathNode implements Comparator<PathNode> {
    int difference;
    int row;
    int col;
    public PathNode(int diff,int row,int col){
        this.difference = diff;
        this.row = row;
        this.col = col;
    }

    public PathNode(){}

    @Override
    public int compare(PathNode o1, PathNode o2) {
        if(o1.difference < o2.difference) return -1;
        if(o1.difference > o2.difference) return 1;
        return 0;
    }
}

public class Path_With_Minimum_Effort {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2},{3,8,2},{5,3,5}};
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];

        for (int[] row : dist) Arrays.fill(row,(int)1e9);
        dist[0][0] = 0; // Initializing the source vertex's effort as 0

        PriorityQueue<PathNode> pq = new PriorityQueue<PathNode>(n*m,new PathNode());
        int minEffort = HelperFunc(heights,pq,dist);
        System.out.println(minEffort);
    }

    private static int HelperFunc(int[][] heights, PriorityQueue<PathNode> pq, int[][] dist) {
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int n = heights.length;
        int m = heights[0].length;
        pq.offer(new PathNode(0,0,0));
        while(!pq.isEmpty()){
            PathNode curNode = pq.poll();
            int curDiff = curNode.difference;
            int curRow = curNode.row;
            int curCol = curNode.col;

            // Checking for the destination coordinates
            if(curRow == n-1 && curCol == m-1) return curDiff;

            // Traversing all the possible four adjacent directions
            for(int i = 0;i < 4; i++){
                int newRow = delRow[i] + curRow;
                int newCol = delCol[i] + curCol;
                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    int newDiff = Math.abs(heights[curRow][curCol] - heights[newRow][newCol]);
                    if(newDiff < dist[newRow][newCol]){
                        dist[newRow][newCol] = newDiff;
                        pq.offer(new PathNode(Math.max(curDiff,newDiff),newRow,newCol));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}
