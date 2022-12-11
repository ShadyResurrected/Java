package com.company.Miscellaneous;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakValueInMountainArray {
    public static void main(String[] args){
        int[] arr = {24,69,100,99,79,78,67,36,26,19};
//        System.out.println(PeakIndex(arr));
    }
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int mid = start + (end-start)/2;
            if(arr[mid] > arr[mid+1]){
                //Decreasing part of the array
                //this may be the ans, but look at left
                end = mid;
            } else if(arr[mid] < arr[mid+1]){
                //Increasing part of the array
                start = mid + 1;
            }
        }
        // Since start and end are always pointing to the best possible answer thus we return start or end.
        return start;
    }
}
