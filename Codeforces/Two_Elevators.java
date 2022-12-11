package com.company.Codeforces;

import java.util.Scanner;

public class Two_Elevators {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            int aElevator = in.nextInt();
            int bElevator = in.nextInt();
            int cElevator = in.nextInt();
            if(Math.abs(aElevator-1) < (Math.abs(bElevator-cElevator) + Math.abs(cElevator-1))){
                System.out.println(1);
            }else if(Math.abs(aElevator-1) > (Math.abs(bElevator-cElevator) + Math.abs(cElevator-1))){
                System.out.println(2);
            }else
                System.out.println(3);
        }
    }
}
