package com.company.CodingNinjas;

// Not Complete

import java.util.Arrays;

public class Closest_House {
    public static void main(String[] args) {
//        int[][] a = {{4,5},{5,4},{5,5}};
        int[][] a = {{1,2},{1,3},{2,4},{5,6},{3,4}};
        int ans = minDistance(a);
        System.out.println(ans);
    }

    static int minDistance(int[][] a) {
        // Write your code here.
        Arrays.sort(a, (a1, b) -> Double.compare(a1[0], b[0]));
        int distance = 0;

        // Finding the element
        int[][] arr = {{-1,-1}};
        for (int i = 0;i < a.length; i++){
            int diff = Math.abs(a[i][0]-a[i][1]);
            if(a[i][0] == a[i][1]){
                arr[0][0] = a[i][0];
                arr[0][1] = a[i][1];
                break;
            }
            if(arr[0][0] == -1 && arr[0][1] == -1){
                arr[0][0] = a[i][0];
                arr[0][1] = a[i][1];
            }else if((arr[0][0] > a[i][0] && arr[0][1] > a[i][1]) && diff == 1){
                arr[0][0] = a[i][0];
                arr[0][1] = a[i][1];
            }
        }

        for(int i = 0;i < a.length; i++){
            int mid = Math.abs(a[i][0]-arr[0][0]) + Math.abs(a[i][1]-arr[0][1]);
            distance += mid;
        }
        return distance;
    }
}
