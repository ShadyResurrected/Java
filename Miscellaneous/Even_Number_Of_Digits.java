package com.company.Miscellaneous;
// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
public class Even_Number_Of_Digits {
    public static void main(String[] args) {
        int[] arr = {12,345,2,6,7896};
//        System.out.println(evenDigits(arr));
//        evenDigits(arr);
    }

    static int evenDigits(int[] arr){
        int ans = 0;

//        for(int k : arr){
//            int count = 0;
//            while(k != 0){
//                k = k/10;
//                count++;
//            }
//            if(count%2 == 0){
//                ans++;
//            }
//        }

        for(int k : arr){
            int value = (int)Math.log10(k)+1;
//            System.out.println(value);
            if(value % 2 == 0){
                ans++;
            }
        }

        return ans;
    }
}
