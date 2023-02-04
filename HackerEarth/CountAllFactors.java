package com.company.HackerEarth;

import java.util.HashMap;
import java.util.Scanner;

public class CountAllFactors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lengthArr = in.nextInt();
        HashMap<Integer,Integer> hMapPrime = new HashMap<>();
        for (int i = 0;i < lengthArr;i++){
            hMapPrime.put(in.nextInt(),1);
        }
        int Queries = in.nextInt();
        while(Queries-- > 0){
            int count = 0;
            int numberK = in.nextInt();
            if(isPrime(numberK)){
                if(hMapPrime.containsKey(numberK)){
                    count++;
                }
            }else{
                for (int i = 2;i <= numberK; i++){
                    if(numberK%i == 0){
                        for (int values : hMapPrime.keySet()){
                            if(i%values == 0){
                                count++;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

    static boolean isPrime(int num){
        if (num <= 1) {
            return false;
        }
        int c = 2;
        while(c * c <= num){
            if(num%c == 0){
                return false;
            }
            c++;
        }
        return c * c > num;
    }
}
