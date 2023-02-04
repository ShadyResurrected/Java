package com.company.AtCoder.Contest244;

import java.util.Objects;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S1 = in.next();
        String S2 = in.next();
        String S3 = in.next();
        in.nextLine();
        String T1 = in.next();
        String T2 = in.next();
        String T3 = in.next();
        if(!Objects.equals(S1, T1) && !Objects.equals(S2, T2) && !Objects.equals(S3, T3)){
            System.out.println("Yes");
        }else if(S2.equals(T2) && S3.equals(T3)){
            System.out.println("Yes");
        }else if(S1.equals(T1) && S3.equals(T3)){
            System.out.println("Yes");
        }else if(S1.equals(T1) && S2.equals(T2)){
            System.out.println("Yes");
        }else
            System.out.println("No");
    }
}
