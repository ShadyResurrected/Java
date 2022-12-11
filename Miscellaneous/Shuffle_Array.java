package com.company.Miscellaneous;
// https://leetcode.com/problems/shuffle-the-array/
import java.util.Arrays;

public class Shuffle_Array {
    public static void main(String[] args) {
        int[] nums = {1,1,2,2};
        int n = 2;
        System.out.println(Arrays.toString(Shuffle(nums,n)));
    }

    public int[] shuffle(int[] nums, int n) {
        int[] arr1 = new int[2*n];
        //At even positions the elements from the first array will be placed
        //At odd positions the elements from the second array will be placed
        int start = 0;
        int end = n;
        int i = 0;
        while(start <= n && end < 2*n){
            if(i%2 == 0){
                arr1[i] = nums[start];
                start++;
            } else{
                arr1[i] = nums[end];
                end++;
            }
            i++;
        }
        return arr1;
    }
    static int[] Shuffle(int[] nums,int n){
        int[] arr1 = new int[2*n];
        //At even positions the elements from the first array will be placed
        //At odd positions the elements from the second array will be placed
        int start = 0;
        int end = n;
        int i = 0;
        while(start <= n && end < 2*n){
            if(i%2 == 0){
                arr1[i] = nums[start];
                start++;
            } else{
                arr1[i] = nums[end];
                end++;
            }
             i++;
        }
        return arr1;
    }
}
