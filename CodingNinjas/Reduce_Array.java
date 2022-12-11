package com.company.CodingNinjas;

import java.util.Arrays;
import java.util.HashMap;

public class Reduce_Array {
    public static void main(String[] args) {
        int[] a = {6,8,4};
        Arrays.sort(a);
        HashMap<Integer,Integer> hMap = new HashMap<>();
        int ans = 0;
        for(int ele : a){
            if(ele%2 == 0){
                if(hMap.containsKey(ele)){
                    ans += hMap.get(ele);
                }else{
                    int count = 0;
                    while (ele > 0){
                        ele = ele/2;
                        count++;
                    }
                    hMap.put(ele,count);
                    ans += count;
                }
            }else{
                if(hMap.containsKey(ele)){
                    ans += hMap.get(ele);
                }else{
                    int count = 0;
                    while(ele > 0){
                        if(ele%2 == 1){
                            ele = (ele-1)/2;
                            count++;
                        }else{
                            ele = ele/2;
                            count++;
                        }
                    }
                    hMap.put(ele,count);
                    ans += count;
                }
            }
        }
        System.out.println(ans);
    }
}
