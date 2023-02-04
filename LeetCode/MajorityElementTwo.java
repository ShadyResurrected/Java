package com.company.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MajorityElementTwo {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        ArrayList<Integer> list = new ArrayList<>();
        int countCriteria = (int)Math.floor(nums.length)/3;
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            hmap.put(nums[i],0);
        }
        for(int i = 0; i < nums.length; i++){
            int count = hmap.get(nums[i]);
            hmap.put(nums[i],count+1);
        }
        Iterator<Integer> itr = hmap.keySet().iterator();
        while(itr.hasNext()){
            int key = itr.next();
            if(hmap.get(key) > countCriteria){
                list.add(key);
            }
        }
        System.out.println(hmap);
        System.out.println(list.get(0));
    }
}
