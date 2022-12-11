package com.company.Miscellaneous;
//https://leetcode.com/problems/missing-number/submissions/
public class Missing_Number {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int missing = Search(arr);
        if (missing == -1) {
            System.out.println("Every element present");
        } else {
            System.out.println(missing);
        }
    }

    public int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i]; // This signifies the correct index and since we are starting from index 0 we don't have to subtract one
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else
                i++;
        }
        //Search for first missing number
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j) {
                return j;
            }
        }

        // If missing number is N
        return nums.length;
    }

    static int Search(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i]; // This signifies the correct index and since we are starting from index 0 we don't have to subtract one
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else
                i++;
        }
        //Search for first missing number
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != j) {
                return j;
            }
        }

        // If missing number is N
        return arr.length;
    }
}
