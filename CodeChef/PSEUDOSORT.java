package com.company.CodeChef;

import java.util.ArrayList;
import java.util.Scanner;

public class PSEUDOSORT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            long lengthArr = in.nextLong();
            ArrayList<Long> arrSort = new ArrayList<Long>();
            for (int i = 0; i < lengthArr; i++){
                arrSort.add(in.nextLong());
            }
            for(int i = 1; i < lengthArr-1 ; i++){
                if((arrSort.get(i) > arrSort.get(i+1))){
                    long temp = arrSort.get(i);
                    arrSort.set(i,arrSort.get(i+1));
                    arrSort.set(i+1,temp);
                }
            }
            long length = 0;
            for(int i = 0; i < lengthArr-1 ; i++){
                if((arrSort.get(i) <= arrSort.get(i+1))){
                    length++;
                }
            }
            System.out.println(length);
            if(length == lengthArr-1){
                System.out.println("YES");
            }else
                System.out.println("NO");
        }
    }
}
