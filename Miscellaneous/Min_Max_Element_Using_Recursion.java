package com.company.Miscellaneous;

public class Min_Max_Element_Using_Recursion {
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, -8};
        System.out.println(isMax(arr,0,arr[0]));
        System.out.println(isMin(arr,0,arr[0]));
    }

    static int isMax(int[] arr, int index, int max){
        if(index == arr.length){
            return max;
        }
        if(arr[index] > max){
            max = arr[index];
        }
        return isMax(arr,index+1,max);
    }
    static int isMin(int[] arr, int index, int min){
        if(index == arr.length){
            return min;
        }
        if(arr[index] < min){
            min = arr[index];
        }
        return isMin(arr,index+1,min);
    }
}
