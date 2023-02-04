package com.company.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindDifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> answer0 = new ArrayList<>();
        for(int i = 0; i < nums1.length ; i++){
            int count = 0;
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] != nums2[j]){
                    count++;
                }
                if(count == nums2.length){
                    answer0.add(nums1[i]);
                }
            }
        }

        List<Integer> answer1 = new ArrayList<>();
        for(int i = 0; i < nums2.length ; i++){
            int count = 0;
            for(int j = 0; j < nums1.length; j++){
                if(nums2[i] != nums1[j]){
                    count++;
                }
                if(count == nums1.length){
                    answer1.add(nums2[i]);
                }
            }
        }
        for(int i = 0; i < answer0.size()-1; i++){
            if(answer0.get(i) == answer0.get(i+1)){
                answer0.remove(i+1);
            }
        }
        for(int i = 0; i < answer1.size()-1; i++){
            if(answer1.get(i) == answer1.get(i+1)){
                answer1.remove(i+1);
            }
        }
        ans.add(answer0);
        ans.add(answer1);
        System.out.println(ans);
    }
}