package com.company.LeetCode;

import java.util.Arrays;

public class ReversePairs {
    public static void main(String[] args) {
//        int[] arr = {40,25,19,12,9,6,2};
        int[] arr = {2,4,3,5,1};
        int ans = ReverseCount(arr);
        System.out.println(ans);
    }

    static int ReverseCount(int[] arr){
        int count = 0;
        if(arr.length == 1){
            return count;
        }

        int mid = arr.length/2;

        // Now breaking the array into two parts
        count += ReverseCount(Arrays.copyOfRange(arr,0,mid));
        count += ReverseCount(Arrays.copyOfRange(arr,mid,arr.length));


        // While merging, we will the count the number of reverse pairs
        return count += merge(Arrays.copyOfRange(arr,0,mid),Arrays.copyOfRange(arr,mid,arr.length));
    }

    static int merge(int[] left, int[] right){
        int count = 0;
        int leftP = 0;
        int rightP = 0;
        Arrays.sort(left);
        Arrays.sort(right);

        // Counting the pairs
        int i = 0;
        int j = 0;
        while(i < left.length){
            while(j < right.length && left[i] > 2*(long)(right[j]))
                j++;
            count += j;
            i++;
        }


        return count;
    }
}
