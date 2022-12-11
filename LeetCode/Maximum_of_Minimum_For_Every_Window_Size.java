package com.company.LeetCode;

import java.util.Arrays;

public class Maximum_of_Minimum_For_Every_Window_Size {
    public static void main(String[] args) {
        int N = 7;
        int[] arr = {10,20,30,50,10,70,30};
        int[] ans1 = method1(N,arr);
        System.out.println(Arrays.toString(ans1));
    }

    static int[] method1(int N,int[] arr){
        int[] ans = new int[N];
        // Window of size from 1 to N
        for (int i = 1;i <= N;i++){
            int maxOfMin = Integer.MIN_VALUE;
            for(int j = 0;j <= N - i;j++){
                int min = arr[j];
                for(int k = 1;k < i;k++){
                        min = Math.min(min,arr[j+k]);
                }
                maxOfMin = Math.max(maxOfMin,min);
            }
            arr[i-1] = maxOfMin;
        }
        return ans;
    }
}
