package com.company.HashMap;

import java.util.Iterator;

public class Hashtable {
    public static void main(String[] args) {
        java.util.Hashtable<Integer, String> ht = new java.util.Hashtable<>();
        ht.put(1,"A");
        ht.put(2,"B");
        ht.put(3,"C");
        ht.put(4,"D");

        // To print a specific value as defined by the key
        System.out.println(ht.get(3));

        // To print the whole hashtable
        System.out.println(ht);

        Iterator<Integer> itr = ht.keySet().iterator();
        while(itr.hasNext()){
            int key = itr.next();
            String mapValue = ht.get(key);
            System.out.println("KEY : " + key + " VALUE : " + mapValue);
        }
    }
}
