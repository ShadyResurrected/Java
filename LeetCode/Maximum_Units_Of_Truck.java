package com.company.LeetCode;

import java.util.Arrays;

public class Maximum_Units_Of_Truck {
    public static void main(String[] args) {
//        int[][] arr = {{5,10},{2,5},{4,7},{3,9}};
//        int[][] arr = {{1,3},{2,2},{3,1}};
        int[][] arr = {{4,2},{5,5},{4,1},{1,4},{2,5},{1,3},{5,3},{1,5},{5,5},{1,1}};
        int truckSize = 24;
        int max_Box = 0;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        for(int i = arr.length-1; i >= 0; i--){
                int units = arr[i][0];
                if(truckSize-units >= 0){
                    max_Box += arr[i][1] * arr[i][0];
                    truckSize -= units;
                }else if(units - truckSize > 0){
                    max_Box += truckSize * arr[i][1];
                    truckSize = 0;
                }

                if(truckSize == 0){
                    break;
                }
        }
        System.out.println(max_Box);
    }
}
