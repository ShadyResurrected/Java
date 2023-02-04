package com.company.CodeChef;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SPILTPAIR {
    public static void main(String[] args) {
        long N = 104;
        String S = "" + N;
        String[] number = S.split("");
        List<String> combi = new ArrayList<>();
        for (int i = 0; i < number.length; i++) {
            for (int j = 0;j  < number.length; j++){
                if(i != j){
                    String toBeadded = number[j] + number[j];
                    combi.add(toBeadded);
                }
            }
        }
        int countEven = 0;
        int countOdd = 0;
        for (String k : combi){
            int possible = Integer.parseInt(k);
            if(possible%2 == 0){
                countEven++;
            }else
                countOdd++;
        }
        if(countEven >= 2 && countOdd >= 2){
            System.out.println("YES");
        }else
            System.out.println("NO");
        System.out.println(countEven);
        System.out.println(countOdd);
        System.out.println(combi);
    }
}
