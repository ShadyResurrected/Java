package com.company.LeetCode.Arrays;
// Incomplete
public class Sum_Of_All_Odd_length_Subarrays {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        long sum = 0;

        // Adding all the single elements
        for(int i = 0; i < arr.length; i++){
            sum += 2 * arr[i];
        }

        // Adding all the subarrays of odd length
        int prevIndex = 0;
        for(int i = 1; i < arr.length; i++){
            int length = i - prevIndex + 1;
            if(length%2 != 0){
                for(int j = prevIndex; j <= i; j++){
                    sum += arr[j];
                }
                prevIndex++;
            }
        }
        System.out.println(sum);
    }
}
