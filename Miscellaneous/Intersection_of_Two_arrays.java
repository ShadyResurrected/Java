package com.company.Miscellaneous;

import java.util.Arrays;

public class Intersection_of_Two_arrays {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

    static int[] intersection(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int times = isThere(nums2,target);
            if(times != -1){
                count++;
            }
            if(i < nums1.length-1 && nums1[i] == nums1[i+1]){
                i += 1;
            }
        }
        int[] ans = new int[count];
        count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            ans[count] = isThere(nums2,target);
            if(ans[count] != -1){
                count++;
            }
            if(i < nums1.length-1 && nums1[i] == nums1[i+1]){
                i += 1;
            }
            if(i == nums1.length-1){
                return ans;
            }
        }
        return new int[]{};
    }

    static int isThere(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }else if(arr[mid] < target){
                start = mid + 1;
            }else
                return arr[mid];
        }
        return -1;
    }
}
