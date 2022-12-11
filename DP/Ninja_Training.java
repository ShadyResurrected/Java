package com.company.DP;

import java.util.Arrays;

public class Ninja_Training {
    public static void main(String[] args) {
        int[][] points = {{10,40,70},{20,50,80},{30,60,90}};
        int days = points.length;
        int[][] dpArr = new int[days][4];
        for(int[] row : dpArr){
            Arrays.fill(row,-1);
        }
        int[][] tabulated = new int[days][4];
        int[] prev = new int[4];

//      int maxPoints = FindPoints(days-1,points,3);
//      int maxPoints1 = FindPoints1(days-1,points,3,dpArr);
//      int maxPoints2 = FindPoints2(days,points,3,tabulated);
        int maxPoints3 = FindPoints3(days,points,3,prev);
        System.out.println(maxPoints3);
    }

    static int FindPoints(int day,int[][] points,int lastTask){
        // Base Case
        if(day == 0){
            int maxPoint = 0;
            for(int i = 0;i < 3;i++){
                if(i != lastTask){
                    maxPoint = Math.max(maxPoint,points[day][i]);
                }
            }
            return maxPoint;
        }
        int maxPoints = 0;
        for (int i = 0;i < 3;i++){
            if(i != lastTask){
                int curPoints = points[day][i] + FindPoints(day-1,points,i);
                maxPoints = Math.max(maxPoints,curPoints);
            }
        }
        return maxPoints;
    }

    static int FindPoints1(int day,int[][] points,int lastTask,int[][] dpArr){
        // Base Case
        if(day == 0){
            int maxPoint = 0;
            for(int i = 0;i < 3;i++){
                if(i != lastTask){
                    maxPoint = Math.max(maxPoint,points[day][i]);
                }
            }
            return maxPoint;
        }
        if(dpArr[day][lastTask] != -1) return dpArr[day][lastTask];
        int maxPoints = 0;
        for (int i = 0;i < 3;i++){
            if(i != lastTask){
                int curPoints = points[day][i] + FindPoints1(day-1,points,i,dpArr);
                maxPoints = Math.max(maxPoints,curPoints);
            }
        }
        return dpArr[day][lastTask] = maxPoints;
    }

    // Tabulation (Bottom-Up Approach)
    static int FindPoints2(int days,int[][] points,int tasks,int[][] tabulated){
        // Declaring the base case
        tabulated[0][0] = Math.max(points[0][1],points[0][2]);
        tabulated[0][1] = Math.max(points[0][0],points[0][2]);
        tabulated[0][2] = Math.max(points[0][1],points[0][0]);
        int maxLast = Math.max(points[0][1],points[0][2]);
        tabulated[0][3] = Math.max(points[0][0],maxLast);

        for(int i = 1;i < days;i++){
            for(int lastTask = 0;lastTask <= 3;lastTask++){
                tabulated[i][lastTask] = 0;
                for(int index = 0; index < 3;index++){
                    if(index != lastTask){
                        int currentPoint = points[i][index] + tabulated[i-1][index];
                        tabulated[i][lastTask] = Math.max(currentPoint,tabulated[i][lastTask]);
                    }
                }
            }
        }
        return tabulated[days-1][3];
    }

    // Space Optimization
    static int FindPoints3(int days,int[][] points,int task,int[] prev){
        // Initialising the base case
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][1],points[0][0]);
        prev[3] = Math.max(points[0][1],Math.max(points[0][0],points[0][2]));

        // Iterating through the array
        // from the day 1 because we have already defined for day 0 in the base case
        for(int day = 1;day < days;day++){
            int[] dummyArr = new int[4];
            for(int lastTask = 0;lastTask < 4;lastTask++){
                dummyArr[lastTask] = 0;
                for (int index = 0;index < 3;index++){
                    if(lastTask != index){
                        dummyArr[lastTask] = Math.max(dummyArr[index],points[day][index]+prev[index]);
                    }
                }
            }
            prev = dummyArr;
        }
        return prev[3];
    }
}
