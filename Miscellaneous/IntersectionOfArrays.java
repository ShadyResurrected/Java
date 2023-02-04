package com.company.Miscellaneous;

import java.util.Arrays;

public class IntersectionOfArrays {
    public static void main(String[] args){
        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        int[] ans = {-1,-1};
        int target = 0;
        for(int i=0;i<num1.length;i++){
            target = num1[i];
            int result = Search(num2,target);
            if(result == -1){
               return;
            }else if(target == num2[result]){
                ans[0] = num2[result];
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    static int Search(int[] arr,int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] < target){
                start = mid + 1;
            }else if(arr[mid] > target){
                end = mid - 1;
            } else{
                return mid;
            }
        }
        return -1;
    }
}
