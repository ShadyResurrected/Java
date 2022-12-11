package com.company.CodeChef;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class EQPAIR {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            HashMap<Integer,Long> hMap = new HashMap<>();
            int lengthArr = in.nextInt();
            for (int i = 0;i < lengthArr;i++){
                int element = in.nextInt();
                if(hMap.containsKey(element)){
                    long count = hMap.get(element);
                    hMap.put(element,count+1);
                }else
                    hMap.put(element,1l);
            }
            long count = 0;
            Iterator<Integer> itr = hMap.keySet().iterator();
            while(itr.hasNext()){
                int element = itr.next();
                if(hMap.get(element) > 2){
                    count += Combinations(hMap.get(element));
                }else if(hMap.get(element) == 2)
                    count += 1;
            }
            System.out.println(count);
        }
    }

    private static long Combinations(Long integer) {
        return (integer * (integer-1)) / 2;
    }
}
