package com.company.LeetCode;

import java.util.*;

public class Find_the_Array_Concatenation_Value {
    public static void main(String[] args) {
        int[] nums = {1,78,27,48,14,86,79,68,77,20,57,21,18,67,5,51,70,85,47,56,22,79,41,8,39,81,59,74,14,45,49,15,10,28};
        System.out.println(findTheArrayConcVal(nums));
    }

    public static long findTheArrayConcVal(int[] nums) {
        long res = 0;
        int start = 0;
        int end  = nums.length - 1;

        while(start <= end){
            long len1 = len_digits(nums[start]);
            long len2 = len_digits(nums[end]);

            long bigger = len1;

            if(nums[start] < nums[end]) bigger = Math.max(len1,len2);
            else if(nums[start] > nums[end]) bigger = Math.min(len1,len2);


            if(start != end){
                res += nums[start] * Math.pow(10,bigger) + nums[end];
            }
            else res += nums[start];

            start++; end--;
        }

        return res;
    }

    static long len_digits(int number){
        return ((long)Math.floor(Math.log10(number)+1));
    }
}
