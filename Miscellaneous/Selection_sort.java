package com.company.Miscellaneous;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args){
        int[] arr = {1};
        SelectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static int greatest(int[] arr, int start, int end){
        int max = 0;
        for(int i = start;i<=end;i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }

    static void swap(int[] arr,int fIndex,int LIndex){
        int temp = arr[fIndex];
        arr[fIndex] = arr[LIndex];
        arr[LIndex] = temp;
    }
    static void SelectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            // find the greatest element in the array and swap with the correct index
            int end = arr.length - i - 1;
            int MAX = greatest(arr,0,end);
            swap(arr,MAX,end);
        }
    }
}
