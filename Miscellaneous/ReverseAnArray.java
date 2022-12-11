package com.company.Miscellaneous;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4, 5};
        reverse(arr);
        for(int a: arr){
            System.out.print(a + " ");
        }
    }
    static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    static void reverse(int[] num){
        int start = 0;
        int end = num.length - 1;
        for( start = 0; start <= end; start++,end--){
//            int temp = num[start];
//            num[start] = num[end];
//            num[end] = temp;
            swap(num, start, end);
        }
    }
}
