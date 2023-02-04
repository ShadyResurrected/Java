package com.company.LeetCode;

import java.util.*;

public class Minimum_Rounds_To_Complete_All_Tasks {
    public static void main(String[] args) {
//        int[] tasks = {2,2,3,3,2,4,4,4,4,4,4};
        int[] tasks = {69,65,62,64,70,68,69,67,60,65,69,62,65,65,61,66,68,61,65,63,60,66,68,66,67,65,63,65,70,69,70,62,68,70,60,68,65,61,64,65,63,62,62,62,67,62,62,61,66,69};
        int res = minimumRounds(tasks);
        System.out.println(res);
    }

    static int minimumRounds(int[] tasks) {
        Arrays.sort(tasks);

        HashMap<Integer,Integer> hMap = new HashMap<>();
        for(int i = 0;i < tasks.length; i++){
            int ele = tasks[i];
            if(hMap.containsKey(ele)){
                int counter = hMap.get(ele);
                hMap.put(ele,counter+1);
            }else hMap.put(ele,1);
        }

        int minRounds = 0;
        for(int i = 0;i < tasks.length; i++){
            int ele = tasks[i];
            int valid = hMap.get(ele);
            if(valid >= 2){
                if((valid%5) == 0){
                    int increase = ((valid/5)*5) - 1;
                    minRounds += (valid/5)*2;
                    i += increase;
                    int counter = hMap.get(ele);
                    hMap.put(ele,counter-increase);
                }else if((valid%3) == 0){
                    int increase = (valid/3) * 3 - 1;
                    minRounds += (valid/3);
                    i += increase;
                    int counter = hMap.get(ele);
                    hMap.put(ele,counter-increase);
                }else if((valid%2) == 0){
                    int increase = (valid/2) * 2 - 1;
                    minRounds += (valid/2);
                    i += increase;
                    int counter = hMap.get(ele);
                    hMap.put(ele,counter-increase);
                }
            }else return -1;
        }
        return minRounds;
    }
}
