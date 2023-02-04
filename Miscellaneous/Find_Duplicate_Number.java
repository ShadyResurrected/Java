package com.company.Miscellaneous;
//https://leetcode.com/problems/find-the-duplicate-number/
public class Find_Duplicate_Number {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(Duplicate(arr));
    }

//    public int findDuplicate(int[] nums) {
//        int ans = -1;
//        int i = 0;
//        while(i < nums.length){
//            int correct = nums[i] - 1;
//            if(nums[i] != nums[correct]){
//                int temp = nums[i];
//                nums[i] = nums[correct];
//                nums[correct] = temp;
//            } else
//                i++;
//        }
//
//        for(int j = 0;j < nums.length;j++){
//            if(nums[j] != j + 1){
//                ans = nums[j];
//                break;
//            }
//        }
//
//        for(int k:nums){
//            if(ans == k){
//                return ans;
//            }
//        }
//        return ans;
//    }



    // Second Method
        public int findDuplicate(int[] nums) {
        int ans = -1;
        int i = 0;
        while(i < nums.length){
            if(nums[i] != i+1){
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]){
                    int temp = nums[i];
                    nums[i] = nums[correct];
                    nums[correct] = temp;
                } else
                    return nums[i];
            }else
                i++;
        }
        return ans;
    }



    static int Duplicate(int[] arr){
//        int ans = -1;
//        int i = 0;
//        while(i < arr.length){
//            int correct = arr[i] - 1;
//            if(arr[i] != arr[correct]){
//                int temp = arr[i];
//                arr[i] = arr[correct];
//                arr[correct] = temp;
//            } else
//                i++;
//        }
//
//        for(int j = 0;j < arr.length;j++){
//            if(arr[j] != j + 1){
//                ans = arr[j];
//                break;
//            }
//        }
//
//        for(int k:arr){
//            if(ans == k){
//                return ans;
//            }
//        }
//        return ans;

        int ans = -1;
        int i = 0;
        while(i < arr.length){
            if(arr[i] != i+1){
                int correct = arr[i] - 1;
                if(arr[i] != arr[correct]){
                    int temp = arr[i];
                    arr[i] = arr[correct];
                    arr[correct] = temp;
                } else
                    return arr[i];
            }else
                i++;
        }
        return ans;


    }
}
