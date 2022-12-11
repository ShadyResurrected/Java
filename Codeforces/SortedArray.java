package com.company.Codeforces;

import java.util.Arrays;

public class SortedArray {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = {33,23,43,12,35,23,26};
        int[] arrB = new int[n];
        for (int i = 0 ; i < arr.length - 1; i++){
                int rem = arr.length - i - 1;
                int[] temparr = new int[rem];
                for (int k = i+1 ;k < temparr.length ; k++){
                    temparr[k] = arr[k];
                }
                Arrays.sort(temparr);
                for (int k = i + 1; k < temparr.length; k++){
                    if(temparr[k] > arr[i]){
                        arrB[i] = temparr[k] - arr[i];
                        break;
                    }
                }
        }
        arrB[n-1] = -1;
        int count = 0;
        int countP = 0;
//        System.out.println(Arrays.toString(arrB));
        for (int i = 0 ; i < arrB.length-1 ; i++){
            if(arrB[i] > 0){
                countP++;
            }
            if((arrB[i] > 0 && arrB[i+1] > 0) && (arrB[i] < arrB[i+1])){
                count++;
            }
        }
        if(count == countP-1){
            System.out.println(1);
        }else
            System.out.println(0);
    }
}
