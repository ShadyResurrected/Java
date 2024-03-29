package com.company.LeetCode;

import java.util.*;

public class Sliding_Window_Maximum {
    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 5;
    }

    // Optimised Approach
    private static void Method2(int k, int[] nums, ArrayList<Integer> res,Deque<Integer> deque) {
        // we maintain the deque in the decreasing order
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(!deque.isEmpty() && deque.getFirst() == i-k){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k-1) {
                res.add(nums[deque.getFirst()]);
                index++;
            }
        }
    }

    // Brute Force Approach
    static void Method1(int k,int[] nums,ArrayList<Integer> list){
        for(int i = 0;i < nums.length-k;i++){
            int max = Integer.MIN_VALUE;
            for(int j = i;j < i + k;j++){
                max = Math.max(max,nums[j]);
            }
            list.add(max);
        }
        int[] ans = new int[list.size()];
        for(int i = 0;i < list.size();i++){
            ans[i] = list.get(i);
        }
    }
}
