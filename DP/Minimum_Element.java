package com.company.DP;

import java.util.Arrays;

public class Minimum_Element {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 7;
        int[][] dpArr = new int[arr.length][target+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[arr.length][target+1];
        int[] prev = new int[target+1];

//      int minElements = FindElements(0,arr,target);
//      int minElements1 = FindElements1(arr.length-1,arr,target,dpArr);
//      if(minElements2 >= (int)1e9) return -1; // When the target cannot be achieved return -1
//      int minElements2 = FindElements2(arr,target,tabulated);
        int minElements3 = FindElements3(arr,target,prev);
        System.out.println(minElements3);
    }

    static int FindElements(int index,int[] arr,int target){
        if(index == 0){
            if(target % arr[0] == 0) return target/arr[0];
            return (int)1e9;
        }
        // Now picking and not picking the elements
        int pick = (int)1e9;
        if(arr[index] <= target) pick = 1 + FindElements(index,arr,target-arr[index]);
        int notPick = FindElements(index-1,arr,target);
        return Math.min(pick,notPick);
    }

    static int FindElements1(int index,int[] arr,int target,int[][] dpArr){
        if(index == 0){
            if(target % arr[0] == 0) return target/arr[0];
            return (int)1e9;
        }
        if(dpArr[index][target] != -1) return dpArr[index][target];
        // Now picking and not picking the elements
        int pick = (int)1e9;
        if(arr[index] <= target) pick = 1 + FindElements1(index,arr,target-arr[index],dpArr);
        int notPick = FindElements1(index-1,arr,target,dpArr);
        return dpArr[index][target] = Math.min(pick,notPick);
    }

    static int FindElements2(int[] arr,int target,int[][] tabulated){
        // Initialising the base condition
        for(int T = 0;T <= target;T++){
            if(T%arr[0] == 0) tabulated[0][T] = T/arr[0];
            else tabulated[0][T] = (int)1e9;
        }

        // Now traversing using two for loops
        for(int index = 1;index < arr.length;index++){
            for(int T = 0; T <= target;T++){
                int pick = (int)1e9;
                if(arr[index] <= T) pick = 1 + tabulated[index][T-arr[index]];
                int notPick = tabulated[index-1][T];
                tabulated[index][T] = Math.min(pick,notPick);
            }
        }
        return tabulated[arr.length-1][target];
    }

    static int FindElements3(int[] arr,int target,int[] prev){
        // Initialising the base condition
        for(int T = 0;T <= target;T++){
            if(T%arr[0] == 0) prev[T] = T/arr[0];
            else prev[T] = (int)1e9;
        }

        // Now traversing using two for loops
        for(int index = 1;index < arr.length;index++){
            int[] current = new int[target+1];
            for(int T = 0; T <= target;T++){
                int pick = (int)1e9;
                if(arr[index] <= T) pick = 1 + current[T-arr[index]];
                int notPick = prev[T];
                current[T] = Math.min(pick,notPick);
            }
            prev = current;
        }
        return prev[target];
    }
}
