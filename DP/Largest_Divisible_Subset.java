package com.company.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        int[] arr = {1,16,7,8,4};
        Arrays.sort(arr);
        ArrayList<Integer> dp = new ArrayList<>();
        for(int i = 0;i < arr.length;i++) dp.add(1);

        ArrayList<Integer> hash = FindSubsets(0,arr,dp);
        System.out.println(hash);

        int ans = -1;
        int lastIndex =-1;

        for(int i=0; i<=arr.length-1; i++){
            if(dp.get(i)> ans){
                ans = dp.get(i);
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);

        while(hash.get(lastIndex) != lastIndex){ // till not reach the initialization value
            lastIndex = hash.get(lastIndex);
            temp.add(arr[lastIndex]);
        }

        // reverse the array

        System.out.print("The subsequence elements are ");

        for(int i=temp.size()-1; i>=0; i--){
            System.out.print(temp.get(i)+" ");
        }
    }

    static ArrayList<Integer> FindSubsets(int index,int[] arr,ArrayList<Integer> dp){
        ArrayList<Integer> hash = new ArrayList<>();
        for(int i = 0;i < arr.length;i++) hash.add(i);

        for (int i = 1;i < arr.length;i++){
            for(int prev_element = 0;prev_element < i;prev_element++){
                if(arr[i]%arr[prev_element] == 0 && dp.get(i) < 1 + dp.get(prev_element)){
                    dp.set(i,1+dp.get(prev_element));
                    hash.set(i,prev_element);
                }
            }
        }
        return hash;
    }
}
