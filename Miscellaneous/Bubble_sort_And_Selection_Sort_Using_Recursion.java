package com.company.Miscellaneous;

import java.util.Arrays;

public class Bubble_sort_And_Selection_Sort_Using_Recursion {
    public static void main(String[] args) {
        int[] arr = {7,2,4,6,1};
//        System.out.println(Arrays.toString(bubbleSort(arr,arr.length-1,0)));
        System.out.println(Arrays.toString(selectionSort(arr,arr.length,0,0)));
    }

    static int[] bubbleSort(int[] arr, int outeri,int inneri){
        if(outeri == 0){
            return arr;
        }
        if(inneri < outeri){
            if(arr[inneri] > arr[inneri+1]){
                swap(arr,inneri,inneri+1);
            }
            return bubbleSort(arr,outeri,inneri+1);
        }else
            return bubbleSort(arr,outeri-1,0);

    }
    static int[] selectionSort(int[] arr, int row, int col, int max){
        if(row == 0){
            return arr;
        }
        if(col < row){
            if(arr[col] > arr[max]){
                max = col;
            }
            return selectionSort(arr,row,col+1,max);
        }
        swap(arr,max,row-1);
        return selectionSort(arr,row-1,0,0);
    }

    static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
