package com.company.DP;

import java.util.Arrays;

public class House_Robber_2 {
    public static void main(String[] args) {
        int[] valueInHouse = {2,3,2};
//      if(valueInHouse.length == 1) return valueInHouse[0]; Edge case when there is only one element in the array
        int N = valueInHouse.length-1;
        long[] dpArr1 = new long[valueInHouse.length];
        long[] dpArr2 = new long[valueInHouse.length];
        int[] temp1 = new int[valueInHouse.length];
        int[] temp2 = new int[valueInHouse.length];
        Arrays.fill(dpArr1,-1);
        Arrays.fill(dpArr2,-1);
        for(int i = 0;i < valueInHouse.length;i++){
            if(i != 0) temp1[i] = valueInHouse[i];
            if(i != valueInHouse.length-1) temp2[i] = valueInHouse[i];
        }
        long maxSum1 = FindSum2(N,temp1,dpArr1);
        long maxSum2 = FindSum2(N,temp2,dpArr2);
        System.out.println(Math.max(maxSum1,maxSum2));
    }

    public static long FindSum2(int index,int[] arr,long[] dpArr){
        if(index == 0) return arr[0];
        if(index < 1) return 0; // it means no element is selected
        if(dpArr[index] != -1) return dpArr[index];
        long pick = arr[index] + FindSum2(index-2,arr,dpArr);
        long nonPick = FindSum2(index-1,arr,dpArr);
        return dpArr[index] = Math.max(pick,nonPick);
    }
}
