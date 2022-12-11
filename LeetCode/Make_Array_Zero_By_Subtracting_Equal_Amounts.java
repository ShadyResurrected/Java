package com.company.LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class Make_Array_Zero_By_Subtracting_Equal_Amounts {
    public static void main(String[] args) {
        int[] nums = {1,5,0,3,5};
        Arrays.sort(nums);
        HashSet<Integer> hSet = new HashSet<>();
        int count = 0;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != 0){
                int ele = nums[i];
                count += 1;
                for(int j = i; j < nums.length; j++){
                    nums[j] -= ele;
                }
                Arrays.sort(nums);
            }
        }
        System.out.println(count);
    }
}
