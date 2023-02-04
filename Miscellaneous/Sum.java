package com.company.Miscellaneous;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        int num1 = input.nextInt();
//        int num2 = input.nextInt();
//        int sum = num1 + num2;
//        System.out.println("The sum of two numbers is " + sum);
        System.out.println(tirla("ZY"));
    }

    static int tirla(String columnTitle){
        int ans = 0;
        if(columnTitle.length() == 1){
            int equiChar = (columnTitle.charAt(0) - 65) + 1;
            return equiChar;
        }else{
            for(int i = 0; i < columnTitle.length(); i++){
                if(i == columnTitle.length()-1){
                    ans += ((columnTitle.charAt(i) - 65) + 1);
                    break;
                }
                int equichar = (columnTitle.charAt(i) - 65) + 1;
                ans += Math.pow(26,columnTitle.length()-i-1) * (equichar);
            }
        }

        return (ans);
    }
}
