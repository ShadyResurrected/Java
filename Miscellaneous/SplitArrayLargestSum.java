package com.company.Miscellaneous;

public class SplitArrayLargestSum {
    public static void main(String[] args){
        int[] arr = {7,2,5,10,8};
        int start = 0;
        int end = 0;
        int m = 2;
    }

    public int splitArray(int[] arr, int m) {
        int start = 0;
        int end = 0;
        int MAX = Integer.MIN_VALUE;
        // Setting the value of max and min possible value of subarrays
        for(int i:arr){
            if(i > MAX){
                MAX = i;
            }
            end += i;
        }
        start = MAX;
        // binary search
        while(start < end){
            int mid = start + (end-start)/2;

            // calculate how many pieces you can divide this to
            int sum=0;
            int pieces=1;
            for(int a: arr){
                if(sum + a > mid){
                    // You cannot add this in subarray, so make a new one
                    // When a new subarray is created, sum = num
                    sum = a;
                    pieces++;
                }else{
                    sum += a;
                }
            }

            if(pieces > m){
                start = mid + 1;
            } else{
                end = mid;
            }
        }

        return start;
    }


    static int SplitArray(int[] arr,int start,int end,int m){
        int MAX = Integer.MIN_VALUE;
        // Setting the value of max and min possible value of subarrays
        for(int i:arr){
            if(i > MAX){
                MAX = i;
            }
            end += i;
        }
        start = MAX;
        // binary search
        while(start < end){
            int mid = start + (end-start)/2;

            // calculate how many pieces you can divide this to
            int sum=0;
            int pieces=1;
            for(int a: arr){
                if(sum + a > mid){
                    // You cannot add this in subarray, so make a new one
                    // When a new subarray is created, sum = num
                    sum = a;
                    pieces++;
                }else{
                    sum += a;
                }
            }

            if(pieces > m){
                start = mid + 1;
            } else{
                end = mid;
            }
        }

        return start;
    }
}
