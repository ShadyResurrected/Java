package com.company.Miscellaneous;

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        // to check for the starting index
        int start = search(nums,target,true);
        // to check for the ending index
        int end = search(nums,target,false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

//    It will return index value(start and end) of the target element
    static int search(int[] nums,int target,boolean findStartIndex){
        int ans = -1;
        int count = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end-start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            } else{
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

