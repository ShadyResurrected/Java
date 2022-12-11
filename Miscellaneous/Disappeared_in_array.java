package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class Disappeared_in_array {
    public static void main(String[] args){
        int[] nums ={4,3,2,7,8,2,3,1};
        List<Integer> result = search(nums);
        System.out.println(result);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else
                i++;
        }

        for(int j=0;j< nums.length;j++){
            if(nums[j] != j + 1){
                ans.add(j+1);
            }
        }

        return ans;
    }

    static List<Integer> search(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else
                i++;
        }

        for(int j=0;j< nums.length;j++){
            if(nums[j] != j + 1){
                ans.add(j+1);
            }
        }

        return ans;
    }
}
