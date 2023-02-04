package com.company.Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Meetings_In_One_Room {
    public static void main(String[] args) {
        int[] start = {7 ,9 ,6 ,2 };
        int[] end = {19, 16, 17 ,5 };
    //        int[] start = {7 ,9 ,6 ,2 };
    //        int[] end = {19, 16, 17 ,5 };
        List<Integer> list = new ArrayList<>();
        int[][] arr = new int[start.length][2];
        for(int i = 0; i < start.length; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr, (a, b) -> Double.compare(a[1],b[1]));
        int i = 0;
        for(int j = 0; j < start.length; j++){
            if(arr[i][0] == start[j] && arr[i][1] == end[j]){
                list.add(j+1);
                break;
            }
        }
        for(int j = 1; j < arr.length; j++){
            if(arr[j][0] > arr[i][1]){
                i = j;
                for(int k = 0; k < start.length; k++){
                    if(arr[j][0] == start[k] && arr[i][1] == end[k]){
                        list.add(k+1);
                        break;
                    }
                }
            }
        }
        System.out.println(list);
    }
}
