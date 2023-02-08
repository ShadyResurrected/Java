package com.company.LeetCode;

import java.util.*;

public class Jump_Game_II {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {
        int n = nums.length;
        int[] dpArr = new int[n+1];
        Arrays.fill(dpArr,-1);
        return HelperFunc(0,nums,n,dpArr);
    }

    static int HelperFunc(int index,int[] nums,int n,int[] dpArr){
        // Base Case
        if(index >= n-1) return 0;

        if(dpArr[index] != -1) return dpArr[index];

        // Trying out all combinations
        int res = (int)1e9;
        for(int i = 1;i <= nums[index]; i++){
            if(index + i < n){
                int jumps = 1 + HelperFunc(index+i,nums,n,dpArr);
                res = Math.min(res,jumps);
            }
        }


        return dpArr[index] = res;
    }
}
