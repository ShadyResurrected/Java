package com.company.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = new ArrayList<>();
        // Optimal Approach
        int target = 0;
        int row = 0;
        // For edge cases
//        if(nums == null || nums.length < 3){
//            return list;
//        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length - 1; j++){
                // Using binary search, searching the remaining array
                int rem_sum = target - (nums[i] + nums[j]);
                int start = j + 1;
                int end = nums.length - 1;
                while(start <= end){
                    int mid = (start+end)/2;
                    if(nums[mid] < rem_sum){
                        start = mid + 1;
                    }else if(nums[mid] > rem_sum){
                        end = mid - 1;
                    }else{
                        list.add(new ArrayList<>());
                        list.get(row).add(nums[i]);
                        list.get(row).add(nums[j]);
                        list.get(row).add(rem_sum);
                        row++;
                        break;
                    }
                }

                // Jumping the duplicate elements
                while(j < nums.length-1 && nums[j+1] == nums[j]){
                    j++;
                }
            }

            // Jumping the duplicate elements
            while(i < nums.length -1 && nums[i+1] == nums[i]){
                i++;
            }
        }

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

//        return list;
    }
}
