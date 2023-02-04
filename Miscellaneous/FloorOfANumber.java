package com.company.Miscellaneous;

import java.util.Scanner;

public class FloorOfANumber {
    public static void main(String[] args){
        int[] arr={12,23,25,26,45,57,89};
        int target = 27;
        int result = Floor(arr,target);
        System.out.println(result);
    }
//    Floor means the greatest number samller or equal to the target
    static int Floor(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = (start+end)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }
            if(arr[mid] < target){
                start = mid + 1;
            }
        }
        return arr[start];
    }
}
