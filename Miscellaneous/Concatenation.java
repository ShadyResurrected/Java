package com.company.Miscellaneous;

import java.util.Arrays;

public class Concatenation {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1,-1,-2};
        System.out.println(Arrays.toString(Concatenate(arr)));
    }

    public int[] getConcatenation(int[] nums) {
        int[] ans = new int[2*nums.length];
        for(int i=0;i < 2*nums.length;i++){
            if(i < nums.length){
                ans[i] = nums[i];
            } else if(i == nums.length){
                ans[i] = nums[nums.length-i];
            } else{
                ans[i] = nums[i - nums.length];
            }
        }
        return ans;
    }

    static int[] Concatenate(int[] nums){
        int[] ans = new int[2*nums.length];
        for(int i=0;i < nums.length;i++){
            ans[i + nums.length] = nums[i];
            ans[i] = nums[i];
        }
        return ans;
    }
}
