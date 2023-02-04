package com.company.LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = new int[2];
        // Brute Force Method
        for(int i = 0; i < nums.length; i++){
            int anotherNum = target - nums[i];
            for(int j = 0; j < nums.length; j++){
                if(i != j && anotherNum == nums[j]){
                    System.out.println("Entered at: " + j);
                    ans[0] = i;
                    ans[1] = j;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(ans));

        // Optimal Approach Using HashMap
        int[] ans2 = new int[2];
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int anotherNum  = target - nums[i];
            if(hmap.containsKey(anotherNum)){
                ans2[0] = hmap.get(anotherNum);
                ans2[1] = i;
            }else{
                hmap.put(nums[i],i);
            }
        }
        System.out.println(Arrays.toString(ans2));
        int[] ans3 = Arrays.copyOf(ans,ans2.length);
    }

}
