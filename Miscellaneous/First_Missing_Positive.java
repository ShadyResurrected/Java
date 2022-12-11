package com.company.Miscellaneous;

public class First_Missing_Positive {
    public static void main(String[] args) {
        int[] arr = {7,8,9,10,11,12};
        System.out.println(FirstMissing(arr));
    }


    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else
                i++;
        }

        for(int j =0;j<nums.length;j++){
            if(nums[j] != j+1){
                return j+1;
            }
        }

        return nums.length + 1;
    }

    static int FirstMissing(int[] arr){
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else
                i++;
        }

        for(int j =0;j<arr.length;j++){
            if(arr[j] != j+1){
                return j+1;
            }
        }

        return arr.length + 1;
    }
}
