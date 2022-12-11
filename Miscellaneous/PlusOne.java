package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/plus-one/
public class PlusOne {
    public static void main(String[] args) {
        int[] digits = {8,9,9,9};
        System.out.println(Arrays.toString(addOne(digits)));
    }

    static int[] addOne(int[] digits){

        int[] arr = new int[digits.length+1];
        if(digits[digits.length-1] < 9){
            digits[digits.length-1] += 1;
            return digits;
        }

        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] + 1 > 9){
                arr[i+1] = 0;
                arr[i] += 1;
            }
        }
//        if(digits[0] + 1 > 9){
//            arr[]
//        }

        return arr;
    }
}
