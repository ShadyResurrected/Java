package com.company.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public static void main(String[] args) {

        // Using HashSet
        int[] nums = {102,4,100,1,101,3,2};
        int countAns = 0;
        HashSet<Integer> hashSet = new HashSet<>();
//         Inserting the values in hashmap
        for(int i  = 0; i < nums.length; i++){
            hashSet.add(nums[i]);
        }
//         Again iterating the hashmap to check for the longest common subsequence
        for(int i = 0; i < nums.length ; i++){
            int value = nums[i]-1;
            if(hashSet.contains(value)){
                continue;
            }else {
                int count = 0;
                while(hashSet.contains(value+1)){
                    count++;
                    value++;
                }
                if(count > countAns){
                    countAns = count;
                }
            }
        }

        // Using simple logic
//        int[] nums = {0,0};
        Arrays.sort(nums);
        int count = 1;
//        int countAns = 0;
        if(nums.length < 2){
            if(nums.length == 0){
                System.out.println(0);
            }else{
                System.out.println(count);;
            }
        }
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }else if(nums[i+1] == nums[i] + 1){
                count++;
            }else
                count = 1;

            countAns = Math.max(count,countAns);
        }

        System.out.println(countAns);;



        System.out.println(countAns);
    }
}
