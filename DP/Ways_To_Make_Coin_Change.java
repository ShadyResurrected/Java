package com.company.DP;

import java.util.Arrays;

public class Ways_To_Make_Coin_Change {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 4;
        int[][] dpArr = new int[arr.length][target+1];
        for (int[] row : dpArr) Arrays.fill(row,-1);
        int[][] tabulated = new int[arr.length][target+1];
        int[] prev = new int[target+1];

//      int denominations = FindChanges(0,arr,target);
//      int denominations1 = FindChanges1(0,arr,target,dpArr);
      int denominations2 = FindChanges2(arr,target,tabulated);
//        int denominations3 = FindChanges3(arr,target,prev);
        System.out.println(denominations2);
    }

    static int FindChanges(int index,int[] arr,int target){
        // Base Condition
        if(index == arr.length - 1){
            if(target%arr[arr.length-1] == 0) return 1;
            return 0;
        }
        // Now picking and not picking each element from the given denominations
        int pick = 0;
        if(arr[index] <= target) pick = FindChanges(index,arr,target-arr[index]);
        int notPick = FindChanges(index+1,arr,target);
        return pick + notPick;
    }

    static int FindChanges1(int index,int[] arr,int target,int[][] dpArr){
        // Base Condition
        if(index == arr.length - 1){
            if(target%arr[arr.length-1] == 0) return 1;
            return 0;
        }
        if(dpArr[index][target] != -1) return dpArr[index][target];
        // Now picking and not picking each element from the given denominations
        int pick = 0;
        if(arr[index] <= target) pick = FindChanges1(index,arr,target-arr[index],dpArr);
        int notPick = FindChanges1(index+1,arr,target,dpArr);
        return dpArr[index][target] = pick + notPick;
    }

    static int FindChanges2(int[] arr,int target,int[][] tabulated){
        // Base Condition
        for(int value = 0;value <= target;value++){
            if(value%arr[0] == 0) tabulated[0][value] = 1;
        }
        // Now picking and not picking the given elements in the array
        for(int index = 1;index < arr.length;index++){
            for(int value = 0; value <= target; value++){
                int pick = 0;
                if(arr[index] <= value) pick = tabulated[index][value-arr[index]];
                int notPick = tabulated[index-1][value];
                tabulated[index][value] = pick + notPick;
            }
        }

        return tabulated[arr.length-1][target];
    }

    static int FindChanges3(int[] arr,int target,int[] prev){
        // Base Condition
        for(int value = 0;value <= target;value++){
            if(value%arr[0] == 0) prev[value] = 1;
        }
        // Now picking and not picking the given elements in the array
        for(int index = 1;index < arr.length;index++){
            int[] current = new int[target+1];
            for(int value = 0; value <= target; value++){
                int pick = 0;
                if(arr[index] <= value) pick = current[value-arr[index]];
                int notPick = prev[value];
                current[value] = pick + notPick;
            }
            prev = current;
        }

        return prev[target];
    }
}
