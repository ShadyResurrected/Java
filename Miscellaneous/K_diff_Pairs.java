package com.company.Miscellaneous;

public class K_diff_Pairs {
    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
        System.out.println(diff(nums,k));
    }

    static int diff(int[] nums,int k){
        int count = 0;
        int checkI = 0;
        int checkJ = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = nums.length-1; j > i; j--){
                if(Math.abs(nums[i] - nums[j]) == k && nums[j] != checkJ && nums[i] != checkI){
                    count++;
                    checkJ = nums[j];
                    checkI = nums[i];
                }
            }
        }
        return count;
    }
}
