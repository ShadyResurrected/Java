package com.company.Miscellaneous;
// https://leetcode.com/problems/number-of-good-pairs/
public class Number_of_Good_Pairs {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(GoodPairs(nums));
    }

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1;j < nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    static int GoodPairs(int[] nums){
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for (int j = i+1;j < nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
        }


        return count;
    }
}
