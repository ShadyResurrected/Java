package com.company.LeetCode;

import java.util.*;

public class Fruit_Into_Baskets {
    public static void main(String[] args) {
        int[] fruits = {0,1,2,2};
        System.out.println(totalFruit(fruits));
    }
    static int totalFruit(int[] fruits) {
        int res = HelperFunc1(fruits);
        return res;
    }

    static int HelperFunc(int index,int[] fruits,HashSet<Integer> hSet){
        int count = 0;
        for(int i = index;i < fruits.length; i++){
            int curFruit = fruits[i];
            hSet.add(curFruit);
            if(hSet.size() == 3) break;
            count++;
        }
        return count;
    }

    static int HelperFunc1(int[] fruits){
        HashSet<Integer> hSet = new HashSet<>();

        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0;i < fruits.length; i++){
            int curFruit = fruits[i];
            hSet.add(curFruit);
            if(hSet.size() == 3){
                hSet.clear();
                max = Math.max(count,max);
                i -= count;
                count = 0;
                continue;
            }
            count++;
        }
        return Math.max(max,count);
    }

    static int HelperFunc3(int[] fruits){
        int[] counts = new int[fruits.length];
        int typeCount = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        int currMax = 0;

        for(int i = 0;i < counts.length; i++){
            int currFruit = fruits[i];
            if(counts[currFruit] == 0) typeCount++;
            counts[currFruit]++;
            currMax++;

            while(typeCount > 2 && start < i){
                counts[fruits[start]]--;
                if(counts[fruits[start]] == 0) typeCount--;
                start++;
                currMax--;
            }

            max = Math.max(max,currMax);
        }

        return max;
    }
}
