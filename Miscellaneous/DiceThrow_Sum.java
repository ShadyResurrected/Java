package com.company.Miscellaneous;

import java.util.ArrayList;

public class DiceThrow_Sum {
    public static void main(String[] args) {
//        CheckFactors("",4);
        System.out.println(CheckFactorsList("",4));
    }

    static void CheckFactors(String p,int target){
        if(target == 0){
            System.out.println(p);
            return;
        }

        for(int i = 1; i <= 6 && i <= target; i++){
            CheckFactors(p+i,target-i);
        }
    }

    static ArrayList<String> CheckFactorsList(String p, int target){
        if(target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        for(int i = 1; i <= 6 && i <= target; i++){
            ans.addAll(CheckFactorsList(p+i,target-i));
        }
        return ans;
    }
}
