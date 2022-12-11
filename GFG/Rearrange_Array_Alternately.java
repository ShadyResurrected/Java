package com.company.GFG;

import java.util.Arrays;

public class Rearrange_Array_Alternately {
    public static void main(String[] args) {
        long[] arr = {1,2,3,4,5,6};
        rearrange(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void rearrange(long arr[], int n){

        // Your code here
        int start = 0;
        int end = n - 1;
        int i = 0;

        while(start < end){
            swap(start,end,arr);
            for(int j = i+1;j < end; j++){
                swap(j,end,arr);
            }
            i += 2;
            start = i;
        }
    }


    static void swap(int i,int j,long[] arr){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
