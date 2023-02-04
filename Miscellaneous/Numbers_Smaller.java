package com.company.Miscellaneous;

import java.util.Arrays;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
public class Numbers_Smaller {
    public static void main(String[] args) {
        int[] nums = {8,3,5,1,2,4};
        System.out.println(Arrays.toString(Smaller(nums)));
    }

//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] ans = new int[nums.length];
//        for(int i = 0; i < nums.length; i++){
//            int count = 0;
//            for (int j = 0; j < nums.length; j++) {
//                if(nums[i] > nums[j] && j != i){
//                    count++;
//                }
//            }
//            ans[i] = count;
//        }
//
//        return ans;
//    }
    static int[] Smaller(int[] nums){
        int[] ans = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] > nums[j] && j != i){
                    count++;
                }
            }
            ans[i] = count;
        }

        return ans;
    }
}
