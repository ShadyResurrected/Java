package com.company.Miscellaneous;

import java.util.Arrays;

public class Squares_of_Sorted_Array {
    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        squareSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void squareSort(int[] arr){
        for (int i = 0;i < arr.length; i++){
            if(arr[i] < 0){
                arr[i] = Math.abs(arr[i]);
            }
            int start = 0;
            int end = arr.length - 1;
            while(start <= end){
                int mid = start + (end-start)/2;
                if(arr[mid] > arr[i]){
                    end = mid - 1;
                }else if(arr[mid] < arr[i]){
                    start = mid + 1;
                }else
                    break;
            }
            if(arr[i] < arr[end]){
                swap(arr,i,start);
            }else if(arr[i] > arr[end]){
                swap(arr,i,end);
            }else
                swap(arr,i,start);
        }
        square(arr);
    }

    static void swap(int[] arr,int start,int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    static void square(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = arr[i] * arr[i];
        }
    }
}
