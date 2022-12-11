package com.company.Miscellaneous;

public class Binary_Search_using_Recursion {
    public static void main(String[] args) {
        int[] arr= {4,12,23,34,44,54,67,75};
        int target = 44;
        System.out.println(search(arr,target,0,arr.length-1));
    }

    static int search(int[] arr,int target,int start,int end){
        // base condition
        if(start > end){
            return -1;
        }
        int mid = start + (end-start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid] > target){
            return search(arr,target,start,mid-1);
        }else
            return search(arr,target,mid+1,end);
    }
}
