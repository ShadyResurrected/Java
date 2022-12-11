package com.company.LeetCode.Recursion;

import java.util.ArrayList;

public class Subset_Sum {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] num = {1,2};
        int index = 0;
        int sum = 0;
        ArrayList<Integer> ans1 =  subsetRec(num,ans,index,sum);
        System.out.println(ans1);
    }

    static ArrayList<Integer> subsetRec(int[] num, ArrayList<Integer> ans, int index, int sum){
        if(index == num.length){
            ans.add(sum);
            return ans;
        }
        ArrayList<Integer> pick = subsetRec(num,ans,index+1,sum+num[index]);
        ArrayList<Integer> notPick = subsetRec(num,ans,index+1,sum);
        return ans;
    }
}
