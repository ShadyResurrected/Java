package com.company.Miscellaneous;

import java.util.Arrays;

public class Bubble_Sort {
    public static void main(String[] args){
        int[] arr = {3,1,5,2,4};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void BubbleSort(int[] arr){
        boolean swapped;
        for(int i=0;i<arr.length;i++){
            swapped = false; // If value of swapped remains false then it means that array is already sorted
            for(int j=1;j<arr.length-i;j++){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true; // If a swap occurs then the value of swapped changes
                }
            }

            if(!swapped){
                break;
            }
        }
    }
}
