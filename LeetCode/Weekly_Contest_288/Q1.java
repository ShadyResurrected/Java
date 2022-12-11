package com.company.LeetCode.Weekly_Contest_288;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        int n = 568;
        LargestNum(n);
    }

    static void LargestNum(int n){
        int length = (int)(Math.log10(n)) + 1;
        int[] arr = new int[length];
        int i = 0;
        while(n > 0){
            int rem = n % 10;
            arr[length-1-i] = rem;
            i++;
            n /= 10;
        }
        for (int j = 0; j < arr.length-1; j++){
            for (int k = j + 1; k < arr.length ; k++){
                if(arr[j] < arr[k]){
                    if(((arr[j]%2 != 0) && (arr[k]%2 != 0)) || ((arr[j]%2 == 0) && (arr[k]%2 == 0))){
                        int temp = arr[j];
                        arr[j] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
