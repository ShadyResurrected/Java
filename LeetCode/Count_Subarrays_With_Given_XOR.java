package com.company.LeetCode;

import java.util.HashMap;
// Check the brute force approach
public class Count_Subarrays_With_Given_XOR {
    public static void main(String[] args) {
        // Brute force
        // Using three loops to iterate over the array
        int[] arr = {4,2,2,6,4};
        int x = 6;
        int count = 0;
        for(int i = 0; i < arr.length ; i++){
            for(int j = i; j < arr.length; j++){
                int value = 0;
                for(int k = i; k < j; k++){
                    value = arr[k] ^ value;
                }
                if(value == x){
                    count++;
                }
            }
        }
        System.out.println(count);


        // Using two for loops
        int count1 = 0;
        for (int i = 0; i < arr.length; i++){
            int value = 0;
            for (int j = i; j < arr.length; j++){
                value ^= arr[j];
                if(value == x){
                    count1++;
                    break;
                }
            }
        }
        System.out.println(count1);

        // Optimal Solution using HashMap
        // Using the approach => Y = XOR ^ X
        HashMap<Integer,Integer> hmap = new HashMap<>(); // Hashmap will store the frequency of XOR sum of subArrays
        int XOR = 0;
        int count2 = 0;
        for(int i = 0; i < arr.length; i++){
            XOR ^= arr[i];
            // Checking whether the sum of subArray is equal to x or not
            if(XOR == x){
                count2++;
            }
            // Y is the prefix sum
            int Y = XOR ^ x;
            if(hmap.containsKey(Y)){
                count2 += hmap.get(Y);
            }

            if(hmap.containsKey(XOR)){
                int frequency = hmap.get(XOR);
                hmap.put(XOR,frequency+1);
            }else
                hmap.put(XOR,1);
        }
        System.out.println(count2);
    }
}
