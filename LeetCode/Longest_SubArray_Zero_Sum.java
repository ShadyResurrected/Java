package com.company.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;

public class Longest_SubArray_Zero_Sum {
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};

        // Brute Force Method
        int maxCount = 0;
        for(int i = 0; i < arr.length ; i++){
            for(int j = i; j < arr.length; j++){
                int sum = 0;
                ArrayList<Integer> list = new ArrayList<>();
                for(int k = i ; k < j+1; k++){
                    sum += arr[k];
                    list.add(arr[k]);
                }
                int count = list.size();
                if(sum == 0){
                    if(count > maxCount){
                        maxCount = count;
                    }
                }
            }
        }
        System.out.println(maxCount);


        // Using HashMap
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(sum == 0){  // if the sum is zero then calculate the length of current subarray
                int count = i + 1;
                if(count > maxLength){
                    maxLength = count;
                }
            }

            // if does not contain the sum then insert into the hashmap
            if(!hmap.containsKey(sum)){
                hmap.put(sum,i);
            }else{                  // else if the value in hashmap matches then it means zero value is added in the existing subarray of sum present in the subarray
                int count = Math.abs(hmap.get(sum) - i);
                if(count > maxLength){
                    maxLength = count;
                }
            }
        }
        System.out.println(maxLength);
    }
}
