package com.company.LeetCode;

public class Jump_Game {
    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {2,0,0};
        int[] nums = {2,5,0,0};
        boolean res = HelperFunc(0,nums,nums.length-1);
    }

    static boolean HelperFunc(int index,int[] nums,int n){
        // Base Case
        if(index >= n) return true;
        if(nums[index] == 0 && index < n) return false;

        // Trying all the possibilities
        int steps = nums[index];
        boolean res = false;
        for(int i = 1;i <= steps; i++){
            if(HelperFunc(index+i,nums,n)){
                res = true;
                return res;
            };
        }

        return res;
    }
}
