package com.company.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class MajorityElement {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int[] arr = {2,2,1,1,1,2,2};
        int majorityScale = arr.length/2;
        for(int i = 0; i < arr.length ; i++){
            hmap.put(arr[i],0);
        }
        for(int i = 0; i < arr.length ; i++){
            int count = hmap.get(arr[i]);
            hmap.put(arr[i],count+1);
        }
        Iterator<Integer> itr = hmap.keySet().iterator();
        while(itr.hasNext()){
            int key = itr.next();
            if(hmap.get(key) > majorityScale){
                System.out.println(key);
            }
        }

        System.out.println(hmap);
    }
}
