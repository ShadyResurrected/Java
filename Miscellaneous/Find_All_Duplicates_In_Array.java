package com.company.Miscellaneous;
// https://leetcode.com/problems/find-all-duplicates-in-an-array/
import java.util.ArrayList;
import java.util.List;

public class Find_All_Duplicates_In_Array {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        System.out.println(DuplicateArray(arr));
    }

    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]){
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            }else
                i++;
        }
        for(int j=0;j < nums.length;j++){
            if(nums[j] != j+1){
                list.add(nums[j]);
            }
        }
        return list;
    }

    static List<Integer> DuplicateArray(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i < arr.length){
            int correct = arr[i] - 1;
            if(arr[i] != arr[correct]){
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            }else
                i++;
        }
        for(int j=0;j < arr.length;j++){
            if(arr[j] != j+1){
                list.add(arr[j]);
            }
        }
        return list;
    }
}
