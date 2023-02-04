package com.company.HashMap;

import java.util.HashMap;

public class Hashmap {
    // It has no specific order
    public static void main(String[] args) {
        HashMap<String, Integer> hmap = new HashMap<>();

        hmap.put("A", 2300);
        hmap.put("B", 2100);
        hmap.put("C", 2000);
        hmap.put("D", 1900);
        hmap.put(null, 2800);

        System.out.println(hmap);
    }
}
