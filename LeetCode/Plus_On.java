package com.company.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class Plus_On {
    public static void main(String[] args) {
        long sum = 0;
        int[] digits = {9,8,7,6,5,4,3,2,1,9};
        int[] arr = Arrays.copyOf(digits,digits.length+1);
        if(digits[digits.length-1] == 9){
            long length = digits.length - 1;
            for(int i = 0; i < digits.length; i++){
                sum += (digits[i] * (long)(Math.pow(10,length-i)));
            }
            sum += 1;
            System.out.println(sum);
            ArrayList<Integer> list = new ArrayList<>();
            while(sum > 0){
                int digit = (int)(sum%10);
                list.add(digit);
                sum = sum / 10;
            }
            // Copying into new array
            int[] Ansarr = new int[list.size()];
            for(int i = 0; i < Ansarr.length; i++){
                Ansarr[i] = list.get(i);
            }
            // Reversing the elements of the array
            int start = 0;
            int end = Ansarr.length - 1;
            while(start < end){
                int temp = Ansarr[start];
                Ansarr[start] = Ansarr[end];
                Ansarr[end] = temp;
                start++;
                end--;
            }
        }else{
            digits[digits.length-1] += 1;
        }
//        System.out.println(Arrays.toString(arr));
    }
}
