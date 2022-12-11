package com.company.Miscellaneous;

public class PatternUsing_Recursion {
    public static void main(String[] args) {
//        printPattern(4);
//        printPattern1(4,0);
        printPattern3(4,0);
    }

    static void printPattern(int n){
        if(n == 0){
            return;
        }
        for(int i = 0; i < n; i++){
            System.out.print("*" + " ");
        }
        System.out.println();
        printPattern(n-1);
    }

    static void printPattern1(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            System.out.print("*" + " ");
            printPattern1(row,col+1);
        }else{
            System.out.println();
            printPattern1(row-1,0);
        }
    }
    static void printPattern3(int row, int col){
        if(row == 0){
            return;
        }
        if(col < row){
            printPattern3(row,col+1);
            System.out.print("*" + " ");
        }else{
            printPattern3(row-1,0);
            System.out.println();
        }
    }
}
