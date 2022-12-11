package com.company.CompilerDesign;

import java.util.Arrays;

public class InputBuffer {
    static String str = "Birla Institute of Applied Sciences";
    public static void main(String[] args) {
        int count = 0;
        char[] arr1 = new char[8];
        char[] arr2 = new char[8];
        int result = TimesCounter(arr1,arr2,str,count);
        System.out.println(result-1);
    }
    static int length = str.length();
    static int Stri = 0;
    static int TimesCounter(char[] arr1, char[] arr2, String str,int count){
        if(length == 0){
            return count;
        }
        int i = 0;
        while(i < arr1.length && length != 0 ){
            arr1[i] = str.charAt(Stri);
            Stri++;
            length--;
            i++;
        }
        i = 0;
        count++;
        System.out.println(Arrays.toString(arr1));
        while(i < arr2.length && length != 0){
            arr2[i] = str.charAt(Stri);
            length--;
            Stri++;
            i++;
        }
        i = 0;
        count++;
        System.out.println(Arrays.toString(arr2));
        return TimesCounter(arr1,arr2,str,count--);
    }
}
