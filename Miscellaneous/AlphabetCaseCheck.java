package com.company.Miscellaneous;

import java.util.Scanner;

public class AlphabetCaseCheck {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char c1 = input.next().trim().charAt(0);
        if (c1 >= 'a' && c1 <= 'z'){
            System.out.println("Lowercase");
        } else {
            System.out.println("Uppercase");
        }
    }
}
