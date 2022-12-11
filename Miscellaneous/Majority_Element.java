package com.company.Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Majority_Element {
    public static void main(String[] args) {
//        int[] nums = {2,2,2,2,4,5,6,3,65,43,4,4,4,4,4,4,4,4,4,2,2,2,2,2};
        int[] nums = {1,2};
        System.out.println(findMajority2(nums));
    }

    static int findMajorityElement(int[] nums){
        int times = (int)(Math.floor(nums.length/2));
        Arrays.sort(nums);
        int count = 0;
        int maj = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                int contender = countOccurrences(nums,nums[i]);
                if(contender > count){
                    count = contender;
                    maj = nums[i];
                }
                i += contender - 1;
            }
        }
        return maj;
    }
    static int countOccurrences(int[] arr, int num){
        int count = 0;
        for (int i = 0; i < arr.length ; i++){
            if(num == arr[i]){
                count++;
            }
        }
        return count;
    }

    static List<Integer> findMajority2(int[] nums){
        List<Integer> list = new ArrayList<>();
        int times = (int)(Math.floor(nums.length/3));
        Arrays.sort(nums);
        int count = 0;
        int maj = 0;
        if(nums.length < 3){
            for (int i = 0; i < nums.length; i++){
                list.add(nums[i]);
            }
        }else{
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] == nums[i+1]){
                    int contender = countOccurrences(nums,nums[i]);
                    if(contender > times){
                        maj = nums[i];
                        list.add(maj);
                    }
                    i += contender - 1;
                }
            }
        }
        return list;
    }
}
