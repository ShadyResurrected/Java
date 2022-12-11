package com.company.Codeforces;

import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Times = in.nextInt();
        while(Times-- > 0){
            int rating = in.nextInt();
            if(rating <= 1399){
                System.out.println("Division 4");
            }else if(rating <= 1599 && rating >= 1400){
                System.out.println("Division 3");
            }else if(rating <= 1899 && rating >= 1600){
                System.out.println("Division 2");
            }else if(rating >= 1900){
                System.out.println("Division 1");
            }
        }
    }
}
