package com.company.CodingNinjas;

import java.util.HashMap;

public class Missing_And_Repeating_Numbers {
    public static void main(String[] args) {
        int[] arr = {1 ,3 ,5 ,4 ,4};

        // Using Frequency Array
        int[] freq = new int[arr.length+1];
        int repeat = 0;
        int missing = 0;
        for (int i = 0; i < arr.length; i++){
            freq[arr[i]] += 1;
        }
        for(int i = 1; i < freq.length;i++){
            if(freq[i] == 2){
                repeat = i;
            }else if(freq[i] == 0){
                missing = i;
            }
        }

        System.out.println(repeat);
        System.out.println(missing);
    }
}
