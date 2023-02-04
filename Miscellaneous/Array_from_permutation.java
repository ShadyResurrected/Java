package com.company.Miscellaneous;
// https://leetcode.com/problems/build-array-from-permutation/
import java.util.Arrays;

public class Array_from_permutation {
    public static void main(String[] args) {
        int[] nums = {5,0,1,2,3,4};
        System.out.println(Arrays.toString(FormArray(nums)));
    }


    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        //ans[i] = nums[nums[i]]
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }


    static int[] FormArray(int[] nums){
        int[] ans = new int[nums.length];
        //ans[i] = nums[nums[i]]
        for(int i=0;i<nums.length;i++){
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
