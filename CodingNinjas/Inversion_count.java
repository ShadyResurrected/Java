package com.company.CodingNinjas;

import java.util.Arrays;

public class Inversion_count {
    public static void main(String[] args) {
        int[] arr = {5,3,2,1,4};
        System.out.println(InversionPairs(arr));
    }

    static int InversionPairs(int[] arr){
        int count = 0;
        if(arr.length == 1){
            return count;
        }

        int mid = arr.length/2;

        count += InversionPairs(Arrays.copyOfRange(arr,0,mid));
        count += InversionPairs(Arrays.copyOfRange(arr,mid,arr.length));

        return count += merge(Arrays.copyOfRange(arr,0,mid),Arrays.copyOfRange(arr,mid,arr.length));
    }

    static int merge(int[] left, int[] right){
        int[] ans = new int[left.length + right.length];
        int lefts = 0;
        int rights = 0;
        int anss = 0;
        int count = 0;
        while(lefts < left.length && rights < right.length){
            if(left[lefts] < right[rights]){
                ans[anss] = left[lefts];
                lefts++;
            }else{
                ans[anss] = right[rights];
                rights++;
                count += left.length - lefts;
            }
            anss++;
        }

        while(lefts < left.length){
            ans[anss] = left[lefts];
            lefts++;
            anss++;
        }

        while(rights < right.length){
            ans[anss] = right[rights];
            rights++;
            anss++;
        }
        return count;
    }
}
