package com.company.Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class Activity_Selection {
    public static void main(String[] args) {
        int[][] arr = {{0,6},{1,2},{5,8},{5,7},{8,9},{3,4}};
        Arrays.sort(arr, (a, b) -> Double.compare(a[1], b[1]));
        int i = 0;
        int count = 1;
        for (int j = 1; j < arr.length; j++) {
            // If the start time of the activity is greater than or equal to the finish time of previously selected activity then the activity can be performed
            if (arr[j][0] >= arr[i][1]) {
                i = j;
                count++;
            }
        }
        System.out.println(count);
    }
}
