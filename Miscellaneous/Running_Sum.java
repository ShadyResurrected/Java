package com.company.Miscellaneous;

import java.util.Arrays;

public class Running_Sum {
    public static void main(String[] args) {
        int[] nums = {3,1,2,10,1};
        System.out.println(Arrays.toString(RunningSum(nums)));
    }


    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        int sum = 0;
        for(int i=0;i< nums.length;i++){
            sum = sum + nums[i];
            ans[i] = sum;
        }
        return ans;
    }


    static int[] RunningSum(int[] nums){
        int[] ans = new int[nums.length];
        int sum = 0;
        for(int i=0;i< nums.length;i++){
            sum = sum + nums[i];
            ans[i] = sum;
        }
        return ans;
    }
}
