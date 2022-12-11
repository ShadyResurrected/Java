package com.company.Miscellaneous;

import java.util.Arrays;

public class TwoSumAnotherMethod {
    public static void main(String[] args) {
        int[] arr = {2,5,5,11};
        int target = 10;
        System.out.println(Arrays.toString(TwoSum(arr,target)));
    }


    static int[] TwoSum(int[] arr,int target){
        int[] ans= {-1,-1};
        int rem;
        for(int i=0;i<arr.length;i++){
            if(target < arr[i]){
                return ans;
            } else
                rem = target - arr[i];
            int index = Check(arr,target,rem,i);
            if(index == -1){
                continue;
            } else{
                ans[0] = i;
                ans[1] = index;
                return ans;
            }
        }

        return ans;
    }

    static int Check(int[] arr,int target,int rem,int start){
        for(int i=start+1;i<arr.length;i++){
            if(rem == arr[i]){
                return i;
            }
        }
        return -1;
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] ans= {-1,-1};
//        int rem;
//        for(int i=0;i<nums.length;i++){
//            if(target < nums[i]){
//                return ans;
//            } else
//                rem = target - nums[i];
//            int index = Check(nums,target,rem);
//            if(index == -1){
//                continue;
//            } else{
//                ans[0] = i;
//                ans[1] = index;
//                return ans;
//            }
//        }
//
//        return ans;
//    }
}
