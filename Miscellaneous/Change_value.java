package com.company.Miscellaneous;

import java.util.Arrays;

public class Change_value {
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void change(int[] nums){
        nums[0] = 78; // if u make change via this reference variable, then a change in the original variable will be made
    }
}
