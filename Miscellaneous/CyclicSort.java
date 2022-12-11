package com.company.Miscellaneous;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        Cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void Cyclic(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1; // This signifies the correct index
            if(arr[correct] != arr[i]){
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;
            } else{
                i++;
            }
        }
    }
}
