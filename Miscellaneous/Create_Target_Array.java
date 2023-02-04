package com.company.Miscellaneous;

import java.util.Arrays;

public class Create_Target_Array {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,0};
        int[] index = {0,1,2,3,0};
        System.out.println(Arrays.toString(CreateTarget(nums,index)));
    }

//    public int[] createTargetArray(int[] nums, int[] index) {
//        int[] target = new int[index.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (i <= nums.length - 1 && target[index[i]] != 0) {
//                for (int j = nums.length - 1; j > index[i]; j--) {
//                    int temp = target[j];
//                    target[j] = target[j-1];
//                    target[j-1] = temp;
//                }
//                target[index[i]] = nums[i];
//            } else
//                target[index[i]] = nums[i];
//        }
//
//        return target;
//    }

    static int[] CreateTarget(int[] nums,int[] index) {
        int[] target = new int[index.length];
        for (int i = 0; i < nums.length; i++) {
            if (i <= nums.length - 1 && target[index[i]] != 0 || target[index[i]] == 0) {
                for (int j = nums.length - 1; j > index[i]; j--) {
                    int temp = target[j];
                    target[j] = target[j-1];
                    target[j-1] = temp;
                }
                target[index[i]] = nums[i];
            } else
                target[index[i]] = nums[i];
        }

        return target;
    }
}
