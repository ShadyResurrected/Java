package com.company.AtCoder.Contest255;
// Incomplete
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();

        int C = in.nextInt();
        int D = in.nextInt();

        double TakashiSec = B/60.0;
        double AokiSec = (D/60.0)+(1.0/60.0);

        double TakashiTotal = A + TakashiSec;
        double AokiTotal = C + AokiSec;
        if(AokiTotal >= 24){
            AokiTotal = 24 - AokiTotal;
        }

        if(TakashiTotal < AokiTotal){
            System.out.println("Takashi");
        }else
            System.out.println("Aoki");
    }
}
