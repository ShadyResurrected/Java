package com.company.CodingNinjas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Three_Sum {
    public static void main(String[] args) {
//        int[] arr = {-1,0,1,2,-1,-4};
        int[] arr = {-1,0,1,0};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int K = 0;

        // Brute force
        // Using three for loops and inserting them into hashSet so that the duplicate values are not inserted
        int row = 0;
        HashSet<ArrayList<Integer>> hSet = new HashSet<>();
        for(int i = 0; i < arr.length-2; i++){
            for(int j = i + 1; j < arr.length-1; j++){
                for(int k = j + 1; k < arr.length;k++){
                    if(arr[i] + arr[j] + arr[k] == K){
                        list.add(new ArrayList<>());
                        list.get(row).add(arr[i]);
                        list.get(row).add(arr[j]);
                        list.get(row).add(arr[k]);
                        Collections.sort(list.get(row));
                        if(hSet.contains(list.get(row))){
                           list.remove(list.get(row));
                        }else
                            hSet.add(list.get(row));
                        row++;
                    }
                }
            }
        }
        System.out.println(list);
    }
}
