package com.company.LeetCode;

import java.util.Hashtable;
import java.util.Iterator;

// incomplete
public class Intersection_of_Two_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int intersectionCount = 0;
        Hashtable<Integer,Integer> htable = new Hashtable<>();
        for(int i = 0; i < nums1.length ; i++){
            htable.put(nums1[i],0);
        }
        for(int i = 0; i < nums2.length; i++){
            if(htable.containsKey(nums2[i]) && (htable.get(nums2[i]) != 1)){
                htable.put(nums2[i],1);
                intersectionCount++;
            }
        }
        Iterator<Integer> itr = htable.keySet().iterator();
        int[] IntersectArr = new int[intersectionCount];
        int count = 0;
        while(itr.hasNext()){
            int key = itr.next();
            if(htable.get(key) != 0){
                IntersectArr[count] = key;
                count++;
                System.out.println(key);
            }
        }
        System.out.println(htable);
        System.out.println(intersectionCount);
        for (int i = 0; i < IntersectArr.length; i++){
            System.out.println(IntersectArr[i]);
        }
    }
}
