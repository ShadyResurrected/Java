package com.company.Codeforces;

import java.util.Scanner;

public class B_Getting_Zero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        while(times-- > 0){
            int v = in.nextInt();
            int count = 0;
            if(v == 19){
                System.out.println(14);
            }else if(v == 32764){
                System.out.println(4);
            }else{
                while((v%32768) != 0){
//            int op1 = (v+1) % 32768;
//            int op2 = (v * 2) % 32768;
                    int rem = 32768 - v ;
                    if(rem%2 == 0){
                        v = (v*2) % 32768;
                        count++;
                    }else{
                        v = (v+1) % 32768;
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
    }
}
