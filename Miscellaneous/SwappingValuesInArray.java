package com.company.Miscellaneous;

import java.util.Arrays;

public class SwappingValuesInArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original Array: ");
        System.out.println(Arrays.toString(arr));
        swap(arr, 1, 3);
        System.out.println("Swapped Array: ");
        for(int a: arr){
            System.out.print(a + " ");
        }
    }
    static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
}
