package com.company.LeetCode;

import java.util.HashMap;
import java.util.Iterator;

public class Number_of_Good_pairs {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,3};
        int pairs = 0;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i : arr){
            if(!hmap.containsKey(i)){
                hmap.put(i,1);
            }else{
                int count = hmap.get(i);
                pairs += count;
                hmap.put(i,count+1);
            }
        }
//        Iterator<Integer> itr = hmap.keySet().iterator();
//        while(itr.hasNext()){
//            int nextCount = itr.next();
//            if(nextCount >= 2){
//                if(nextCount%2 == 0){
//                    pairs += nextCount;
//                }else
//                    pairs = pairs + nextCount + 1;
//            }
//        }
        System.out.println(hmap);
        System.out.println(pairs);
    }
}
