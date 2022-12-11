package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;

public class SumTriangle_fromArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(sumOfTriangle1(arr)));
    }

    static int[] sumOfTriangle(int[] arr,int counter){
        if(counter == arr.length-1){
            return arr;
        }
        int index = 0;
        while(index < arr.length - 1 - counter){
            arr[index] = arr[index] + arr[index+1];
            index++;
        }
        arr[index] = 0;
        return sumOfTriangle(arr,counter+1);
    }

    static int[] sumOfTriangle1(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        int[] arr1 = new int[arr.length-1];
        int index = 0;
        while(index < arr1.length){
            arr1[index] = arr[index] + arr[index+1];
            index++;
        }
        return sumOfTriangle1(arr1);
    }
}
