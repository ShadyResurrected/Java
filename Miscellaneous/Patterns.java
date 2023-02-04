package com.company.Miscellaneous;

public class Patterns {
    public static void main(String[] args) {
        Pattern28(5);
    }

    static void Pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            //for every row run col
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void Pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= n; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void Pattern3(int n) {
        for (int row = n; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void Pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    static void Pattern5(int n) {
//        for (int row = 1; row < 2 * n; row++) {
//            if (row <= n) {
//                for (int col = 1; col <= row; col++) {
//                    System.out.print("*");
//                }
//            } else {
//                for (int col = row; col < 2 * n; col++) {
//                    System.out.print("*");
//                }
//            }
//            System.out.println();
//        }
        for(int row=1;row < 2*n;row++){
            int totalCols = row <=n ? row : 2*n-row;
            for(int col=1;col <=totalCols;col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void Pattern6(int n){
        for (int row = 1; row <= n; row++) {
            for(int col = 1; col <= n; col++){
                if(col <= n-row){
                    System.out.print(" ");
                }else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
    static void Pattern7(int n){
        for (int row = 1; row <= n ; row++) {
            for (int col = 1; col <= n-row+1 ; col++) {

            }
        }
    }
    static void Pattern28(int n){
        for(int row = 1; row < 2* n; row++){
            int totalColsInRow = row < n ? row : 2*n - row;
            int spaces = n - totalColsInRow;
            for(int s=0;s<spaces;s++){
                System.out.print(" ");
            }
            for(int col = 1;col <= totalColsInRow; col++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
