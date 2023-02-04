package com.company.LeetCode;

import java.util.*;

public class Max_Points_on_a_Line {
    public static void main(String[] args) {
//        int[][] points = {{1,1},{2,2},{3,3}};
        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int res = maxPoints(points);
        System.out.println(res);
    }

    static int maxPoints(int[][] points) {
        int res = 0;
        for(int i = 0;i < points.length;i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            HashMap<Double,Integer> hMap = new HashMap<>();
            for(int j = 0;j < points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                if(x1 == x2 && y1 == y2) continue;

                double slope = 0;
                if(x2 - x1 != 0) slope = (y2-y1)/(double)(x2-x1);
                else slope = Double.POSITIVE_INFINITY;

                if(hMap.containsKey(slope)){
                    int counter = hMap.get(slope);
                    hMap.put(slope,counter+1);
                }else hMap.put(slope,1);

                res = Math.max(res,hMap.get(slope));
            }
        }
        return res+1;
    }
}
