package com.company.LeetCode.Weekly_Contest_313;

import java.util.HashMap;
import java.util.HashSet;

public class Q1 {
    public static void main(String[] args) {
        int a = 25;
        int b = 30;
        HashMap<Integer,Integer> hMap = new HashMap<>();
        int num1 = Math.max(a,b);
        int num2 = Math.min(a,b);
        for (int i = 1;i <= num1;i++){
            if(num1%i == 0) hMap.put(i,1);
        }
        int common = 0;
        for(int ele : hMap.keySet()){
            if(num2 >= ele && num2 % ele == 0) common++;
        }
        System.out.println(common);
    }
}
