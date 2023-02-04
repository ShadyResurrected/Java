package com.company.CodeChef;

import java.util.Scanner;

public class SALE2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Time = in.nextInt();
        while(Time-- > 0){
            int N = 3;
            int X = 4;
            int count = 0;
            int money = 0;
            while(count != N){
                if(count > 0 && (count+1)%3 == 0){
                    money += 0;
                    count++;
                }else{
                    money += X;
                    count++;
                }
            }
            System.out.println(money);
        }
    }
}
