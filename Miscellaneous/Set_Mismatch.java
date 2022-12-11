package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/set-mismatch/
public class Set_Mismatch {
    public static void main(String[] args) {
        int[] arr = {1,2,2,4};
        System.out.println(Arrays.toString(Mismatch(arr)));
    }


    public int[] findErrorNums(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else
                i++;
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j] != j+1){
                return new int[]{j,j+1};
            }
        }

        return new int[]{-1,-1};
    }
    static int[] Mismatch(int[] arr){
        int i = 0;
//        while(i < arr.length){
//            if(arr[i] != i+1){
//                int correct = arr[i] - 1;
//                if(arr[i] != arr[correct]){
//                    int temp = arr[i];
//                    arr[i] = arr[correct];
//                    arr[correct] = temp;
//                }else{
//                    ans.add(arr[i]);
//                    i++;
//                }
//            }else
//                i++;
//        }

        // Second Method
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else
                i++;
        }
        for(int j=0;j<arr.length;j++){
            if(arr[j] != j+1){
                return new int[]{j,j+1};
            }
        }

        return new int[]{-1,-1};
    }
}
