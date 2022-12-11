package com.company.Miscellaneous;

import java.util.Arrays;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,5,5,11};
        int target = 10;
        System.out.println(Arrays.toString(Sum1(arr,target)));
    }
//    public int[] twoSum(int[] nums, int target) {
//        int[] ans = {-1,-1};
//        for(int i=0;i< nums.length;i++){
//            for(int j=1;j< nums.length;j++){
//                if(target == (nums[i] + nums[j])){
//                    ans[0] = i;
//                    ans[1] = j;
//                }
//            }
//        }
//        return ans;
//    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = nums[0];
        int rem = 0;
        for(int i=1;i<=nums.length-1;i++){
            if(target > start){
                rem = target - start;
            } else{
                rem = start - target;
            }
            if(target == (rem + start) && rem == nums[i]){
                ans[0] = start;
                ans[1] = rem;
                ans = FindIndex(nums,ans);
                return ans;
            } else{
                start = nums[i];
            }
        }
        ans = FindIndex(nums,ans);
        return ans;


    }
    static int[] Sum(int[] nums, int target){
        int[] ans = {-1,-1};
        for(int i=0;i<=nums.length-1;i++){
            for(int j=1;j<=nums.length-1;j++){
                if(target == (nums[i] + nums[j]) && i != j){
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }

    static int[] FindIndex(int[] arr,int[] target){
        int num1 = target[0];
        int num2 = target[1];
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num1){
                target[0] = i;
                break;
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num2 && target[0] != i){
                target[1] = i;
                break;
            }
        }
        return target;
    }
    static int[] Sum1(int[] nums, int target){
        int[] ans = {-1,-1};
        int start = nums[0];
        int rem = 0;
        for(int i=1;i<=nums.length-1;i++){
            if(target > start){
                rem = target - start;
            } else{
                rem = start - target;
            }
            if(target == (rem + start) && rem == nums[i]){
                ans[0] = start;
                ans[1] = rem;
                ans = FindIndex(nums,ans);
                return ans;
            } else{
                start = nums[i];
            }
        }
        ans = FindIndex(nums,ans);
        return ans;
    }
}
