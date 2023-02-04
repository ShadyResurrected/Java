package com.company.CodeChef;

import java.util.Scanner;

public class EQUIVALENT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Timess = in.nextInt();
        while(Timess-- > 0){
            int NumberA = in.nextInt();
            int NumberB = in.nextInt();
            int smallestSquare = NumberA * NumberA;
            int quotient = smallestSquare / NumberB;
            if(quotient % NumberB == 0){
                if(CheckType(quotient,NumberB)) System.out.println("YES");
                else System.out.println("NO");
            }else System.out.println("NO");
        }
    }
    static boolean CheckType(int quotient,int NumberB){
        while(quotient >  1){
            quotient /= NumberB;
        }
        if(quotient == 1) return true;
        return false;
    }
}
