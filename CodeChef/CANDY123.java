package com.company.CodeChef;

import java.util.Scanner;

public class CANDY123 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-- > 0){
            int Limak = in.nextInt();
            int Bob = in.nextInt();
        int currentQuantity = 1;
        while(Bob > -1 && Limak > -1){
            Limak -= currentQuantity;
            if(Limak < 0){
                break;
            }
            currentQuantity++;
            Bob -= currentQuantity;
            if(Bob < 0){
                break;
            }
            currentQuantity++;
        }
        if(Bob >= 0){
            System.out.println("Bob");
        }else if(Limak >= 0){
            System.out.println("Limak");
        }
                }

    }
}
